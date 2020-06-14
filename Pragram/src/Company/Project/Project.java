package Company.Project;

import Company.CreateRandom;
import Company.Human.Client;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;


public class Project extends CreateRandom {

    String name;
    String nameClient;

    // List<SkillAndDays> ListSkillAndDays;
    SkillAndDays[] ListSkillAndDaystab;//
    Double price;
    Double amount_Of_Penalty;
    String complexity;
    Integer payDay;
    Integer clientId;

    Integer clientType;
    Integer clientPayDay;
    boolean isPently;
    Double realPrice;

    Client client = new Client();
    SkillAndDays skillAndDays = new SkillAndDays();

    public Project(String nName,
                   String nNameClient,
                   Double price,
                   String nComplexity,
                   Integer nClientId,
                   Double nAmount_Of_Penalty,
                   Integer nPayDay,
                   //   List<SkillAndDays> nList,//
                   SkillAndDays[] tab,//
                   Integer nClientType,
                   Integer nClientPayDay,
                   boolean nIsPently,
                   Double nRealPrice


    ) {
        this.name = nName;
        this.nameClient = nNameClient;
        this.price = price;
        this.amount_Of_Penalty = nAmount_Of_Penalty;
        this.complexity = nComplexity;
        this.payDay = nPayDay;
        this.clientId = nClientId;
        // this.ListSkillAndDays = nList;//
        this.ListSkillAndDaystab = new SkillAndDays[6];//
        this.ListSkillAndDaystab = tab;
        this.clientType = nClientType;
        this.clientPayDay = nClientPayDay;
        this.isPently = nIsPently;
        this.realPrice = nRealPrice;


    }


    List<Project> listOfProject = new LinkedList<>();


    public Project() {

    }

    public void generateListOfProject() {
        client.checkClientList();
        skillAndDays.createSkillAndDaysList(2);

        Integer number = randomInt(33);
        Integer mDays = skillAndDays.getDaysFromList() - skillAndDays.getDaysFromList() * randomInt(25) / 100;
        Integer ClientPayDay = getClientPayDay(mDays, client.getTypeFromList(number));

        boolean Pently = chance(client.getTypeFromList(number));
        List<SkillAndDays> tempList = new LinkedList<>();
        tempList = skillAndDays.copyList();
        Integer TypeClient = client.getTypeFromList(number);
        Double Price = skillAndDays.setPriceOnList();
        Double RealPrice = getRealPrice(Price, TypeClient);
        String ClientName = client.getNameClientFromList(number);
        String Complexity = setComplexityInList(skillAndDays.copyList());

        listOfProject.add(new Project(generateProjectName(),
                ClientName,
                Price,
                Complexity,
                number,
                20.5,
                mDays,
                skillAndDays.returSkillAndDays(),
                TypeClient,
                ClientPayDay,
                Pently,
                RealPrice
        ));


    }


    public String setComplexityInList(List<SkillAndDays> list) {
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

        boolean value = false;

        if (randomInt(100) <= 20 && Type == 1) {
            value = true;
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

    } //checking type 3 client witch payments


    @Override
    public String toString() {
        return "Project{" +
                "name='" + name + '\'' +
                ", nameClient='" + nameClient + '\'' +
                ", ListSkillAndDaystab=" + Arrays.toString(ListSkillAndDaystab) +
                ", price=" + price +
                ", amount_Of_Penalty=" + amount_Of_Penalty +
                ", complexity='" + complexity + '\'' +
                ", payDay=" + payDay +
                ", clientId=" + clientId +
                ", clientType=" + clientType +
                ", clientPayDay=" + clientPayDay +
                ", isPently=" + isPently +
                ", realPrice=" + realPrice +
                ", client=" + client +
                ", skillAndDays=" + skillAndDays +
                '}';
    }
}

