import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

import static java.lang.Integer.parseInt;

public class Babysitter {

    private static final int BEDTIME = 20;

    public boolean startTime(int startHour, int startMinute) {
        LocalDateTime checkedTime = LocalDate.now().atTime(startHour, startMinute);

        return checkedTime.isAfter(LocalDate.now().atTime(17, 0).minus(1, ChronoUnit.SECONDS));
    }

    public boolean endTime(int startHour, int startMinute) {
        LocalDateTime checkedTime = LocalDate.now().plus(1, ChronoUnit.DAYS).atTime(startHour, startMinute);

        return checkedTime.isBefore(LocalDate.now().plus(1, ChronoUnit.DAYS).atTime(4, 0).plus(1, ChronoUnit.SECONDS));
    }

    public int getWageBeforeBedtime(String startTime, String endTime) {
        int babysitterWage = 0;

        String[] splitStart = startTime.split(":");
        int startHour = parseInt(splitStart[0]);
        int startMinute = parseInt(splitStart[1]);

        String[] splitEnd = endTime.split(":");
        int endHour = parseInt(splitEnd[0]);
        int endMinute = parseInt(splitEnd[1]);

        if (startTime(startHour, startMinute) && endTime(endHour, endMinute)) {
            if (endHour > BEDTIME || endHour <= 4) {
                endHour = BEDTIME;
            }

            babysitterWage += 12 * (endHour - startHour);
            return babysitterWage;
        }

        return babysitterWage;
    }

    public int getWageAfterBedtimeButBeforeMidnight(String startTime, String endTime) {
        int babysitterWage = 0;

        String[] splitStart = startTime.split(":");
        String[] splitEnd = endTime.split(":");

        int startHour = parseInt(splitStart[0]);
        int startMinute = parseInt(splitStart[1]);
        int endHour = parseInt(splitEnd[0]);
        int endMinute = parseInt(splitEnd[1]);

        if (startTime(startHour, startMinute) && endTime(endHour, endMinute)) {
            if (endHour <= 4) {
                endHour = 24;
            }

            if (endHour > BEDTIME) {
                babysitterWage = 8 * (endHour - BEDTIME);
            }
        }

        return babysitterWage;
    }

    public int getWageAfterMidnight(String startTime, String endTime) {
        int babysitterWage = 0;

        String[] splitStart = startTime.split(":");
        String[] splitEnd = endTime.split(":");

        int startHour = parseInt(splitStart[0]);
        int startMinute = parseInt(splitStart[1]);
        int endHour = parseInt(splitEnd[0]);
        int endMinute = parseInt(splitEnd[1]);

        if (startTime(startHour, startMinute) && endTime(endHour, endMinute)) {
            if (endHour > 0) {
                babysitterWage = 16 * endHour;
            }
        }

        return babysitterWage;
    }

    public int calculateWage(String startTime, String endTime) {
        int babysitterWage = 0;

        String[] splitStart = startTime.split(":");
        String[] splitEnd = endTime.split(":");

        int startHour = parseInt(splitStart[0]);
        int startMinute = parseInt(splitStart[1]);
        int endHour = parseInt(splitEnd[0]);
        int endMinute = parseInt(splitEnd[1]);

        if (startTime(startHour, startMinute) && endTime(endHour, endMinute)) {
            babysitterWage = getWageBeforeBedtime(startTime, endTime)
                    + getWageAfterBedtimeButBeforeMidnight(startTime, endTime)
                    + getWageAfterMidnight(startTime, endTime);
        }

        return babysitterWage;
    }
}
