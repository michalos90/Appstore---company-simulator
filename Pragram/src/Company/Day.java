package Company;


import Company.Human.Friend;
import Company.Human.Player;
import Company.Project.Project;

import java.time.DayOfWeek;
import java.time.LocalDate;

public class Day extends  CreateRandom{
    LocalDate day = LocalDate.of(2020, 1, 1);
    Integer playedDays = 1;

    DayOfWeek dayOfWeek = day.getDayOfWeek();
    LocalDate conctractDay;
    Player first = new Player("Michał", "Szyc");
    Project project = new Project();
    Friend friend = new Friend();

    public void Today() {
        System.out.println("Hello Today is  " + day + " " + dayOfWeek);

    }

    public void viewDate(LocalDate date) {
        System.out.println(date);
    }

    public DayOfWeek getDay() {

        return this.day.getDayOfWeek();
    }

    public void firstDay() {
        friend.generateFriend();
    }

    public void workTime() {
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


        Option(SeciurityInPutInt(8));


    }

    public void Option(Integer option) {
        switch (option) {
            case 1:
                signAContract();
                break;
            case 2:
                addPoint();
                break;
            case 3:
                programmingDay();
                break;
            case 4:
                testUrApp();
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


        }
    }


    public void signAContract() {
        if (project.getSizeOfList() == 0) {
            project.createProjectList(first.getPoints());
        }
        project.showListOfProject();
        Integer sizeList = project.getSizeOfList();
        System.out.println("\nAs u see u have " + sizeList + " projects available.\nWhich one will u choose?");

        System.out.println("U chose project");
        first.addToMyProjectsList(project.getAProject(SeciurityInPutInt(sizeList-1)));
        project.removeFromList();
        System.out.println("*********************");
        first.showProjectList();


        System.out.println("*********************");

        boolean checkingProject = project.parseSkills(first.getLastObjectFromProject(),first.skillsToProject());// checking

        if (checkingProject == false) {
            System.out.println("The Project Unsuccessful added, u need probably mobile programmer");
            first.removeLastElementFromProjectList();

        } else {
            System.out.println("The Project successful added\nActive Projects: " + first.activeProjects());
            playedDays++;
        }

    }


    public void addPoint() {
        first.addPoint();
    }

    public void programmingDay() {
        if (first.activeProjects() == 0) {
            System.out.println("Its look like u don't have any project sign a somone");
            signAContract();
        } else if (first.activeProjects() == 1) {
            System.out.println("Its Look Like u have only one project to work and u will be work on this project: ");
            first.showProjectList();
            first.updateDataProjectList(project.setNewHours(first.getLastObjectFromProject()),first.activeProjects()-1);
        } else {
            first.showProjectList();
            System.out.println("This is Ur Projects on what one u want work ? chose");
           Integer TempInt=SeciurityInPutInt(first.activeProjects() - 1);
           first.updateDataProjectList(project.setNewHours(first.getObjectFromProject(TempInt)),TempInt);


        }
    }

    public void testUrApp(){
        if (first.activeProjects() == 0) {
            System.out.println("Its look like u don't have any project sign a somone");
            signAContract();
        } else if (first.activeProjects() == 1) {
            System.out.println("Its Look Like u have only one project to work and u will be work on this project: ");
            first.showProjectList();
            first.updateDataProjectList(project.setNewTestingHours(first.getLastObjectFromProject()),first.activeProjects()-1);
        } else {
            first.showProjectList();
            System.out.println("This is Ur Projects on what one u want work ? chose");
            Integer TempInt=SeciurityInPutInt(first.activeProjects() - 1);
            first.updateDataProjectList(project.setNewTestingHours(first.getObjectFromProject(TempInt)),TempInt);

        }

    }

    public void hireAnEmployee() {

    }

    public void dissmisEmploye() {

    }

    public void paperTimeDay() {

    }

    public void handOverTheFinishedProject() {

    }




}

