import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class BabysitterTest {

    @Test
    void babysitterHasValidStartTime() {
        Babysitter babysitter = new Babysitter();
        assertTrue(babysitter.startTime("17:00:00"));
    }
}
