package Company.Project;

import Company.CreateRandom;

import java.util.LinkedList;
import java.util.List;

public class SkillAndDays extends CreateRandom {
    String skill;
    Integer days;

    public SkillAndDays(String nSkill, Integer nDays) {
        this.skill = nSkill;
        this.days = nDays;
    }

    public SkillAndDays() {

    }

            List<SkillAndDays> skillAndDaysList = new LinkedList<>();

    public void createSkillAndDaysList(int number) {
        if (skillAndDaysList.size()!=0){
skillAndDaysList.clear();
        }
        for(int i = 0;i<number;i++)
        skillAndDaysList.add(new SkillAndDays(generateProjectSkill(), randomInt(100)));

    }

    //   public void showList(){        for(int i =0;i<skillAndDaysList.size();i++)        {            System.out.println(skillAndDaysList); } }
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

    public List<SkillAndDays> getDayFromTab (SkillAndDays[] tab){

        List<SkillAndDays> TempList = new LinkedList<>();

        return TempList;

    }



    public void clearList() {
        skillAndDaysList.clear();
    }

    public void showList(List<SkillAndDays> list){
        for(SkillAndDays items: list)
        {
            System.out.println(items.days+items.skill);
        }

    }

    public SkillAndDays[] ListToTab(List<SkillAndDays> list)    {
        SkillAndDays[]tempTab = new SkillAndDays[6];
        for (int i=0;i<skillAndDaysList.size();i++)
        {

            tempTab[i]= skillAndDaysList.get(i);

        }

        return tempTab;
    }

    public void showList(SkillAndDays[] tempTab) {
        for(int i=0;i<tempTab.length;i++)
        {
            System.out.println(tempTab[i]);
        }
    }

    public SkillAndDays[] returSkillAndDays()    {
        SkillAndDays[] TempTab= new SkillAndDays[6];
        for(int i=0;i<skillAndDaysList.size();i++)
        {
            TempTab[i]=skillAndDaysList.get(i);

        }
        return TempTab;
    }
}

