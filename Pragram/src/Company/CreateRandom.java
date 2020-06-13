package Company;

import java.util.Random;

public class CreateRandom {
    Random generator = new Random();

    public Integer randomInt(Integer number) {

        return generator.nextInt(number);
    }

    public String createRandomLastName(Integer number) {
        String value = "";
        switch (randomInt(number)) {
            case 1:
                value = "Smith";
                break;
            case 2:
                value = "Jones ";
                break;
            case 3:
                value = "Williams ";
                break;
            case 4:
                value = "Taylor ";
                break;
            case 5:
                value = "Davies ";
                break;
            case 6:
                value = "Evans ";
                break;
            case 7:
                value = "Thomas ";
                break;
            case 8:
                value = "Johnson ";
                break;
            case 9:
                value = "Roberts ";
                break;
            case 10:
                value = "Walker ";
                break;
            case 11:
                value = "Thompson ";
                break;
            default:
                value = "Edwards ";

        }


        return value;
    }

    public String createRandomName(Integer number) {
        String value = "";
        switch (randomInt(number)) {
            case 1:
                value = "Michael";
                break;
            case 2:
                value = "George";
                break;
            case 3:
                value = "John";
                break;
            case 4:
                value = "Charles";
                break;
            case 5:
                value = "David";
                break;
            case 6:
                value = "Donald";
                break;
            case 7:
                value = "Julie";
                break;
            case 8:
                value = "Caroline";
                break;
            case 9:
                value = "Natalee";
                break;
            case 10:
                value = "Sheryl";
                break;
            case 11:
                value = "Samantha";
                break;
            default:
                value = "Andrew";

        }
        return value;
    }

    public Integer createRandomType() {

        Integer value = 0;


        Integer randomNumber=randomInt(99);
        if (randomNumber <= 33 && randomNumber >= 1) {
            value = 1;
        }
        if (randomNumber <= 66 && randomNumber >= 34) {
            value = 2;
        }
        if (randomNumber <= 99 && randomNumber >= 67) {
            value = 3;
        }
        return value;
    }
    public String createRandomProjectName(Integer number) {
        String value = "";
        switch (randomInt(number)) {
            case 1:
                value = "Project X";
                break;
            case 2:
                value = "The Best Game";
                break;
            case 3:
                value = "The Simple app";
                break;
            case 4:
                value = "Just a Game";
                break;
            case 5:
                value = "App For Company";
                break;
            case 6:
                value = "Helpfully app";
                break;
            case 7:
                value = "Jarvis";
                break;
            case 8:
                value = "Just an app";
                break;
            case 9:
                value = "Remote App";
                break;
            case 10:
                value = "Private App";
                break;
            case 11:
                value = "Nothing";
                break;
            default:
                value = "Telephone app";

        }
        return value;
    }


}
