package Company.Human;

import Company.Project.Project;

import java.util.LinkedList;
import java.util.List;

public class Player extends Programer {
    Double money = 2000.0;
    Integer lookingPoints = 15;

    List<Project> myProjectList = new LinkedList<>();
    List<Dealer> myDealerList = new LinkedList<>();
    List<Programer> myProgramerList = new LinkedList<>();
    List<Friend> myFriendList = new LinkedList<>();

    public Player(String name, String surname) {
        this.firstName = name;
        this.lastName = surname;
        this.skills = new String[5];
        this.skills[0] = "front-end";
        this.skills[1] = "backend";
        this.skills[2] = "database";
        this.skills[3] = "wordpress";
        this.skills[4] = "prestashop";


        //

    }

    public void addPoint() {
        lookingPoints++;
    }

    public String[] skillsToProject() {
        return skills;
    }

    public Integer getPoints() {
        return lookingPoints;
    }

    public void addToMyProjectsList(Project project) {
        myProjectList.add(project);
    }

    public void showProjectList() {
        for (Project item : myProjectList) {
            System.out.println(item);
        }
    }

    public Project getObjectFromProject(Integer number) {
        return myProjectList.get(number);
    }

    public Project getLastObjectFromProject() {
        return myProjectList.get(myProjectList.size() - 1);
    }

    public Integer activeProjects() {
        return myProjectList.size();
    }

    public void removeFromProjectList(Integer Index) {
        myProjectList.remove(Index);
    }

}

