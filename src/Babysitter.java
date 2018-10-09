import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

public class Babysitter {

    private static final int BEDTIME = 20;

    public boolean validateStartTime(int startHour, int startMinute) {
        return LocalTime.of(startHour, startMinute).isAfter(LocalTime.of(17, 0).minus(1, ChronoUnit.SECONDS));
    }

    public boolean validateEndTime(int endHour, int endMinute, boolean nextDay) {
        return !nextDay || LocalTime.of(endHour, endMinute).isBefore(LocalTime.of(4, 0).plus(1, ChronoUnit.SECONDS));
    }

    public int getWageBeforeBedtime(LocalTime startTime, LocalTime endTime) {
        int babysitterWage = 0;

        int endHour = endTime.getHour();

        if (validateStartTime(startTime.getHour(), startTime.getMinute()) && validateEndTime(endHour, endTime.getMinute(), false)) {
            if (endHour > BEDTIME || endHour <= 4) {
                endHour = BEDTIME;
            }

            babysitterWage = 12 * (endHour - startTime.getHour());
            return babysitterWage;
        }

        return babysitterWage;
    }

    public int getWageAfterBedtimeButBeforeMidnight(LocalTime startTime, LocalTime endTime) {
        int babysitterWage = 0;

        int endHour = endTime.getHour();

        if (validateStartTime(startTime.getHour(), startTime.getMinute()) && validateEndTime(endHour, endTime.getMinute(), false)) {
            if (endHour <= 4) {
                endHour = 24;
            }

            if (endHour > BEDTIME) {
                babysitterWage = 8 * (endHour - BEDTIME);
            }
        }

        return babysitterWage;
    }

    public int getWageAfterMidnight(LocalTime startTime, LocalTime endTime) {
        int babysitterWage = 0;

        if (validateStartTime(startTime.getHour(), startTime.getMinute()) && validateEndTime(endTime.getHour(), endTime.getMinute(), true)) {
            if (endTime.getHour() > 0) {
                babysitterWage = 16 * endTime.getHour();
            }
        }

        return babysitterWage;
    }

    public int calculateWage(LocalTime startTime, LocalTime endTime, boolean nextDay) {
        int babysitterWage = 0;

        if (validateStartTime(startTime.getHour(), startTime.getMinute()) && validateEndTime(endTime.getHour(), endTime.getMinute(), nextDay)) {
            babysitterWage = getWageBeforeBedtime(startTime, endTime)
                    + getWageAfterBedtimeButBeforeMidnight(startTime, endTime)
                    + getWageAfterMidnight(startTime, endTime);
        }

        return babysitterWage;
    }
}
