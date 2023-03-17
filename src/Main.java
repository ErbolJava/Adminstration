import Basics.Group;
import Services.ImplementedAdministration;
import Services.MyExc;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;

public class Main {

    public static void main(String[] args) throws MyExc {
        ImplementedAdministration implementedAdministration = new ImplementedAdministration();
        List<Group> groups = new ArrayList<>();
        if (LocalDateTime.now().getHour() < 12) {
            System.out.println("Good morning " + LocalDateTime.now().getHour() + ":" + LocalDateTime.now().getMinute());
        } else if (LocalDateTime.now().getHour() > 12 && LocalDateTime.now().getHour() < 18) {
            System.out.println("Good afternoon " + LocalDateTime.now().getHour() + ":" + LocalDateTime.now().getMinute());
        } else if (LocalDateTime.now().getHour() >= 18) {
            System.out.println("Good evening " + LocalDateTime.now().getHour() + ":" + LocalDateTime.now().getMinute());
        }

        while (true) {
            try {
                System.out.println(
                        """                 
                                                men dagy ondoim ubakyt berinizder biraz
                                1 -> Add new group  2 -> Get group by name  3 -> Update group name
                                4 -> Get all groups 5 -> Add new student to group 6 -> Update student
                                7  -> Find student by first name 8 -> Get all students by group name
                                9  -> Get all student's lesson 10 -> Delete student 11 -> Add new lesson to group
                                12 -> Get lesson by name 13 -> Get all lesson by group name 14 -> Delete lesson
                                                        15 -> Delete group""");
                System.out.println("Write number: ");
                int firstInput = new Scanner(System.in).nextInt();
                switch (firstInput) {
                    case 1 -> implementedAdministration.creatingNewGroup(groups);
                    case 2 -> implementedAdministration.getGroupByName(groups);
                    case 3 -> System.out.println(implementedAdministration.upgradingGroupName(groups));
                    case 4 -> implementedAdministration.getAllGroups(groups);
                    case 5 -> System.out.println(implementedAdministration.addStudentToGroup(groups));
                    default -> throw new MyExc("Something went wrong");
                }

            } catch (MyExc exc) {
                System.out.println(exc.getMessage());
            }
        }
    }
}