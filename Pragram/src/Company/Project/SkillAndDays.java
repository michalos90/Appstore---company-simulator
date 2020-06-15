package Company.Project;

import Company.CreateRandom;

import java.util.LinkedList;
import java.util.List;

public class SkillAndDays extends CreateRandom {
    String skill;
    Integer days;
    List<SkillAndDays> skillAndDaysList = new LinkedList<>();

    public SkillAndDays(String nSkill, Integer nDays) {
        this.skill = nSkill;
        this.days = nDays;
    }

    public SkillAndDays() {

    }

    public void createSkillAndDaysList(Integer number, Integer days) {
        if (skillAndDaysList.size() != 0) {
            skillAndDaysList.clear();
        }

        for (int i = 0; i < number; i++) {
            if (skillAndDaysList.size() == 0) {
                skillAndDaysList.add(new SkillAndDays(generateSkill(), randomInt(days + 1)));
            } else {
                String value;
                do {
                    value = generateSkill();
                } while (generateUniqueSkills(value) == true);
                skillAndDaysList.add(new SkillAndDays(value, randomInt(days + 1)));
            }


        }
    }

    public List<SkillAndDays> copyList() {
        return skillAndDaysList;
    }

    public boolean parseSkills(SkillAndDays[] tab, String[] Tab) {
        List<SkillAndDays> tempList = fromSkillAndDaysTabToString(tab);
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

    public List<SkillAndDays> fromSkillAndDaysTabToString(SkillAndDays[] tab) {
        List<SkillAndDays> TempList = new LinkedList<>();
        for (int i = 0; i < tab.length; i++) {

            TempList.add(tab[i]);
        }
        return TempList;
    }

    public String[] stringTab(List<SkillAndDays> tempList) {
        String[] TempTab = new String[tempList.size()];
        int i = 0;
        for (SkillAndDays Item : tempList) {
            TempTab[i] = Item.skill;
            i++;
        }
        return TempTab;
    }

    public Integer[] IntTab(List<SkillAndDays> tempList) {
        Integer[] TempTab = new Integer[6];
        int i = 0;
        for (SkillAndDays Item : tempList) {
            TempTab[i] = Item.days;
            i++;
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

        for (SkillAndDays item : skillAndDaysList) {

            value += item.days * 1000;

        }
        return value;
    }

    public Integer getDaysFromList() {
        Integer value = 0;

        for (SkillAndDays item : skillAndDaysList) {

            value += item.days;

        }
        return value;
    }

    public boolean generateUniqueSkills(String skill) {
        boolean value = false;
        for (SkillAndDays items : skillAndDaysList) {
            if (items.skill == skill) {
                value = true;
            }
        }
        return value;
    }

    public SkillAndDays[] returSkillAndDays() {
        SkillAndDays[] TempTab = new SkillAndDays[skillAndDaysList.size()];
        for (int i = 0; i < skillAndDaysList.size(); i++) {
            TempTab[i] = skillAndDaysList.get(i);
        }
        return TempTab;
    }
}

