package Company;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Calendar;

public class Day {
    LocalDate day = LocalDate.of(2020, 1, 3);
    Integer playedDays=1;
    Integer lookingForDays=0;

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
        System.out.println("Today is: "+this.day.getDayOfWeek()+ " Day "+playedDays);
            System.out.println("What u will do today : ");
            System.out.println("1. Sign a contract");
            System.out.println("2. Looking for client");
            System.out.println("3. Test Ur App");
            System.out.println("4. Hand over the finished project to the client");
            System.out.println("5. Hire a new employee");
            System.out.println("6. Dismiss an employee");
            System.out.println("7. Paper Time (you need at least 2 a month to not lose)");
            //wczytywanie z klawiatury opcji
        // przekierowanie do

    }
}

