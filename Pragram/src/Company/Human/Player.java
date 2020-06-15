package Company.Human;

import Company.Project.Project;

import java.util.LinkedList;
import java.util.List;

public class Player extends Programer {
    Double money = 2000.0;
    Integer lookingPoints = 15;


    public Player(String name, String surname) {
        this.firstName = name;
        this.lastName = surname;
        this.skills = new String[5];
        this.skills[0] = "front-end";
        this.skills[1] = "backend";
        this.skills[2] = "database";
        this.skills[3] = "wordpress";
        this.skills[4] = "prestashop";

        List<Project> myProjectList = new LinkedList<>();
        List<Dealer> myDealerList = new LinkedList<>();
        List<Programer> myProgramerList = new LinkedList<>();
        List<Friend> myFriendList = new LinkedList<>();


        //

    }

    public Integer getPoints() {
        return lookingPoints;
    }

}

