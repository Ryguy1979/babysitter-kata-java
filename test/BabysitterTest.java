import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class BabysitterTest {

    @Test
    void babysitterHasValidStartTime() {
        Babysitter babysitter = new Babysitter();
        assertTrue(babysitter.startTime("17:00:00"));
    }

    @Test
    void babysitterHasValidEndTime() {
        Babysitter babysitter = new Babysitter();
        assertTrue(babysitter.endTime("04:00:00"));
    }
}
