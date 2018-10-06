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
        assertTrue(babysitter.startTime("17:00:00"));
    }

    @Test
    void babysitterHasValidEndTime() {
        assertTrue(babysitter.endTime("04:00:00"));
    }

    @Test
    void babysitterIsPaidTwelveDollarsBeforeBedtime() {
        assertEquals(12, babysitter.calculatedWage("17:00:00", "18:00:00"));
    }
}
