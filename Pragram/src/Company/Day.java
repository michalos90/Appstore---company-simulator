package Company;

import java.time.DayOfWeek;
import java.time.LocalDate;


public class Day {
    LocalDate day = LocalDate.of(2020, 1, 1);
    DayOfWeek dayOfWeek = day.getDayOfWeek();
    LocalDate conctractDay;

    public void Today() {
        System.out.println("Local date #2: " + day + " " + dayOfWeek);
    }


    public void setConctractDay(int day, int month, int year) {
        conctractDay = LocalDate.of(year, month, day);

    }

    public void viewDate(LocalDate date) {
        System.out.println("Local date #2: " + date);
    }

}

