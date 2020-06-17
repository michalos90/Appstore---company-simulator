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
    Integer lookingPoints = 15;
    Integer classifieds = 3;
    List<Project> finishedProjects = new LinkedList<>();

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
        return lookingPoints + myDealerList.size();
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

    public Project getProject(Integer number) {
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

    public void removeLastObjFromProgrammerList() {
        myProgramerList.remove(myProjectList.size() - 1);
    }

    public void removeProject(Project project) {
        myProjectList.remove(project);
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

    public void showMyProgramerList() {
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


    public boolean hireProgramer() {
        generateProgrammer(getClassifieds());
        showProgramerList();
        System.out.println(getClassifieds() + ". Exit\nHere is a list of ur Programmer: " + "\nActually hired Programmers: " + sizeProgrammerList());
        showMyProgramerList();
        System.out.println("Which one will u chose type from 0");
        int answer = SeciurityInPutInt(getClassifieds());
        if (answer != getClassifieds()) {
            addToMyProgrammerList(getProgramer(answer));
            if (payForProgrammer() == true) {
                System.out.println("Programmer Successful hired");
                removeFromProgrammerList(answer);
                return true;
            } else {
                System.out.println("U dont have enough money for this Programmer");
                removeLastObjFromProgrammerList();
            }
        }
        return false;
    }

    public boolean hireTester() {
        myTesterList.add(generateTester());
        Human tempObj = myTesterList.get(myTesterList.size() - 1);
        if (pay(tempObj.cost) == true) {
            System.out.println("U have now " + myTesterList.size() + " Testers");
            return true;
        } else {
            myTesterList.remove(tempObj);

        }
        return false;
    }

    public boolean hireDealer() {
        myDealerList.add(generateDealer());
        Human tempObj = myDealerList.get(myDealerList.size() - 1);
        if (pay(tempObj.cost) == true) {
            System.out.println("U have now " + myDealerList.size() + " Dealers");
            return true;
        } else {
            myDealerList.remove(tempObj);
        }
        return false;
    }

    public void addFinishedProject(Project project) {
        finishedProjects.add(project);
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
                if (pay(myProgramerList.get(tempOption).cost / 2) == true) {
                    myProgramerList.remove(tempOption);
                    System.out.println("Programmer Dismiss !");
                } else {
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

    public void hireEmployee() {
        System.out.println("U have: " + getClassifieds() + " classifieds points u can have more but each one cost 5000$");
        System.out.println("U have actually: " + getCash() + " $");
        System.out.println("Testers: " + getNumberOfTesters());
        System.out.println("Programmers: " + getNumberOfProgrammers());
        System.out.println("Dealers: " + getNumberOfDealers());
        System.out.println("Which one Employee u need to hire?or u want see more Employees");
        System.out.println("0. Programer");
        System.out.println("1. Tester 3000.0");
        System.out.println("2. Dealer 3500.0");
        System.out.println("3. Get a classifieds cost 5000");
        System.out.println("4. Exit");
    }

    public void showFinishedProject() {
        for (Project item : finishedProjects) {
            System.out.println(item);
        }
    }
}



