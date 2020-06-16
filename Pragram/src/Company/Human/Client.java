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

    public void checkClientList() {
        if (clientList.size() == 0) {
            generateList();
        }
    }

    public void generateList() {
        for (int i = 0; i <= 33; i++) {
            clientList.add(new Client(firstName = generateName(),
                    lastName = generateLastName(),
                    clientId = i,
                    type = generateType()));
        }

    }

    public String getNameClientFromList(Integer id) {
        String value = "";
        for (Client client : clientList) {
            if (id == client.clientId) {
                value = client.firstName;
            }
        }
        return value;
    }

    public Integer getTypeFromList(Integer id) {
        Integer value = 0;
        for (Client client : clientList) {
            if (id == client.clientId) {
                value = client.type;
            }
        }
        return value;
    }
}
