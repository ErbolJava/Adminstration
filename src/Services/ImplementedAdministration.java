package Services;

import Basics.Gender;
import Basics.Group;
import Basics.Lesson;
import Basics.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static Basics.Gender.F;


public class ImplementedAdministration implements AdministrationInterface {
    private static int idCounter;
    List<Student> students = new ArrayList<>();

    @Override
    public Group creatingNewGroup(List<Group> groups) {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter the name of the new group: ");
            String groupName = scanner.nextLine();

            for (Group group : groups) {
                if (group.getGroupName().equalsIgnoreCase(groupName)) {
                    throw new MyExc("A group with the same name already exists.");
                }
            }

            System.out.println("Enter a description for the new group: ");
            String description = scanner.nextLine();

            Group newGroup = new Group();
            newGroup.setGroupName(groupName);
            newGroup.setDescription(description);
            idCounter++;
            newGroup.setId(idCounter);

            System.out.println("The new group has been created.");
            groups.add(newGroup);
            return newGroup;

        } catch (MyExc e) {
            System.out.println(e.getMessage());
        }

        return null;
    }

    @Override
    public void getGroupByName(List<Group> groups) {
        boolean loop = true;
        try {
            System.out.println("Write here name of the group: ");
            String inputGroupName = new Scanner(System.in).nextLine();
            for (Group group : groups) {
                if (group.getGroupName().equalsIgnoreCase(inputGroupName)) {
                    System.out.println(group);
                } else {
                    loop = false;
                }
            }
            if (loop) {
                for (Group group : groups) {
                    if (group.getGroupName().equalsIgnoreCase(inputGroupName)) {
                        System.out.println(group);
                        loop = false;
                    }
                    if (!loop){
                        throw new MyExc("Group not found");
                    }
                }
            }
        } catch (MyExc e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public Group upDatingGroupName(List<Group> groups) throws MyExc {
        System.out.println("Which group's name you're going to change?");
        String inputGroupName = new Scanner(System.in).nextLine();
        try {
            boolean loop = true;
            for (Group group : groups) {
                if (inputGroupName.equalsIgnoreCase(group.getGroupName())) {
                    System.out.println("Print new name: ");
                    String inputNewGroupName = new Scanner(System.in).nextLine();
                    group.setGroupName(inputNewGroupName);
                    loop = true;
                } else {
                    loop = false;
                }
            }
            if (!loop) {
                throw new MyExc("Invalid group name");
            }
        } catch (MyExc e) {
            System.out.println(e.getMessage());
        }
        for (Group group : groups) {
            return group;
        }
        return null;
    }

    @Override
    public void getAllGroups(List<Group> groups) {
        for (Group g : groups) {
            System.out.println(g);
        }
    }

    @Override
    public List<Group> addStudentToGroup(List<Group> groups) {
        Student student = new Student();
        try {
            System.out.println("Input FirstName: ");
            String inputFirstName = new Scanner(System.in).nextLine();
            for (int i = 0; i < inputFirstName.length(); i++) {
                if (Character.isDigit(inputFirstName.charAt(i))) {
                    throw new MyExc("First name cannot contain numbers.");
                }
            }
            System.out.println("Input LastName: ");
            String inputLastName = new Scanner(System.in).nextLine();
            for (int i = 0; i < inputLastName.length(); i++) {
                if (Character.isDigit(inputLastName.charAt(i))) {
                    throw new MyExc("First name cannot contain numbers.");
                }
            }
            System.out.println("Input email address: ");
            String inputEmail = new Scanner(System.in).nextLine();
            if (!inputEmail.contains("@")) {
                throw new MyExc("You've skipped domain");
            }
            System.out.println("Create password for your email: ");
            String inputPassword = new Scanner(System.in).nextLine();
            if (inputPassword.length() < 7) {
                throw new MyExc("Length of the password should be at minimum 7");
            }
            System.out.println("Write M/m if you are male, else print F/f");
            String inputGender = new Scanner(System.in).nextLine().toLowerCase();
            switch (inputGender) {
                case "m" -> student.setGender(Gender.M);
                case "f" -> student.setGender(Gender.F);
                default -> throw new MyExc("Gender Error");
            }
            System.out.println("to which group to add this student?: ");
            String toGroup = new Scanner(System.in).nextLine();
            boolean groupFound = false;
            for (Group gr : groups) {
                if (toGroup.equalsIgnoreCase(gr.getGroupName())) {
                    student.setFirstName(inputFirstName);
                    student.setLastName(inputLastName);
                    student.setEmailAddress(inputEmail);
                    student.setPassword(inputPassword);
                    gr.getStudents().add(student);
                    groupFound = true;
                    break;
                }
            }
            if (!groupFound) {
                throw new MyExc("Group not found");
            }
            System.out.println("Student added successfully");
            return groups;

        } catch (MyExc e) {
            System.out.println(e.getMessage());
        }
        return groups;
    }

    @Override
    public List<Group> updatingStudent(List<Group> groups) {
        try {
            System.out.println("Which student's name do you want to update?");
            String inputStudentsFirstName = new Scanner(System.in).nextLine();

            if (inputStudentsFirstName.matches(".*\\d.*")) {
                throw new MyExc("Name should not contain any number");
            }

            boolean studentFound = false;
            for (Group group : groups) {
                for (Student student : group.getStudents()) {
                    if (inputStudentsFirstName.equalsIgnoreCase(student.getFirstName())) {
                        System.out.println("Write the new name: ");
                        String inputNewName = new Scanner(System.in).nextLine();
                        student.setFirstName(inputNewName);
                        studentFound = true;
                        break;
                    }
                }
                if (studentFound) {
                    break;
                }
            }

            if (!studentFound) {
                throw new MyExc("Student not found");
            }
        } catch (MyExc e) {
            System.out.println(e.getMessage());
        }
        return groups;
    }

    @Override
    public Student getStudentByFirstName(List<Group> groups) {
        System.out.println("Name of student: ");
        String inputFirstName = new Scanner(System.in).nextLine();
        boolean found = false;
        for (Group group : groups) {
            for (Student student : group.getStudents()) {
                if (student.getFirstName().equalsIgnoreCase(inputFirstName)) {
                    System.out.println(student);
                    found = true;
                }
            }
        }
        if (!found) {
            System.out.println("Student not found");
        }
        return null;
    }

    @Override
    public List<Student> getAllStudentsByGroupName(List<Group> groups) {
        System.out.println("From which group you want to get students?");
        String inputGroupName = new Scanner(System.in).nextLine();

        boolean groupFound = false;
        for (Group group : groups) {
            if (inputGroupName.equalsIgnoreCase(group.getGroupName())) {
                System.out.println("Students in group " + group.getGroupName() + ":");
                for (Student student : group.getStudents()) {
                    System.out.println(student);
                }
                groupFound = true;
                break;
            }
        }

        if (!groupFound) {
            try {
                throw new MyExc("Group not found");
            } catch (MyExc e) {
                System.out.println(e.getMessage());
            }
        }

        return null;
    }

    @Override
    public Group addLessonToGroup(List<Group> groups) {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter the name of the lesson: ");
            String lessonName = scanner.nextLine();
            System.out.println("Enter the description of the lesson: ");
            String lessonDescription = scanner.nextLine();

            Lesson newLesson = new Lesson(lessonName, lessonDescription);

            System.out.println("Enter the name of the group to add the lesson to: ");
            String groupName = scanner.nextLine();

            boolean groupFound = false;
            for (Group group : groups) {
                if (group.getGroupName().equalsIgnoreCase(groupName)) {
                    group.getLessons().add(newLesson);
                    groupFound = true;
                    System.out.println("Lesson added successfully to group: " + group.getGroupName());
                    break;
                }
            }

            if (!groupFound) {
                throw new MyExc("Group not found");
            }
        } catch (MyExc e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
    @Override
    public List<Lesson> getAllStudentsLessons(List<Group> groups)  {
        return null;
    }
    @Override
    public String deletingStudent(List<Group> students) {
        return null;
    }

    @Override
    public Lesson gettingLessonByName(List<Group> groups) {
        return null;
    }

    @Override
    public List<Lesson> gettingAllLessonsByGroupsName(List<Group> groups) {
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
