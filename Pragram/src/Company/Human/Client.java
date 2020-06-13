package Company.Human;

import java.util.LinkedList;
import java.util.List;

public class Client extends Human {
    Integer type;
    Integer clientId;


    public Client(String name, String nLastName, Integer nClientId, Integer nType) {
        this.firstName = name;
        this.lastName = nLastName;
        this.clientId = nClientId;
        this.type = nType;

    }

    List<Client> clientList = new LinkedList<>();

    public Client() {

    }


    public void createRandomList() {
        for (int i = 0; i < 33; i++) {
            clientList.add(new Client(firstName = createRandomName(11),
                    lastName = createRandomLastName(11),
                    clientId = i,
                    type = createRandomType()));
        }
        for (Client client : clientList) {
            System.out.println(client.firstName);
        }
    }


}
