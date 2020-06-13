package Company.Project;

import Company.CreateRandom;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;


public class Project extends CreateRandom {

    String name;
    String nameClient;

    List<Technology> technology;
    Double price;
    Double amount_Of_Penalty;
    String complexity;
    LocalDate payDay;
    Integer clientId;

    public Project(String nName, String nNameClient, Double price, String nComplexity, Integer nClientId,) {
        this.name = nName;
        this.nameClient = nNameClient;
        this.price = price;
        this.complexity = nComplexity;
        this.clientId = nClientId;
        this.technology= new LinkedList<>();


    }


    List<Project> listOfProject = new LinkedList<>();

    public void viewListOfProject() {
        listOfProject.add(new Project())
    }


}

