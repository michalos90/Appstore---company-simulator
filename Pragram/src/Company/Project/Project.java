package Company.Project;

import Company.CreateRandom;
import Company.Human.Client;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;


public class Project extends CreateRandom {

    String name;
    String nameClient;
    SAD[] listSADtab;
    Double price;
    Double amount_Of_Penalty;
    String complexity;
    Integer payDay;
    Integer clientId;
    Integer clientType;
    Integer clientPayDay;
    boolean isPently;
    Double realPrice;
    Integer requiredTestDays;
    Integer dateOfCommissioning;
    Client client = new Client();
    SAD SAD = new SAD();

    public Project(String nName,
                   String nNameClient,
                   Double price,
                   String nComplexity,
                   Integer nClientId,
                   Double nAmount_Of_Penalty,
                   Integer nPayDay,
                   SAD[] tab,
                   Integer nClientType,
                   Integer nClientPayDay,
                   boolean nIsPently,
                   Double nRealPrice,
                   Integer nRequiredTestDays,
                   Integer nDateOfCommissioning
    ) {
        this.name = nName;
        this.nameClient = nNameClient;
        this.price = price;
        this.amount_Of_Penalty = nAmount_Of_Penalty;
        this.complexity = nComplexity;
        this.payDay = nPayDay;
        this.clientId = nClientId;
        this.listSADtab = new SAD[6];
        this.listSADtab = tab;
        this.clientType = nClientType;
        this.clientPayDay = nClientPayDay;
        this.isPently = nIsPently;
        this.realPrice = nRealPrice;
        this.requiredTestDays = nRequiredTestDays;
        this.dateOfCommissioning = nDateOfCommissioning;
    }

    List<Project> listOfProject = new LinkedList<>();

    public Project() {

    }

    public void generateProject(Integer skills, Integer days) {
        client.checkClientList();
        SAD.createSkillAndDaysList(skills, days);
        Integer number = randomInt(33);
        Integer mDays = SAD.getDaysFromList() - SAD.getDaysFromList() * randomInt(25) / 100;
        Integer ClientPayDay = getClientPayDay(mDays, client.getTypeFromList(number));
        boolean Pently = chance(client.getTypeFromList(number));
        Integer TypeClient = client.getTypeFromList(number);
        String ClientName = client.getNameClientFromList(number);
        String Complexity = setComplexityInList(SAD.copyList());
        Integer RequiredTestDays = mDays / 3;
        Double Price = SAD.setPriceOnList() + (RequiredTestDays * 450);//+
        Double RealPrice = getRealPrice(Price, TypeClient);
        Double ValueOfPently = RealPrice * randomInt(5) / 100;
        Integer DateOfCommissioning = ClientPayDay - randomInt(7);
        SAD[] TempTab = SAD.returSkillAndDays();


        listOfProject.add(new Project(generateProjectName(),
                ClientName,
                Price,
                Complexity,
                number,
                ValueOfPently,
                mDays,
                TempTab,
                TypeClient,
                ClientPayDay,
                Pently,
                RealPrice,
                RequiredTestDays,
                DateOfCommissioning


        ));


    }

    public void numberOfProjects(Integer skills, Integer days) {
        generateProject(skills, days);
    }

    public void createProjectList(Integer point) {
        Integer number;
        Integer days;
        if (point < 30) {
            days = 20;
            do {
                if (point % 5 == 0) {
                    if (
                            randomInt(2) >= 1) {
                        numberOfProjects(1, days);
                    } else {
                        numberOfProjects(2, days);
                    }

                }
                point = point - 1;
            } while (point > 0);
        } else if (point >= 30 && point < 60) {
            days = 40;
            do {
                if (point % 5 == 0) {

                    number = randomInt(100);
                    if (number < 20) {
                        numberOfProjects(3, days);

                    } else if (number >= 20 && number < 60) {
                        numberOfProjects(2, days);
                    } else {
                        numberOfProjects(1, days);
                    }
                }
                point = point - 1;
            } while (point > 0);
        } else if (point >= 60 && point < 90) {
            days = 50;
            do {
                if (point % 5 == 0) {

                    number = randomInt(100);
                    if (number < 10) {
                        numberOfProjects(4, days);

                    } else if (number >= 10 && number < 30) {
                        numberOfProjects(3, days);
                    } else if (number >= 30 && number < 65) {
                        numberOfProjects(2, days);
                    } else {
                        numberOfProjects(1, days);
                    }
                }
                point = point - 1;
            } while (point > 0);
        } else if (point >= 90 && point < 180) {
            days = 75;
            do {
                if (point % 5 == 0) {

                    number = randomInt(100);
                    if (number < 5) {
                        numberOfProjects(5, days);
                    } else if (number >= 5 && number < 15) {
                        numberOfProjects(4, days);
                    } else if (number >= 15 && number < 50) {
                        numberOfProjects(3, days);
                    } else if (number >= 50 && number < 80) {
                        numberOfProjects(2, days);
                    } else {
                        numberOfProjects(1, days);
                    }
                }
                point = point - 1;
            } while (point > 0);

        } else if (point >= 180 && point < 360) {
            days = 100;
            do {
                if (point % 5 == 0) {

                    number = randomInt(100);
                    if (number < 20) {
                        numberOfProjects(6, days);
                    } else if (number >= 20 && number < 40) {
                        numberOfProjects(5, days);
                    } else if (number >= 40 && number < 60) {
                        numberOfProjects(4, days);
                    } else if (number >= 60 && number < 80) {
                        numberOfProjects(3, days);
                    } else if (number >= 80 && number < 90) {
                        numberOfProjects(2, days);
                    } else {
                        numberOfProjects(1, days);
                    }
                }
                point = point - 1;
            } while (point > 0);

        } else if (point >= 360 && point < 500) {
            days = 150;
            do {
                if (point % 5 == 0) {

                    number = randomInt(100);
                    if (number < 5) {
                        numberOfProjects(6, days);
                    } else if (number >= 5 && number < 15) {
                        numberOfProjects(5, days);
                    } else if (number >= 15 && number < 40) {
                        numberOfProjects(4, days);
                    } else if (number >= 40 && number < 65) {
                        numberOfProjects(3, days);
                    } else if (number >= 65 && number < 90) {
                        numberOfProjects(2, days);
                    } else {
                        numberOfProjects(1, days);
                    }
                }
                point = point - 1;
            } while (point > 0);

        } else if (point >= 500) {
            days = 150;
            do {
                if (point % 5 == 0) {


                    numberOfProjects(6, days);

                }
                point = point - 1;
            } while (point > 0);

        }


    }

    public String setComplexityInList(List<SAD> list) {
        String value = "";
        switch (list.size()) {
            case 1:
                value = "easy";
                break;
            case 2:
                value = "medium";
                break;
            case 3:
                value = "hard";
                break;
            default:
                value = "hard";
        }
        return value;
    }

    public void showListOfProject() {

        for (Project project : listOfProject) {
            System.out.println(project);

        }
    }

    public boolean chance(Integer Type) {

        boolean value = true;

        if (randomInt(100) <= 20 && Type == 1) {
            value = false;
        }
        return value;


    }

    public Integer getClientPayDay(Integer days, Integer Type) {
        Integer value = days;
        if (randomInt(100) <= 30 && (Type == 1 || Type == 3)) {
            value = value + 5;
        }
        return value;
    }

    public Double getRealPrice(Double price, Integer Type) {
        Double temp = price;
        if (randomInt(100) == 1 && Type == 3) {
            temp = 0.0;
        }

        return temp;

    }

    public Integer getSizeOfList() {
        return listOfProject.size();
    }

    public Project getAProject(Integer Option) {
        return listOfProject.get(Option);
    }

    public void removeFromList() {
        listOfProject.clear();
    }

    public SAD[] fromProjectToSADtab(Project project) {
        return project.listSADtab;
    }

    public boolean parseSkills(Project project, String[] Tab) {
        SAD[]tab=fromProjectToSADtab(project);
        return SAD.parseSkills(tab, Tab);
    }

    public Project setNewHours(Project project){

        SAD[] tab= fromProjectToSADtab(project);
project.listSADtab=SAD.workDay(tab);
return project;

    }


    @Override
    public String toString() {
        return "\nname='" + name + '\'' +
                ", \nnameClient='" + nameClient + '\'' +
                ", \nListSkillAndDaystab=" + Arrays.toString(listSADtab) +
                ", \nprice=" + price +
                ", \namount_Of_Penalty per day=" + amount_Of_Penalty +
                ", \ncomplexity='" + complexity + '\'' +
                ", \npayDay=" + payDay + ", \nrequiredTestDays=" + requiredTestDays +
                ", \nrealPrice=" + realPrice +
                ", \nDate Of Comissioing=" + dateOfCommissioning;

    }
}


