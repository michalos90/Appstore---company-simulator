package Company;

import java.util.Random;
import java.util.Scanner;

public class CreateRandom {
    Random generator = new Random();

    Scanner scan = new Scanner(System.in);

    public Integer randomInt(Integer number) {


        return generator.nextInt(number);
    }

    public String generateLastName() {
        String generatedRandomName = "";
        switch (randomInt(12)) {
            case 1:
                generatedRandomName = "Smith";
                break;
            case 2:
                generatedRandomName = "Jones ";
                break;
            case 3:
                generatedRandomName = "Williams ";
                break;
            case 4:
                generatedRandomName = "Taylor ";
                break;
            case 5:
                generatedRandomName = "Davies ";
                break;
            case 6:
                generatedRandomName = "Evans ";
                break;
            case 7:
                generatedRandomName = "Thomas ";
                break;
            case 8:
                generatedRandomName = "Johnson ";
                break;
            case 9:
                generatedRandomName = "Roberts ";
                break;
            case 10:
                generatedRandomName = "Walker ";
                break;
            case 11:
                generatedRandomName = "Thompson ";
                break;
            default:
                generatedRandomName = "Edwards ";

        }


        return generatedRandomName;
    }

    public String generateName() {
        String generatedRandomName = "";
        switch (randomInt(12)) {
            case 1:
                generatedRandomName = "Michael";
                break;
            case 2:
                generatedRandomName = "George";
                break;
            case 3:
                generatedRandomName = "John";
                break;
            case 4:
                generatedRandomName = "Charles";
                break;
            case 5:
                generatedRandomName = "David";
                break;
            case 6:
                generatedRandomName = "Donald";
                break;
            case 7:
                generatedRandomName = "Julie";
                break;
            case 8:
                generatedRandomName = "Caroline";
                break;
            case 9:
                generatedRandomName = "Natalee";
                break;
            case 10:
                generatedRandomName = "Sheryl";
                break;
            case 11:
                generatedRandomName = "Samantha";
                break;
            default:
                generatedRandomName = "Andrew";

        }
        return generatedRandomName;
    }

    public Integer generateType() {

        Integer generatedType = 0;


        Integer randomNumber = randomInt(99);
        if (randomNumber <= 33 && randomNumber >= 1) {
            generatedType = 1;
        }
        if (randomNumber <= 66 && randomNumber >= 34) {
            generatedType = 2;
        }
        if (randomNumber <= 99 && randomNumber >= 67) {
            generatedType = 3;
        }
        return generatedType;
    }

    public String generateProjectName() {
        String generatedProjectName = "";
        switch (randomInt(12)) {
            case 1:
                generatedProjectName = "Project X";
                break;
            case 2:
                generatedProjectName = "The Best Game";
                break;
            case 3:
                generatedProjectName = "The Simple app";
                break;
            case 4:
                generatedProjectName = "Just a Game";
                break;
            case 5:
                generatedProjectName = "App For Company";
                break;
            case 6:
                generatedProjectName = "Helpfully app";
                break;
            case 7:
                generatedProjectName = "Jarvis";
                break;
            case 8:
                generatedProjectName = "Just an app";
                break;
            case 9:
                generatedProjectName = "Remote App";
                break;
            case 10:
                generatedProjectName = "Private App";
                break;
            case 11:
                generatedProjectName = "Nothing";
                break;
            default:
                generatedProjectName = "Learning app";

        }
        return generatedProjectName;
    }

    public String generateSkill() {

        String generatedSkill = "wordpress";
        switch (randomInt(7)) {
            case 1:
                generatedSkill = "front-end";
                break;
            case 2:
                generatedSkill = "backend";
                break;
            case 3:
                generatedSkill = "database";
                break;
            case 4:
                generatedSkill = "wordpress";
                break;
            case 5:
                generatedSkill = "prestashop";
                break;
            case 6:
                generatedSkill = "mobile";
                break;
            default:
                generatedSkill = "database";
                break;

        }
        return generatedSkill;
    }

    public String[] uniqueSkills() {

        Integer no = randomInt(3) + 3;
        String skill;
        String[] tab = new String[no];


        for (int i = 0; i < no; i++) {
            if (i == 0) {
                tab[i] = generateSkill();
            } else {
                do {
                    skill = generateSkill();
                } while (skills(tab, skill) == true);
                tab[i] = skill;

            }

        }

        return tab;

    }

    public boolean skills(String[] tab, String skill) {
        boolean value = false;
        for (int i = 0; i < tab.length; i++) {
            if (tab[i] == skill) {
                value = true;

            }
        }
        return value;
    }

    public Integer SeciurityInPutInt(int max) {
        Integer number;
        do {
            number = scan.nextInt();
        } while (number < 0 || number > max);
        return number;
    }

}
