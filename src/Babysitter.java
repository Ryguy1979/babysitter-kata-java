import java.time.LocalTime;

public class Babysitter {
    public boolean startTime(String startTime) {
        LocalTime checkedTime = LocalTime.parse(startTime);
        LocalTime validStartTime = LocalTime.parse("16:59:59");

        return checkedTime.isAfter(validStartTime);
    }
}
