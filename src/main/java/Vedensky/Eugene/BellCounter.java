package Vedensky.Eugene;

import java.util.Calendar;

import static java.lang.Integer.parseInt;

public class BellCounter {

    private Calendar startingDate;
    private Calendar endingDate;

    private final int INDEX_OF_MINUTES = 1;
    private final int INDEX_OF_HOUR = 0;

    private int totalRings;

    public int countBells(String startTime, String endTime){


        initializeStartingTimes(startTime,endTime);


        while(isBetween()){
                totalRings += getAmountOfRingsFromMilitaryTime(startingDate.get(Calendar.HOUR_OF_DAY));
                startingDate.set(Calendar.HOUR_OF_DAY, startingDate.get(Calendar.HOUR_OF_DAY) + 1);
        }


        return totalRings;

    }



    private boolean startingHourHasAlreadyRung(){
        return  startingDate.get(Calendar.MINUTE) > 0;
    }

    public int getAmountOfRingsFromMilitaryTime(int millitaryTime){

        if(millitaryTime == 0){
            return 12;
        }

        return millitaryTime > 12 ? millitaryTime - 12 : millitaryTime;
    }



    public boolean isBetween() {
       return startingDate.before(this.endingDate) || startingDate.equals(this.endingDate);

    }

    public void initializeStartingTimes(String startingTime, String endingTime){
        totalRings = 0;

        int startingHour = parseInt(startingTime.split(":")[INDEX_OF_HOUR]);
        int endingHour = parseInt(endingTime.split(":")[INDEX_OF_HOUR]);
        int startingMinute = parseInt(startingTime.split(":")[INDEX_OF_MINUTES]);
        int endingMinute = parseInt(endingTime.split(":")[INDEX_OF_MINUTES]);
        Calendar startingDate = Calendar.getInstance();
        Calendar endingDate = Calendar.getInstance();
        startingDate.set(Calendar.MINUTE,startingMinute);
        endingDate.set(Calendar.MINUTE, endingMinute);
        startingDate.set(Calendar.HOUR_OF_DAY, startingHour);
        endingDate.set(Calendar.HOUR_OF_DAY, endingHour);
        if(endingHour < startingHour){
            endingDate.add(Calendar.DATE, 1);
        }

        this.startingDate = startingDate;

        this.endingDate = endingDate;

        if(!startingHourHasAlreadyRung()){
            totalRings += getAmountOfRingsFromMilitaryTime(startingDate.get(Calendar.HOUR_OF_DAY));
        }

        this.startingDate.add(Calendar.HOUR, 1);


    }
}
