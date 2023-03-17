package Services;

import Basics.Gender;
import Basics.Group;
import Basics.Lesson;
import Basics.Student;

import java.util.List;
import java.util.Scanner;


public class ImplementedAdministration implements AdministrationInterface {
    private static int idCounter;

    @Override
    public Group creatingNewGroup(List<Group> groups) {
        Group group = new Group();
        try {
                Scanner scanner = new Scanner(System.in);
                System.out.println("Name your group: ");
                String inputGroupName = scanner.nextLine();
                System.out.println("Print some specification: ");
                String description = scanner.nextLine();
                for (Group group2 : groups) {
                    if (group2.getGroupName().equalsIgnoreCase(inputGroupName)) {
                        throw new MyExc("Group name is already exists!");
                    } else {
                        group.setGroupName(inputGroupName);
                        group.setDescription(description);
                        ++idCounter;
                        group.setId(idCounter);
                        groups.add(group);
                        System.out.println("Group has successfully created");
                    }
                }
                    return group;
        } catch (MyExc e) {
            System.out.println(e.getMessage());

        }
        return null;
    }

    @Override
    public void getGroupByName(List<Group> groups) {
        String inputGroupName = new Scanner(System.in).nextLine();
        for (Group group : groups) {
            if (inputGroupName.equalsIgnoreCase(group.getGroupName())) {
                System.out.println(group);
            }
        }
    }

    @Override
    public Group upgradingGroupName(List<Group> groups) throws MyExc {
        System.out.println("Which group's name you're going to change?");
        String inputGroupName = new Scanner(System.in).nextLine();
        try {
            for (Group group : groups) {
                if (inputGroupName.equalsIgnoreCase(group.getGroupName())) {
                    System.out.println("Print new name: ");
                    String inputNewGroupName = new Scanner(System.in).nextLine();
                    group.getGroupName().replaceAll(group.getGroupName(), inputNewGroupName);
                } else {
                    throw new MyExc("Invalid group name or group name already exists");
                }
            }
        } catch (MyExc e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public void getAllGroups(List<Group> groups) {
        for (Group group:groups) {
            System.out.println(group);
        }
    }

    @Override
    public List<Group> addStudentToGroup(List<Group>groups) {
        return null;
    }

    @Override
    public List<Group> updatingStudent(String oldFirstName, String oldLastName, String newFirstName, String newLastname) {
        return null;
    }

    @Override
    public Student getStudentByFirstName(List<Group> groups) {
        return null;
    }

    @Override
    public List<Student> getAllStudentsByGroupName(List<Group> groups) {
        return null;
    }

    @Override
    public String addLessonToGroup(List<Group> groups, String inputName, String inputDescription) {
        return null;
    }

    @Override
    public Lesson getAllStudentsLessons(List<Student> students) {
        return null;
    }

    @Override
    public String deletingStudent(List<Student> students) {
        return null;
    }

    @Override
    public Lesson gettingLessonByName(List<Group> groups) {
        return null;
    }

    @Override
    public List<Lesson> gettingAllLessonsByGroupsName(List<Lesson> lessons, List<Group> groups) {
        return null;
    }

    @Override
    public String removingLesson(List<Group> groups) {
        return null;
    }

    @Override
    public String removingGroup(List<Group> groups) {
        return null;
    }
}
