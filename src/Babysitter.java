import java.time.LocalTime;

public class Babysitter {
    public boolean startTime(String startTime) {
        LocalTime checkedTime = LocalTime.parse(startTime);
        LocalTime validStartTime = LocalTime.parse("16:59:59");

        return checkedTime.isAfter(validStartTime);
    }

    public boolean endTime(String endTime) {
        LocalTime checkTime = LocalTime.parse(endTime);
        LocalTime validEndTime = LocalTime.parse("04:00:01");

        return checkTime.isBefore(validEndTime);
    }
}
