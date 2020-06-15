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
                skillAndDaysList.add(new SkillAndDays(generateProjectSkill(), randomInt(days + 1)));
            } else {
                String value;
                do {
                    value = generateProjectSkill();
                } while (generateUniqueSkills(value) == true);
                skillAndDaysList.add(new SkillAndDays(value, randomInt(days + 1)));
            }


        }
    }

    public List<SkillAndDays> copyList() {
        return skillAndDaysList;
    }


    @Override
    public String toString() {
        return "skill=" + skill + '\'' +
                ", days=" + days;

    }

    public Double setPriceOnList() {
        Double value = 0.0;

        for (SkillAndDays item : skillAndDaysList) {

            value += item.days * 500;

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
        SkillAndDays[] TempTab = new SkillAndDays[6];
        for (int i = 0; i < skillAndDaysList.size(); i++) {
            TempTab[i] = skillAndDaysList.get(i);

        }
        return TempTab;
    }


}

