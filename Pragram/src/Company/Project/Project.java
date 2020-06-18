package Company.Project;

import Company.CreateRandom;
import Company.Human.Client;

import java.time.LocalDate;
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
    LocalDate payDay;
    Integer clientId;
    Integer clientType;
    LocalDate realPayDay;
    boolean isPently;
    Double realPrice;
    Integer requiredTestDays;
    LocalDate dateOfCommissioning;
    LocalDate realDateOfCommissioning;
    boolean isFinished;
    boolean iGotMoney;
    boolean payed;
    Client client = new Client();
    SAD sad = new SAD();

    public Project(String nName,
                   String nNameClient,
                   Double price,
                   String nComplexity,
                   Integer nClientId,
                   Double nAmount_Of_Penalty,
                   LocalDate nPayDay,
                   SAD[] tab,
                   Integer nClientType,
                   LocalDate nClientPayDay,
                   boolean nIsPently,
                   Double nRealPrice,
                   Integer nRequiredTestDays,
                   LocalDate nDateOfCommissioning,
                   boolean nIsFinished,
                   boolean nIGotMoney,
                   boolean nPayed,
                   LocalDate nRealDateOfCommissioning

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
        this.realPayDay = nClientPayDay;
        this.isPently = nIsPently;
        this.realPrice = nRealPrice;
        this.requiredTestDays = nRequiredTestDays;
        this.dateOfCommissioning = nDateOfCommissioning;
        this.isFinished = nIsFinished;
        this.iGotMoney = nIGotMoney;
        this.payed = nPayed;
        this.realDateOfCommissioning = nRealDateOfCommissioning;
    }

    List<Project> listOfProject = new LinkedList<>();

    public Project() {
    }

    public void generateProject(Integer skills, Integer days, LocalDate acctualDay) {
        client.checkClientList();
        sad.createSkillAndDaysList(skills, days);
        Integer number = randomInt(33);
        Integer tempInt = sad.getDaysFromList() - sad.getDaysFromList() * randomInt(25) / 100;
        LocalDate PayDay = acctualDay.plusDays(tempInt);
        LocalDate RealPayDay = acctualDay.plusDays(getClientPayDay(tempInt, client.getTypeFromList(number)));
        boolean Pently = chance(client.getTypeFromList(number));
        Integer TypeClient = client.getTypeFromList(number);
        String ClientName = client.getNameClientFromList(number);
        String Complexity = setComplexityInList(sad.copyList());
        Integer RequiredTestDays = tempInt / 3;
        Double Price = sad.setPriceOnList() + (RequiredTestDays * 450);//+
        Double RealPrice = getRealPrice(Price, TypeClient);
        Double ValueOfPently = RealPrice * randomInt(5) / 100;
        LocalDate DateOfCommissioning = acctualDay.plusDays((tempInt / 5) * 7);
        SAD[] TempTab = sad.returSkillAndDays();
        boolean TempBool = iGotMoney(TypeClient);
        LocalDate RealDateOfCommissioning = getRealDateOfCommissioning(DateOfCommissioning);


        listOfProject.add(new Project(generateProjectName(),
                ClientName,
                Price,
                Complexity,
                number,
                ValueOfPently,
                PayDay,
                TempTab,
                TypeClient,
                RealPayDay,
                Pently,
                RealPrice,
                RequiredTestDays,
                DateOfCommissioning,
                false,
                TempBool,
                false,
                RealDateOfCommissioning));
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

    public void numberOfProjects(Integer skills, Integer days, LocalDate acctualDay) {
        generateProject(skills, days, acctualDay);
    }

    public void createProjectList(Integer point, LocalDate acctualDay) {
        Integer number;
        Integer days;
        if (point < 30) {
            days = 20;
            do {
                if (point % 5 == 0) {
                    if (
                            randomInt(2) >= 1) {
                        numberOfProjects(1, days, acctualDay);
                    } else {
                        numberOfProjects(2, days, acctualDay);
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
                        numberOfProjects(3, days, acctualDay);
                    } else if (number >= 20 && number < 60) {
                        numberOfProjects(2, days, acctualDay);
                    } else {
                        numberOfProjects(1, days, acctualDay);
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
                        numberOfProjects(4, days, acctualDay);
                    } else if (number >= 10 && number < 30) {
                        numberOfProjects(3, days, acctualDay);
                    } else if (number >= 30 && number < 65) {
                        numberOfProjects(2, days, acctualDay);
                    } else {
                        numberOfProjects(1, days, acctualDay);
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
                        numberOfProjects(5, days, acctualDay);
                    } else if (number >= 5 && number < 15) {
                        numberOfProjects(4, days, acctualDay);
                    } else if (number >= 15 && number < 50) {
                        numberOfProjects(3, days, acctualDay);
                    } else if (number >= 50 && number < 80) {
                        numberOfProjects(2, days, acctualDay);
                    } else {
                        numberOfProjects(1, days, acctualDay);
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
                        numberOfProjects(6, days, acctualDay);
                    } else if (number >= 20 && number < 40) {
                        numberOfProjects(5, days, acctualDay);
                    } else if (number >= 40 && number < 60) {
                        numberOfProjects(4, days, acctualDay);
                    } else if (number >= 60 && number < 80) {
                        numberOfProjects(3, days, acctualDay);
                    } else if (number >= 80 && number < 90) {
                        numberOfProjects(2, days, acctualDay);
                    } else {
                        numberOfProjects(1, days, acctualDay);
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
                        numberOfProjects(6, days, acctualDay);
                    } else if (number >= 5 && number < 15) {
                        numberOfProjects(5, days, acctualDay);
                    } else if (number >= 15 && number < 40) {
                        numberOfProjects(4, days, acctualDay);
                    } else if (number >= 40 && number < 65) {
                        numberOfProjects(3, days, acctualDay);
                    } else if (number >= 65 && number < 90) {
                        numberOfProjects(2, days, acctualDay);
                    } else {
                        numberOfProjects(1, days, acctualDay);
                    }
                }
                point = point - 1;
            } while (point > 0);

        } else if (point >= 500) {
            days = 150;
            do {
                if (point % 5 == 0) {
                    numberOfProjects(6, days, acctualDay);
                }
                point = point - 1;
            } while (point > 0);
        }
    }

    public void removeFromList() {
        listOfProject.clear();
    }

    public void showListOfProject() {
        Integer i = 0;
        for (Project project : listOfProject) {
            System.out.println(i + ". " + project);
            i++;
        }
    }

    public boolean iGotMoney(Integer clienttype) {
        if (clienttype == 3) {
            return false;
        }
        if (randomInt(100) > 50 && clienttype == 2) {
            return false;
        } else {
            return true;
        }
    }

    public boolean chance(Integer Type) {
        boolean value = false;
        if (randomInt(100) <= 20 && Type == 1) {
            value = true;
        }
        return value;
    }

    public boolean getPayed(Project project) {
        return project.payed;
    }

    public boolean parseSkills(Project project, String[] Tab) {
        SAD[] tab = fromProjectToSADtab(project);
        return sad.parseSkills(tab, Tab);
    }

    public boolean status(Project project) {
        return project.isFinished;
    }

    public Double getAmount_Of_Penalty(Project project) {
        return project.amount_Of_Penalty;
    }

    public Double getPrice(Project project) {
        return project.realPrice;
    }

    public Double getRealPrice(Double price, Integer Type) {
        Double temp = price;
        if (randomInt(100) == 1 && Type == 3) {
            temp = 0.0;
        }
        return temp;
    }

    public SAD[] fromProjectToSADtab(Project project) {
        return project.listSADtab;
    }

    public Integer getClientPayDay(Integer days, Integer Type) {
        Integer value = days;
        if (randomInt(100) <= 30 && (Type == 1 || Type == 3)) {
            value = value + 5;
        }
        if (randomInt(100) <= 5 && Type == 3) {
            value = value + 20;
        }
        return value;
    }

    public Integer getSizeOfList() {
        return listOfProject.size();
    }

    public Integer checkProjectStatusSkills(Project project) {
        SAD[] tab = fromProjectToSADtab(project);
        return sad.checkStatus(tab);
    }

    public Integer getRequiredTestDays(Project project) {
        return project.requiredTestDays;
    }

    public Project getAProject(Integer Option) {
        return listOfProject.get(Option);
    }

    public Project setNewHours(Project project) {
        SAD[] tab = fromProjectToSADtab(project);
        project.listSADtab = sad.workDay(tab);
        return project;
    }

    public Project setNewTestingHours(Project project) {
        project.requiredTestDays--;
        return project;
    }

    public Project changeStatus(Project project) {
        project.isFinished = true;
        return project;
    }

    public Project payed(Project project) {
        project.payed = true;
        return project;
    }

    public LocalDate getRealDateOfCommissioning(LocalDate date) {
        return date.plusDays(5);
    }

    public Project dontMoneyForU(Project project) {
        if (project.iGotMoney == false) {
            project.realDateOfCommissioning.plusYears(1000000000);
            project.payDay.plusYears(1000000000);
            project.realPayDay.plusYears(1000000000);
            project.dateOfCommissioning.plusYears(1000000000);

        }
        return project;
    }

    public LocalDate getDateOfCommissioning(Project project) {
        return project.realDateOfCommissioning;
    }

    public LocalDate getClientPayDay(Project project) {
        return project.realPayDay;
    }

    @Override
    public String toString() {
        return "Project{" +
                "name='" + name + '\'' +
                ", nameClient='" + nameClient + '\'' +
                ", Skills to this project: " + Arrays.toString(listSADtab) +
                ", price=" + price +
                ", amount_Of_Penalty=" + amount_Of_Penalty +
                ", complexity='" + complexity + '\'' +
                ", payDay=" + payDay +
                ", requiredTestDays=" + requiredTestDays +
                ", dateOfCommissioning=" + dateOfCommissioning;

    }
}


