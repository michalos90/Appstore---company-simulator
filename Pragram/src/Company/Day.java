package Company;


import Company.Human.*;
import Company.Project.Project;

import java.time.LocalDate;

public class Day extends CreateRandom {
    Integer playedDays = 1;
    LocalDate day = LocalDate.ofYearDay(2020, playedDays);


    LocalDate conctractDay;
    Programer programer = new Programer();
    Player first = new Player("Michał", "Szyc");
    Project project = new Project();
    Friend friend = new Friend();


    public void firstDay() {
        friend.generateFriend();

    }

    public void workTime() {
        if (playedDays == 1) {
            firstDay();
        }
        if (first.getCash() == 0.0) {
            System.out.println("Game Over U are Bankrupt");

        } else {
            System.out.println("Today is: " + this.day.getDayOfWeek() + " Day " + playedDays);
            System.out.println("What u will do today : ");
            System.out.println("1. Sign a contract");
            System.out.println("2. Looking for client");
            System.out.println("3. Programming Day");
            System.out.println("4. Test Ur App");
            System.out.println("5. Hand over the finished project to the client");
            System.out.println("6. Hire a new employee");
            System.out.println("7. Dismiss an employee");
            System.out.println("8. Paper Time (you need at least 2 a month to not lose)");
            System.out.println("9. Show my Lists");
            Option(SeciurityInPutInt(9));
        }
    }

    public void Option(Integer option) {
        switch (option) {
            case 1:
                if (signAContract() == true) endDay();
                break;
            case 2:
                addPoint();
                break;
            case 3:
                if (programmingDay() == true) endDay();
                break;
            case 4:
                if (testUrApp() == true) endDay();
                break;
            case 5:
                handOverTheFinishedProject();
                break;
            case 6:
                hireAnEmployee();
                break;
            case 7:
                dissmisEmploye();
                break;
            case 8:
                paperTimeDay();
                break;
            case 9:
                schowLists();
        }
    }

    public void schowLists() {
        System.out.println("****************");
        System.out.println("Active Project List: " + first.activeProjects());
        first.showProjectList();
        System.out.println("****************");
        System.out.println("****************");
        System.out.println("Finished project List:");
        first.showFinishedProject();
        System.out.println("****************");
        System.out.println("****************");
        first.showProgramerList();

    }

    public boolean signAContract() {
        if (project.getSizeOfList() == 0) {
            project.createProjectList(first.getPoints(), day);
        }
        project.showListOfProject();
        Integer sizeList = project.getSizeOfList();
        System.out.println(sizeList + ". Exit");
        System.out.println("U have " + first.getPoints() + " points, more points= bigger projects");
        System.out.println("\nAs u see u have " + sizeList + " projects available.\nWhich one will u choose?");
        Integer tempOption = SeciurityInPutInt(sizeList);
        if (tempOption != sizeList) {


            first.addToMyProjectsList(project.getAProject(tempOption));
            project.removeFromList();
            System.out.println("U chose project");
            System.out.println("*********************");
            first.showProjectList();


            System.out.println("*********************");

            boolean checkingProject = project.parseSkills(first.getLastObjectFromProject(), first.skillsToProject());// checking

            if (checkingProject == false) {
                System.out.println("The Project Unsuccessful added, u need probably mobile programmer");
                first.removeLastElementFromProjectList();


            } else {
                System.out.println("The Project successful added\nActive Projects: " + first.activeProjects());
                return true;
            }
        }
        return false;
    }

    public void addPoint() {
        first.addPoint();
        endDay();
    }

    public boolean programmingDay() {
        if (first.activeProjects() == 0) {
            System.out.println("Its look like u don't have any project sign a somone");
            if (signAContract() == true) endDay();
        } else if (first.activeProjects() == 1) {
            System.out.println("Its Look Like u have only one project to work and u will be work on this project: ");
            first.showProjectList();
            Project tempObj = first.getLastObjectFromProject();
            Integer tempInt = checkProjectStatusSkills(tempObj);
            checkProjectStatus(tempInt, checkProjectStatusTest(tempObj), tempObj);
            if (tempInt != 0) {
                first.updateDataProjectList(project.setNewHours(tempObj), first.activeProjects() - 1);
                return true;
            } else {
                System.out.println("\nU cant work on this project because is finished");
            }

        } else {
            first.showProjectList();
            System.out.println(first.activeProjects() + ". Exit\nThis is Ur Projects on what one u want work ? chose");
            Integer TempInt = SeciurityInPutInt(first.activeProjects());
            if (TempInt != first.activeProjects()) {
                Project tempObj = first.getProject(TempInt);
                Integer tempInt = checkProjectStatusSkills(tempObj);
                checkProjectStatus(tempInt, checkProjectStatusTest(tempObj), tempObj);
                if (tempInt != 0) {
                    first.updateDataProjectList(project.setNewHours(first.getProject(TempInt)), TempInt);
                    return true;
                } else {
                    System.out.println("\nU cant work on this project because is finished");
                }

            }


        }
        return false;
    }

    public Integer checkProjectStatusSkills(Project object) {
        Integer tempInt = project.checkProjectStatusSkills(object);


        return tempInt;
    }

    public Integer checkProjectStatusTest(Project object) {

        Integer tempInt = project.getRequiredTestDays(object);


        return tempInt;
    }

    public void checkProjectStatus(Integer days, Integer test, Project object) {

        if ((days == 0) && (test == 0)) {
            first.addFinishedProject(object);
            first.showFinishedProject();
            first.removeProject(object);
        }
        Integer tempInt = days + test;
        System.out.println("This project have " + tempInt + " Working days");


    }

    public boolean testUrApp() {
        if (first.activeProjects() == 0) {
            System.out.println("Its look like u don't have any project sign a somone");
            if (signAContract() == true) endDay();
        } else if (first.activeProjects() == 1) {
            System.out.println("Its Look Like u have only one project to work and u will be work on this project: ");
            first.showProjectList();
            Project tempObj = first.getLastObjectFromProject();
            Integer tempInt = checkProjectStatusTest(tempObj);
            checkProjectStatus(checkProjectStatusSkills(tempObj), tempInt, tempObj);
            if (tempInt != 0) {
                first.updateDataProjectList(project.setNewTestingHours(tempObj), first.activeProjects() - 1);
                return true;
            }
        } else {
            first.showProjectList();
            System.out.println(first.activeProjects() + ". Exit\nThis is Ur Projects on what one u want work ? chose");
            Integer TempInt = SeciurityInPutInt(first.activeProjects());
            if (TempInt != first.activeProjects()) {
                Project tempObj = first.getProject(TempInt);
                Integer tempInt = checkProjectStatusTest(tempObj);
                checkProjectStatus(checkProjectStatusSkills(tempObj), tempInt, tempObj);

                if (tempInt != 0) {
                    first.updateDataProjectList(project.setNewTestingHours(first.getProject(TempInt)), TempInt);
                    return true;
                }


            }
        }
        return false;
    }

    public void handOverTheFinishedProject() {
        System.out.println();
    }

    public void hireAnEmployee() {
        first.hireEmployee();
        switch (SeciurityInPutInt(5)) {
            case 0:

                if (first.hireProgramer() == true) endDay();
                break;

            case 1:
                if (first.hireTester() == true) endDay();
                break;
            case 2:
                if (first.hireDealer() == true) endDay();
                break;
            case 3:
                getClassifiedsPont();
                break;
            case 4:
                break;

        }
    }

    public void getClassifiedsPont() {

        if (first.pay(5000.0) == true) {
            first.setClassifieds();
        }

    }

    public void dissmisEmploye() {
        first.dissmisEmploye();
    }

    public void paperTimeDay() {
    }

    public void endDay() {
        playedDays++;

        day = LocalDate.ofYearDay(2020, playedDays);
    }
}

