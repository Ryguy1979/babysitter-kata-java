import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

import static java.lang.Integer.parseInt;

public class Babysitter {

    public boolean startTime(int startHour, int startMinute, int newDay) {
        LocalDateTime checkedTime = LocalDate.now().atTime(startHour, startMinute).plus(newDay, ChronoUnit.DAYS);
        LocalDateTime validStartTime = LocalDate.now().atTime(17, 0).minus(1, ChronoUnit.SECONDS);

        return checkedTime.isAfter(validStartTime);
    }

    public boolean endTime(int startHour, int startMinute, int newDay) {
        LocalDateTime checkedTime = LocalDate.now().atTime(startHour, startMinute).plus(newDay, ChronoUnit.DAYS);
        LocalDateTime validEndTime;
        if (newDay > 0) {
            validEndTime = LocalDate.now().atTime(4, 0).plus(1, ChronoUnit.SECONDS);
        } else {
            validEndTime = LocalDate.now().plus(1, ChronoUnit.DAYS).atTime(0, 0);
        }

        return checkedTime.isBefore(validEndTime);
    }

    public int calculatedWage(String startTime, String endTime) {
        int babysitterWage = 0;

        String[] splitStart = startTime.split(":");
        String[] splitEnd = endTime.split(":");

        int startHour = parseInt(splitStart[0]);
        int startMinute = parseInt(splitStart[1]);
        int endHour = parseInt(splitEnd[0]);
        int endMinute = parseInt(splitEnd[1]);

        if (startTime(startHour, startMinute, 0) && endTime(endHour, endMinute, 0)) {
            babysitterWage = 12 * (endHour - startHour);

            return babysitterWage;
        }

        return babysitterWage;
    }
}
