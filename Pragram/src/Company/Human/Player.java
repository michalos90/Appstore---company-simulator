package Company.Human;

import Company.Project.Project;

import java.util.LinkedList;
import java.util.List;

public class Player extends Programer {
    List<Project> myProjectList = new LinkedList<>();
    List<Human> myDealerList = new LinkedList<>();
    List<Programer> myProgramerList = new LinkedList<>();
    List<Friend> myFriendList = new LinkedList<>();
    List<Human> myTesterList = new LinkedList<>();
    Double cash = 20000.0;
    Integer lookingPoints = 15 + myDealerList.size();
    Integer programingPoint = 1 + myProgramerList.size();
    Integer classifieds = 3;

    public Player(String name, String surname) {
        this.firstName = name;
        this.lastName = surname;
        this.skills = new String[5];
        this.skills[0] = "front-end";
        this.skills[1] = "backend";
        this.skills[2] = "database";
        this.skills[3] = "wordpress";
        this.skills[4] = "prestashop";
    }

    public void addPoint() {
        lookingPoints++;
    }

    public boolean pay(Double cash) {
        if (checkIfUCouldPay(cash) == true) {
            Double money = this.cash;
            this.cash = money - cash;
            System.out.println("Successful payed u have  " + this.cash);
            return true;
        } else {
            System.out.println("U have only: " + this.cash + " for this buy u need at least: " + cash);
        }
        return false;
    }

    public String[] skillsToProject() {
        return skills;
    }

    public Integer getPoints() {
        return lookingPoints;
    }

    public Integer getClassifieds() {
        return classifieds;
    }

    public void setClassifieds() {
        this.classifieds++;
    }

    public Double getCash() {
        return cash;
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

    public void removeLastElementFromProjectList() {
        myProjectList.remove(myProjectList.size() - 1);
    }

    public int sizeProgrammerList() {
        return myProgramerList.size();
    }

    public void updateDataProjectList(Project project, int Index) {
        myProjectList.set(Index, project);
    }

    public boolean checkIfUCouldPay(Double cash) {

        if (this.cash >= cash) {
            return true;
        }
        return false;

    }

    public void addToMyProgrammerList(Programer object) {
        myProgramerList.add(object);

    }

    public Programer getLastProgrammerObj() {
        return myProgramerList.get(myProgramerList.size() - 1);
    }

    public void showProgramerList() {
        for (Programer item : myProgramerList) {
            System.out.println(item);
        }
    }

    public boolean payForProgrammer() {
        Programer tempObj = getLastProgrammerObj();
        if (pay(tempObj.cost) == true) {
            return true;
        }
        return false;
    }

    public void removeLastObjFromProgrammerList() {
        myProgramerList.remove(myProjectList.size() - 1);
    }

    public void addTester() {
        myTesterList.add(generateTester());
        Human tempObj = myTesterList.get(myTesterList.size() - 1);
        if (pay(tempObj.cost) == true) {
            System.out.println("U have now " + myTesterList.size() + " Testers");
        } else {
            myTesterList.remove(tempObj);
        }

    }

    public void addDealer() {
        myDealerList.add(generateDealer());
        Human tempObj = myDealerList.get(myDealerList.size() - 1);
        if (pay(tempObj.cost) == true) {
            System.out.println("U have now " + myDealerList.size() + " Dealers");
        } else {
            myDealerList.remove(tempObj);
        }
    }

    public Integer getNumberOfTesters() {
        return myTesterList.size();
    }

    public Integer getNumberOfProgrammers() {
        return myProgramerList.size();
    }

    public Integer getNumberOfDealers() {
        return myDealerList.size();
    }
}

