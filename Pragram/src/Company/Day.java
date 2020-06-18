package Company;


import Company.Human.*;
import Company.Project.Project;

import java.time.DayOfWeek;
import java.time.LocalDate;

public class Day extends CreateRandom {
    int playedDays = 1;
    LocalDate days = LocalDate.ofYearDay(2020, 1);
    Integer zus = 2;
    Player first = new Player("Michał", "Szyc");
    Project project = new Project();
    Friend friend = new Friend();


    public void firstDay() {
        friend.generateFriend();
        first.addFriendToMyList(friend.getFriendList());

    }

    public void workTime() {
        if (playedDays == 1) {
            firstDay();
        }
        if (first.getCash() <= 0.0) {
            System.out.println("Game Over U are Bankrupt");

        } else {
            System.out.println("Today is: " + days.getDayOfWeek() + " Day " + playedDays);
            System.out.println(days);
            System.out.println("Money: " + first.getCash());
            System.out.println("Active projects: " + first.activeProjects());
            ;
            System.out.println("Finished Projects:" + first.finishedProjects());
            System.out.println("What u will do today : ");
            System.out.println("1. Sign a contract");
            System.out.println("2. Looking for client");
            System.out.println("3. Programming Day");
            System.out.println("4. Test Ur App");
            System.out.println("5. Hand over the finished project to the client");
            System.out.println("6. Hire a new employee");
            System.out.println("7. Dismiss an employee");
            System.out.println("8. Paper Time (you need at least 2 a month to not lose)");
            System.out.println("9. Give a project to ur friend");
            System.out.println("10. Show my Lists");
            Option(seciurityInPutInt(10));
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
                if (handOverTheProject() == true) endDay();
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
                giveProjectToFriend();
                break;
            case 10:
                schowLists();
                break;
        }
    }

    public boolean signAContract() {
        if (project.getSizeOfList() == 0) {
            project.createProjectList(first.getPoints(), days);
        }
        project.showListOfProject();
        Integer sizeList = project.getSizeOfList();
        System.out.println(sizeList + ". Exit");
        System.out.println("U have " + first.getPoints() + " points, more points= bigger projects");
        System.out.println("\nAs u see u have " + sizeList + " projects available.\nWhich one will u choose?");
        Integer tempOption = seciurityInPutInt(sizeList);
        if (tempOption != sizeList) {
            first.addToMyProjectsList(project.getAProject(tempOption));
            project.removeFromList();
            System.out.println("U chose project");
            System.out.println("*********************");
            first.showProjectList();
            System.out.println("*********************");
            System.out.println("The Project successful added\nActive Projects: " + first.activeProjects());
            return true;
        }
        return false;
    }

    public void addPoint() {
        first.addPoint();
        endDay();
    }

    public boolean programmingDay() {
        if (first.activeProjects() == 0) {
            System.out.println("Its look like u don't have any project sign a someone");
            if (signAContract() == true) endDay();
        } else if (first.activeProjects() == 1) {
            boolean checkingProject = project.parseSkills(first.getLastObjectFromProject(), first.skillsToProject());
            if (checkingProject == true) {
                System.out.println("Sure u have enough skills for this project");
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
                System.out.println("U cant work on this project u don't have probably mobile skills");
            }
        } else {
            first.showProjectList();
            System.out.println(first.activeProjects() + ". Exit\nThis is Ur Projects on what one u want work ? chose");
            Integer TempInt = seciurityInPutInt(first.activeProjects());
            boolean checkingProject = project.parseSkills(first.getProject(TempInt), first.skillsToProject());
            if ((TempInt != first.activeProjects()) && (checkingProject == true)) {
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
            Integer TempInt = seciurityInPutInt(first.activeProjects());
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

    public boolean handOverTheProject() {
        if ((first.activeProjects() == 0) && (first.finishedProjects() == 0)) {
            System.out.println("U dont have any project ");
        } else if (first.finishedProjects() != 0) {
            if (first.finishedProjects() == 1) {
                System.out.println("U have only one project to handOver");
                first.updateFinishedProject(project.changeStatus(first.getLastFinishedProject()), first.finishedProjects() - 1);
                return true;
            } else {
                System.out.println("There is ur Finished projects:");
                first.showFinishedProject();
                Integer tempInt = seciurityInPutInt(first.finishedProjects() - 1);
                first.updateFinishedProject(project.changeStatus(first.getFinishedProject(tempInt)), tempInt);
                return true;
            }
        } else if (first.activeProjects() != 0) {
            System.out.println("U realy want hand over not finished project?");
            System.out.println("0. yes");
            System.out.println("1. No");
            if (seciurityInPutInt(1) == 0) {
                if (first.activeProjects() == 1) {
                    System.out.println("U have only one project to handOver");
                    first.updateDataProjectList(project.changeStatus(first.getLastObjectFromProject()), first.activeProjects() - 1);
                    first.updateDataProjectList(project.dontMoneyForU(first.getLastObjectFromProject()), first.activeProjects() - 1);
                    return true;
                } else {
                    System.out.println("There is ur projects:");
                    first.showProjectList();
                    Integer tempInt = seciurityInPutInt(first.activeProjects() - 1);
                    first.updateDataProjectList(project.changeStatus(first.getProject(tempInt)), tempInt);
                    first.updateDataProjectList(project.dontMoneyForU(first.getProject(tempInt)), tempInt);
                    //określić czy dostanie się hajsiwo za projekt
                    return true;
                }
            }
        }
        return false;
    }

    public void hireAnEmployee() {
        first.hireEmployee();
        switch (seciurityInPutInt(5)) {
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
        if (first.dissmisEmploye() == true) endDay();
    }

    public void paperTimeDay() {
        this.zus--;
    }

    public void schowLists() {
        System.out.println("****************");
        System.out.println("Active Project List: " + first.activeProjects());
        first.showProjectList();
        System.out.println("****************");
        System.out.println("****************");
        System.out.println("Finished project List:" + first.finishedProjects());
        first.showFinishedProject();
        System.out.println("****************");
        System.out.println("****************");
        System.out.println("Hired Programmer List:" + first.getNumberOfProgrammers());
        first.showMyProgramerList();
        System.out.println("****************");
        System.out.println("****************");
        System.out.println("Hired testers :" + first.getNumberOfTesters());
        System.out.println("Hired dealers :" + first.getNumberOfDealers());
    }

    public boolean giveProjectToFriend() {
        first.showFriend();
        System.out.println("Which one u chose");
        Friend tempObject = first.getFriend(seciurityInPutInt(first.getMyFriendList().size()));
        String[] tempStringTab = friend.getSkills(tempObject);
        if (first.activeProjects() == 0) {
            System.out.println("Its look like u don't have any project sign a someone");
            if (signAContract() == true) endDay();
        } else if (first.activeProjects() == 1) {
            boolean checkingProject = project.parseSkills(first.getLastObjectFromProject(), tempStringTab);
            if (checkingProject == true) {
                System.out.println("Sure Ur friend have enough skills for this project");
                System.out.println("Its Look Like u have only one project to work and u will give this to ur friend:");
                first.showProjectList();
                first.addprojectsGivedToFriends(first.getLastObjectFromProject());
                first.removeProject(first.getLastObjectFromProject());
                return true;
            } else {
                System.out.println("Ur friend cant work on this project he doesn't have  skills requirement");
            }
        } else {
            first.showProjectList();
            System.out.println(first.activeProjects() + ". Exit\nThis is Ur Projects on what one u want work ? chose");
            Integer TempInt = seciurityInPutInt(first.activeProjects());
            boolean checkingProject = project.parseSkills(first.getProject(TempInt), tempStringTab);
            if ((TempInt != first.activeProjects()) && (checkingProject == true)) {
                first.addprojectsGivedToFriends(first.getProject(TempInt));
                first.removeProject(first.getProject(TempInt));
                return true;
            }
        }
        return false;
    }

    public void endDay() {
        for (int i = 0; i < first.getMyProjectList().size(); i++) {
            if ((project.getDateOfCommissioning(first.getMyProjectList().get(i)).isBefore(days) == true)
                    && (project.status(first.getMyProjectList().get(i)) == false)) {
                first.setCash(-project.getAmount_Of_Penalty(first.getMyProjectList().get(i)));
            }
            if ((project.status(first.getMyProjectList().get(i)) == true) &&
                    (project.getClientPayDay(first.getMyProjectList().get(i)).isBefore(days) == true) &&
                    (project.getPayed(first.getMyProjectList().get(i)))) {
                first.setCash(project.getPrice(first.getMyProjectList().get(i)));
                first.updateDataProjectList(project.payed(first.getMyProjectList().get(i)), i);
            }
        }// this loop verify every day my project
        for (int i = 0; i < first.finishedProjects(); i++) {
            if ((project.getDateOfCommissioning(first.getFinishedProject(i)).isBefore(days) == true)
                    && (project.status(first.getFinishedProject(i)) == false)) {
                first.setCash(-project.getAmount_Of_Penalty(first.getFinishedProject(i)));
            }
            if ((project.status(first.getFinishedProject(i)) == true)
                    && (project.getClientPayDay(first.getFinishedProject(i)).isBefore(days) == true)
                    && (project.getPayed(first.getFinishedProject(i)) == false)) {
                first.setCash(project.getPrice(first.getFinishedProject(i)));
                first.updateFinishedProject(project.payed(first.getFinishedProject(i)), i);
            }
        }
        for (int i = 0; i < first.getProjectsGivedToFriendst().size(); i++) {
            if ((project.getDateOfCommissioning(first.getProjectsGivedToFriendst().get(i)).isBefore(days) == true)
                    && (project.status(first.getProjectsGivedToFriendst().get(i)) == false)) {
                first.setCash(-project.getAmount_Of_Penalty(first.getMyProjectList().get(i)));
            }
            if ((project.status(first.getProjectsGivedToFriendst().get(i)) == true) &&
                    (project.getClientPayDay(first.getProjectsGivedToFriendst().get(i)).isBefore(days) == true) &&
                    (project.getPayed(first.getProjectsGivedToFriendst().get(i)))) {
                first.setCash(project.getPrice(first.getProjectsGivedToFriendst().get(i)) / 10);
                first.updateDataProjectList(project.payed(first.getProjectsGivedToFriendst().get(i)), i);
            }
        }
        if ((days.getDayOfWeek().equals(DayOfWeek.SATURDAY) == false) && (days.getDayOfWeek().equals(DayOfWeek.SUNDAY) == false)) {
            for (int i = 0; i < first.getNumberOfProgrammers(); i++) {
                if (randomInt(100) < 10) {
                    System.out.println("Its look like someone Programmer is sick today");
                } else {
                    {
                        if (first.activeProjects() == 0) {
                            System.out.println("Its look like Employee don't have any project sign a someone");

                        } else if (first.activeProjects() == 1) {
                            boolean checkingProject = project.parseSkills(first.getLastObjectFromProject(), first.getProgrammerSkills(i));

                            if (checkingProject == true) {
                                System.out.println("Now Ur programmer Working ");
                                System.out.println("Sure u have enough skills for this project");
                                System.out.println("Its Look Like u have only one project to work and u will be work on this project: ");
                                first.showProjectList();
                                Project tempObj = first.getLastObjectFromProject();
                                Integer tempInt = checkProjectStatusSkills(tempObj);
                                checkProjectStatus(tempInt, checkProjectStatusTest(tempObj), tempObj);
                                if (tempInt != 0) {
                                    first.updateDataProjectList(project.setNewHours(tempObj), first.activeProjects() - 1);

                                } else {
                                    System.out.println("\nU cant work on this project because is finished");
                                }
                            } else {
                                System.out.println("Employee cant work on this project he don't have enough skills");
                            }

                        } else {
                            first.showProjectList();
                            System.out.println(first.activeProjects() + ". Exit\nThis is Ur Projects on what one u want work ? chose");

                            Integer TempInt = seciurityInPutInt(first.activeProjects());
                            boolean checkingProject = project.parseSkills(first.getProject(TempInt), first.getProgrammerSkills(i));
                            if ((TempInt != first.activeProjects()) && (checkingProject == true)) {
                                Project tempObj = first.getProject(TempInt);
                                Integer tempInt = checkProjectStatusSkills(tempObj);
                                checkProjectStatus(tempInt, checkProjectStatusTest(tempObj), tempObj);
                                if (tempInt != 0) {
                                    first.updateDataProjectList(project.setNewHours(first.getProject(TempInt)), TempInt);

                                } else {
                                    System.out.println("\nU cant work on this project because is finished");
                                }

                            }


                        }

                    }

                }//programmers working
            }//programmers working day monday-fiday
            for (int i = 0; i < first.getNumberOfTesters(); i++) {
                testUrApp();
            }
        }
        if (days.getDayOfMonth() == 25) {
            if (zus != 0) {
                for (; ; ) {
                    System.out.println("U lose Zus Destroyed u");
                }
            }
            zus = 2;
            first.payForMonth();
        }
        days = days.plusDays(1);
        playedDays++;
    }
}




