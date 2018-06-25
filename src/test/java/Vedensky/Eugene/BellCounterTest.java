package Vedensky.Eugene;

import org.junit.Before;
import org.junit.Test;

import java.util.Calendar;

import static junit.framework.TestCase.assertEquals;

public class BellCounterTest {

    BellCounter bellCounter;
    @Before
    public void setUp(){
        bellCounter = new BellCounter();

    }

    @Test
    public void bellCounterTest(){
//        1. INPUT $startTime = '2:00'; $endTime = '3:00'; OUTPUT 5
//        2. INPUT $startTime = '14:00'; $endTime = '15:00'; OUTPUT 5
//        3. INPUT $startTime = '14:23'; $endTime = '15:42'; OUTPUT 3
//        4. INPUT $startTime = '23:00'; $endTime = '1:00'; OUTPUT 24

        int numberOfTimeBellHasBeenRung = bellCounter.countBells("2:00", "3:00");
        assertEquals(numberOfTimeBellHasBeenRung, 5);

        numberOfTimeBellHasBeenRung = bellCounter.countBells("14:00", "15:00");
        assertEquals(numberOfTimeBellHasBeenRung, 5);
        numberOfTimeBellHasBeenRung = bellCounter.countBells("14:23", "15:42");

        assertEquals(numberOfTimeBellHasBeenRung, 3);
        numberOfTimeBellHasBeenRung = bellCounter.countBells("23:00", "1:00");
        assertEquals(numberOfTimeBellHasBeenRung, 24);

        numberOfTimeBellHasBeenRung = bellCounter.countBells("23:00", "3:00");
        assertEquals(numberOfTimeBellHasBeenRung, 29);



    }


    @Test
    public void initializationTest(){

        BellCounter newBellCounter = new BellCounter();
        newBellCounter.initializeStartingTimes("23:00", "1:00");
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, 23);
      assertEquals(11,  newBellCounter.getAmountOfRingsFromMilitaryTime(calendar.get(Calendar.HOUR_OF_DAY)));
        calendar.set(Calendar.HOUR_OF_DAY, 24);

        assertEquals(12,  newBellCounter.getAmountOfRingsFromMilitaryTime(calendar.get(Calendar.HOUR_OF_DAY)));


    }
}
