package Company;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Calendar;

public class Day {
    LocalDate day = LocalDate.of(2020, 1, 3);

    DayOfWeek dayOfWeek = day.getDayOfWeek();
    LocalDate conctractDay;

    public void Today() {
        System.out.println("Hello Today is  " + day + " " + dayOfWeek);
    }


    public void setConctractDay(int day, int month, int year) {
        conctractDay = LocalDate.of(year, month, day);

    }

    public void viewDate(LocalDate date) {
        System.out.println(date);
    }

    public DayOfWeek getDay() {

        return this.day.getDayOfWeek();
    }
    public void workTime(){
        System.out.println("Today is: "+this.day.getDayOfWeek());
        if(this.day.getDayOfWeek().getValue()<=5)
        {
            System.out.println("Today is:");

        }
        else
        {
            System.out.println("No spoko");
        }


    }

}

