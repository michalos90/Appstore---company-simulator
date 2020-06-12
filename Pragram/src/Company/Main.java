package Company;

import Company.Human.Player;



public class Main {
    public static void main(String[] args){

        Player first = new Player("Michał", "Szyc");
        Day day = new Day();
        day.Today();
        day.setConctractDay(10,6,2020);
day.viewDate(day.conctractDay);
    }
}