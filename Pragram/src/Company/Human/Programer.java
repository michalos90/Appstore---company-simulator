package Company.Human;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Programer extends Human {
    String skills[];

    public Programer(String nFirstName, String nLastName, String[] nSkills, Double nCost) {
        this.firstName = nFirstName;
        this.lastName = nLastName;
        this.skills = nSkills;
        this.cost = nCost;
    }

    List<Programer> programerList = new LinkedList<>();

    public Programer() {
    }

    public void generateProgramer() {
        String[] tab = uniqueSkills();
        Double nCost = 10000.0 + (1500 * (tab.length - 1));
        programerList.add(new Programer(generateName(), generateLastName(), tab, nCost));

    }

    public void showProgramerList() {
        Integer i = 0;
        for (Programer item : programerList) {

            System.out.println(i + ". " + item);
            i++;
        }
    }

    public Programer getProgramer(Integer index) {
        return programerList.get(index);
    }

    @Override
    public String toString() {
        return

                "firstName =" + firstName +
                        ", lastName =" + lastName +
                        ", skills =" + Arrays.toString(skills) +
                        ", cost: " + cost;
    }

    public String[] getSkills(Programer object) {
        return object.skills;
    }

    public void removeFromProgrammerList(Integer index) {
        programerList.remove(programerList.get(index));
    }

    public void generateProgrammer(Integer number) {
        for (; programerList.size() != number; ) {
            generateProgramer();
        }
    }
}


