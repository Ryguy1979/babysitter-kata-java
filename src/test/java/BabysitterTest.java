import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.*;

public class BabysitterTest {

    private Babysitter babysitter;

    @BeforeEach
    void setUp() {
        babysitter = new Babysitter();
    }

    @Test
    void babysitterHasValidStartTime() {
        assertTrue(babysitter.validateStartTime(17, 0));
    }

    @Test
    void babysitterHasInvalidStartTime() {
        assertFalse(babysitter.validateStartTime(16, 59));
    }

    @Test
    void babysitterHasValidEndTime() {
        assertTrue(babysitter.validateEndTime(4, 0, true));
    }

    @Test
    void babysitterHasInvalidEndTime() {
        assertFalse(babysitter.validateEndTime(4, 1, true));
    }

    @Test
    void babysitterIsPaidTwelveDollarsInAnHourBeforeBedtime() {
        assertEquals(12, babysitter.getWageBeforeBedtime(LocalTime.parse("17:00:00"), LocalTime.parse("18:00:00")));
    }

    @Test
    void babysitterIsPaidThirtySixDollarsForThreeHoursBeforeBedtime() {
        assertEquals(36, babysitter.getWageBeforeBedtime(LocalTime.parse("17:00:00"), LocalTime.parse("20:00:00")));
    }

    @Test
    void babysitterIsPaidEightDollarsInAnHourAfterBedtime() {
        assertEquals(8, babysitter.getWageAfterBedtimeButBeforeMidnight(LocalTime.parse("17:00:00"), LocalTime.parse("21:00:00")));
    }

    @Test
    void babysitterIsPaidThirtyTwoDollarsBedtimeThroughMidnight() {
        assertEquals(32, babysitter.getWageAfterBedtimeButBeforeMidnight(LocalTime.parse("17:00:00"), LocalTime.parse("00:00:00")));
    }

    @Test
    void babysitterIsPaidSixteenDollarsInAnHourAfterMidnight() {
        assertEquals(16, babysitter.getWageAfterMidnight(LocalTime.parse("17:00:00"), LocalTime.parse("01:00:00")));
    }

    @Test
    void babysitterIsPaidSixtyFourDollarsFromMidnightToFour() {
        assertEquals(64, babysitter.getWageAfterMidnight(LocalTime.parse("17:00:00"), LocalTime.parse("04:00:00")));
    }

    @Test
    void babysitterIsNotPaidForFractionHoursBeforeBedtime() {
        assertEquals(0, babysitter.getWageBeforeBedtime(LocalTime.parse("17:00:00"), LocalTime.parse("17:30:00")));
    }

    @Test
    void babysitterIsPaidTwelveDollarsForAnHourAndAHalfBeforeBedtime() {
        assertEquals(12, babysitter.getWageBeforeBedtime(LocalTime.parse("17:00:00"), LocalTime.parse("18:30:00")));
    }

    @Test
    void babysitterIsPaidEightDollarsForAnHourAndAHalfBeforeMidnight() {
        assertEquals(8, babysitter.getWageAfterBedtimeButBeforeMidnight(LocalTime.parse("17:00:00"), LocalTime.parse("21:30:00")));
    }

    @Test
    void babysitterIsPaidSixteenDollarsForAnHourAndAHalfAfterMidnight() {
        assertEquals(16, babysitter.getWageAfterMidnight(LocalTime.parse("17:00:00"), LocalTime.parse("01:30:00")));
    }

    @Test
    void babysitterIsPaidTwelveDollarsUntilSixPm() {
        assertEquals(12, babysitter.calculateWage(LocalTime.parse("17:00:00"), LocalTime.parse("18:00:00"), false));
    }

    @Test
    void babysitterIsPaidFortyFourDollarsUntilNinePm() {
        assertEquals(44, babysitter.calculateWage(LocalTime.parse("17:00:00"), LocalTime.parse("21:00:00"), false));
    }

    @Test
    void babysitterIsPaidSixtyEightDollarsThroughMidnight() {
        assertEquals(68, babysitter.calculateWage(LocalTime.parse("17:00:00"), LocalTime.parse("00:00:00"), true));
    }

    @Test
    void babysitterIsPaidOneHundredDollarsUntilTwoAm() {
        assertEquals(100, babysitter.calculateWage(LocalTime.parse("17:00:00"), LocalTime.parse("02:00:00"), true));
    }

    @Test
    void babysitterIsPaidOneHundredThirtyTwoDollarsForAFullNight() {
        assertEquals(132, babysitter.calculateWage(LocalTime.parse("17:00:00"), LocalTime.parse("04:00:00"), true));
    }
}
