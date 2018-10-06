import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BabysitterTest {

    private Babysitter babysitter;

    @BeforeEach
    void setUp() {
        babysitter = new Babysitter();
    }

    @Test
    void babysitterHasValidStartTime() {
        assertTrue(babysitter.startTime(17, 0, 0));
    }

    @Test
    void babysitterHasValidEndTime() {
        assertTrue(babysitter.endTime(4, 0, 0));
    }

    @Test
    void babysitterIsPaidTwelveDollarsBeforeBedtime() {
        assertEquals(12, babysitter.calculatedWage("17:00:00", "18:00:00"));
    }

    @Test
    void babysitterIsPaidTwelveDollarsPerHourBeforeBedtime() {
        assertEquals(36, babysitter.calculatedWage("17:00:00", "20:00:00"));
    }
}
