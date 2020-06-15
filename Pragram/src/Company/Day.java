package Company;


import Company.Human.Player;
import Company.Project.Project;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Scanner;

public class Day {
    LocalDate day = LocalDate.of(2020, 1, 1);
    Integer playedDays = 1;
    Integer lookingForDays = 0;

    DayOfWeek dayOfWeek = day.getDayOfWeek();
    LocalDate conctractDay;
    Player first = new Player("Michał", "Szyc");
    Project project = new Project();
    Scanner scan = new Scanner(System.in);

    public void Today() {
        System.out.println("Hello Today is  " + day + " " + dayOfWeek);

    }

    public void viewDate(LocalDate date) {
        System.out.println(date);
    }

    public DayOfWeek getDay() {

        return this.day.getDayOfWeek();
    }

    public void workTime() {
        System.out.println("Today is: " + this.day.getDayOfWeek() + " Day " + playedDays);
        System.out.println("What u will do today : ");
        System.out.println("1. Sign a contract");
        System.out.println("2. Looking for client");
        System.out.println("3. Test Ur App");
        System.out.println("4. Hand over the finished project to the client");
        System.out.println("5. Hire a new employee");
        System.out.println("6. Dismiss an employee");
        System.out.println("7. Paper Time (you need at least 2 a month to not lose)");

        Integer option;
        do {
            option = scan.nextInt();
        } while (option < 0 && option >= 7);
        Option(option);


    }

    public void Option(Integer option) {
        switch (option) {
            case 1:
                signAContract();
                break;
            case 2:
                addLookingPoint();
                break;
            case 3:
                testUrApp();
                break;
            case 4:
                handOverTheFinishedProject();
                break;
            case 5:
                hireAnEmployee();
                break;
            case 6:
                dissmisEmploye();
                break;
            case 7:
                paperTimeDay();

        }
    }

    public void signAContract() {
        if (project.getSizeOfList() == 0) {
            project.createProjectList(first.getPoints());
        }
        project.showListOfProject();
        Integer sizeList = project.getSizeOfList();
        System.out.println("\nAs u see u have " + sizeList + " projects available.\nWhich one will u choose?");
        Integer option;
        do {
            option = scan.nextInt();
        } while (option < 0 || option > sizeList);
        System.out.println("U chose project");
        first.addToMyProjectsList(project.getAProject(option));
        project.removeFromList();
        System.out.println("*********************");
        first.showProjectList();


        System.out.println("*********************");

        boolean checkingProject = project.parseSkills(project.fromProjectToSkillAndDatstab(first.getLastObjectFromProject()), first.skillsToProject());// checking

        if (checkingProject == false) {
            System.out.println("The Project Unsuccessful added, u need probably mobile programmer");
            first.removeFromProjectList(first.activeProjects());

        } else {
            System.out.println("The Project successful added\nActive Projects: " + first.activeProjects());
            playedDays++;
        }

    }

    public void addLookingPoint() {
        first.addPoint();
    }

    public void hireAnEmployee() {

    }

    public void dissmisEmploye() {

    }

    public void paperTimeDay() {

    }

    public void handOverTheFinishedProject() {

    }

    public void testUrApp() {

    }


}

