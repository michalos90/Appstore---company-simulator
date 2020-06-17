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
            System.out.println("U have only: " + this.cash + " for this pay u need at least: " + cash);
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

    public void dissmisEmploye() {

        numberOfEmployee();


        dissmisMenu();
        switch (SeciurityInPutInt(4)) {
            case 0:
                dissmisProgrammer();
                break;
            case 1:
                dissmisDealer();
                break;
            case 2:
                dissmisTester();
                break;
            case 3:
                break;
        }


    }

    public void numberOfEmployee() {
        System.out.println("U have " + getNumberOfDealers() + " Dealers");
        System.out.println("U have " + getNumberOfProgrammers() + " Programmers");
        System.out.println("U have " + getNumberOfTesters() + " Testers");
        if (getNumberOfDealers() == 0 && (getNumberOfProgrammers() == 0) && (getNumberOfTesters() == 0)) {
            System.out.println("U don't have any Employee");
        } else {
            if (getNumberOfProgrammers() == 0) {
                System.out.println("U don't have any Programmers ");
            }
            if (getNumberOfTesters() == 0) {
                System.out.println("U dont Have Any Testers");
            }
            if (getNumberOfDealers() == 0) {
                System.out.println("U dont Have Any Dealers");
            }
        }
    }

    public void dissmisMenu() {
        System.out.println("\nWhat Employee u want to dissmis: ?");

        System.out.println("0. Programmer");
        System.out.println("1. Dealer");
        System.out.println("2. Tester");
        System.out.println("3. Exit");

    }

    public void dissmisProgrammer() {
        if (getNumberOfProgrammers() != 0) {
            System.out.println("Here is A List of actually hired ");

            showProgramerList();
            System.out.println(getNumberOfProgrammers() + ". Exit\nwhich one u want Dismiss?");
            Integer tempOption = SeciurityInPutInt(getNumberOfProgrammers());
            if (tempOption != getNumberOfProgrammers()) {
                if (pay(myProgramerList.get(tempOption).cost/2) == true) {
                    myProgramerList.remove(tempOption);
                    System.out.println("Programmer Dismiss !");
                }
                else
                {
                    System.out.println("U can't Dismiss Programmer ");
                }

            }
        } else {
            System.out.println("U cant Dismiss someone u don't even hired");
        }


    }

    public void dissmisTester() {
        if (getNumberOfTesters() != 0) {
            if (pay(1500.0) == true) {
                myTesterList.remove(0);
                System.out.println("Tester Dismiss !");
            } else {
                System.out.println("U can't Dismiss Tester ");
            }
        } else {
            System.out.println("U cant Dismiss someone u don't even hired");
        }
    }

    public void dissmisDealer() {
        if (getNumberOfDealers() != 0) {
            if (pay(2000.0) == true) {
                myDealerList.remove(0);
                System.out.println("Dealer Dismiss !");
            } else {
                System.out.println("U can't Dismiss Tester ");
            }
        } else {
            System.out.println("U cant Dismiss someone u don't even hired");
        }
    }

}



