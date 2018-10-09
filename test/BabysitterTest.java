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
    void babysitterIsPaidTwelveDollarsInAnHourBeforeBedtime() {
        assertEquals(12, babysitter.getWageBeforeBedtime("17:00:00", "18:00:00"));
    }

    @Test
    void babysitterIsPaidThirtySixDollarsForThreeHoursBeforeBedtime() {
        assertEquals(36, babysitter.getWageBeforeBedtime("17:00:00", "20:00:00"));
    }

    @Test
    void babysitterIsPaidEightDollarsInAnHourAfterBedtime() {
        assertEquals(8, babysitter.getWageAfterBedtimeButBeforeMidnight("17:00:00", "21:00:00"));
    }

    @Test
    void babysitterIsPaidThirtyTwoDollarsBedtimeThroughMidnight() {
        assertEquals(32, babysitter.getWageAfterBedtimeButBeforeMidnight("17:00:00", "00:00:00"));
    }

    @Test
    void babysitterIsPaidSixteenDollarsInAnHourAfterMidnight() {
        assertEquals(16, babysitter.getWageAfterMidnight("17:00:00", "01:00:00"));
    }

    @Test
    void babysitterIsPaidSixtyFourDollarsFromMidnightToFour() {
        assertEquals(64, babysitter.getWageAfterMidnight("17:00:00", "04:00:00"));
    }

    @Test
    void babysitterIsNotPaidForFractionHoursBeforeBedtime() {
        assertEquals(0, babysitter.getWageBeforeBedtime("17:00:00", "17:30:00"));
    }

    @Test
    void babysitterIsPaidTwelveDollarsForAnHourAndAHalfBeforeBedtime() {
        assertEquals(12, babysitter.getWageBeforeBedtime("17:00:00", "18:30:00"));
    }

    @Test
    void babysitterIsPaidEightDollarsForAnHourAndAHalfBeforeMidnight() {
        assertEquals(8, babysitter.getWageAfterBedtimeButBeforeMidnight("17:00:00", "21:30:00"));
    }

    @Test
    void babysitterIsPaidSixteenDollarsForAnHourAndAHalfAfterMidnight() {
        assertEquals(16, babysitter.getWageAfterMidnight("17:00:00", "01:30:00"));
    }

    @Test
    void babysitterIsPaidEightyFourDollarsUntilOneAm() {
        assertEquals(84, babysitter.calculateWage("17:00:00", "01:00:00"));
    }

    @Test
    void babysitterIsPaidOneHundredDollarsUntilTwoAm() {
        assertEquals(100, babysitter.calculateWage("17:00:00", "02:00:00"));
    }

    @Test
    void babysitterIsPaidOneHundredThirtyTwoDollarsForAFullNight() {
        assertEquals(132, babysitter.calculateWage("17:00:00", "04:00:00"));
    }
}
