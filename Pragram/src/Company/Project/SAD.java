package Company.Project;

import Company.CreateRandom;

import java.util.LinkedList;
import java.util.List;

public class SAD extends CreateRandom {
    String skill;
    Integer days;
    List<SAD> SADList = new LinkedList<>();

    public SAD(String nSkill, Integer nDays) {
        this.skill = nSkill;
        this.days = nDays;
    }

    public SAD() {
    }

    public void createSkillAndDaysList(Integer number, Integer days) {
        if (SADList.size() != 0) {
            SADList.clear();
        }

        for (int i = 0; i < number; i++) {
            if (SADList.size() == 0) {
                SADList.add(new SAD(generateSkill(), randomInt(days )+1));
            } else {
                String value;
                do {
                    value = generateSkill();
                } while (generateUniqueSkills(value) == true);
                SADList.add(new SAD(value, randomInt(days )+1));
            }


        }
    }

    public List<SAD> copyList() {
        return SADList;
    }

    public boolean parseSkills(SAD[] tab, String[] Tab) {
        List<SAD> tempList = fromSkillAndDaysTabToString(tab);
        String[] first = stringTab(tempList);
        String[] second = Tab;
        Integer value = 0;
        boolean check = false;


        for (int j = 0; j < second.length; j++) {
            for (int i = 0; i < first.length; i++) {
                if (first[i].equals(second[j]) == true) {
                    value++;
                }

            }
        }
        if (value == first.length) {
            check = true;
        }

        return check;
    }

    public List<SAD> fromSkillAndDaysTabToString(SAD[] tab) {
        List<SAD> TempList = new LinkedList<>();
        for (int i = 0; i < tab.length; i++) {

            TempList.add(tab[i]);
        }
        return TempList;
    }

    public String[] stringTab(List<SAD> tempList) {
        String[] TempTab = new String[tempList.size()];
        int i = 0;
        for (SAD Item : tempList) {
            TempTab[i] = Item.skill;
            i++;
        }
        return TempTab;
    }

    public Integer[] IntTab(List<SAD> tempList) {
        Integer[] TempTab = new Integer[tempList.size()];
        int i = 0;
        for (SAD Item : tempList) {

            TempTab[i] = Item.days;

            i++;
        }
        return TempTab;
    }

    public SAD[] workDay(SAD[] tab) {

        Integer[] tempInttab = IntTab(fromSkillAndDaysTabToString(tab));
        String[] tempStrintab = stringTab(fromSkillAndDaysTabToString(tab));
        Integer size = fromSkillAndDaysTabToString(tab).size();


        for (int i = 0; i < size; i++) {
            System.out.println(i + ". " + tempInttab[i] + " " + tempStrintab[i]);
        }
        System.out.println("On What Technology u will work? type form 0");
        tempInttab[SeciurityInPutInt(size-1)]--;
        return returnToSADtab(tempInttab, tempStrintab, size);
    }

    public SAD[] returnToSADtab(Integer[] itab, String[] stab, Integer size) {
        SAD[] TempTab = new SAD[size];
        for (int i = 0; i < size; i++) {
            TempTab[i] = new SAD(stab[i], itab[i]);
        }

        return TempTab;
    }

    @Override
    public String toString() {
        return "skill=" + skill + '\'' +
                ", days=" + days;

    }

    public Double setPriceOnList() {
        Double value = 0.0;

        for (SAD item : SADList) {

            value += item.days * 1000;

        }
        return value;
    }

    public Integer getDaysFromList() {
        Integer value = 0;

        for (SAD item : SADList) {

            value += item.days;

        }
        return value;
    }

    public boolean generateUniqueSkills(String skill) {
        boolean value = false;
        for (SAD items : SADList) {
            if (items.skill == skill) {
                value = true;
            }
        }
        return value;
    }

    public SAD[] returSkillAndDays() {
        SAD[] TempTab = new SAD[SADList.size()];
        for (int i = 0; i < SADList.size(); i++) {
            TempTab[i] = SADList.get(i);
        }
        return TempTab;
    }
}

