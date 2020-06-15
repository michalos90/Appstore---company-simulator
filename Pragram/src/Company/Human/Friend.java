package Company.Human;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Friend extends Programer {
    Integer type;

    public Friend(String nName, String nLastName, String[] nSkill, Integer nType) {
        this.firstName = nName;
        this.lastName = nLastName;
        this.skills = nSkill;
        this.type = nType;

    }

    List<Friend> friendList = new LinkedList<>();

    public Friend() {

    }

    public void generateFriend() {
        for (int i = 0; i < 3; i++) {

            friendList.add(new Friend(generateName(), generateLastName(), uniqueSkills(), i));
        }
    }

    public void showFriend() {
        for (Friend item : friendList) {
            System.out.println(item);
        }
    }

    public List<Friend> getFriendList() {
        return friendList;
    }

    @Override
    public String toString() {
        return "\nfirstName='" + firstName + '\'' +
                "\nlastName='" + lastName + '\'' +
                "\n skills=" + Arrays.toString(skills) +
                "\nType=" + type;
    }

    public Friend getFriend(int number) {
        return friendList.get(number);
    }

    public String[] getSkills(Friend friend) {
        return friend.skills;
    }
}




