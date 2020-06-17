package Company.Human;

import Company.CreateRandom;

public class Human extends CreateRandom {
    String firstName;
    String lastName;
    Double cost;

    public Human(String nFirstName, String nLastName, Double nCost) {
        this.firstName = nFirstName;
        this.lastName = nLastName;
        this.cost = nCost;
    }

    public Human() {

    }

    public Human generateTester() {
        return new Human(generateName(), generateLastName(), 3000.0);
    }

    public Human generateDealer() {
        return new Human(generateName(), generateLastName(), 3500.0);
    }
}
