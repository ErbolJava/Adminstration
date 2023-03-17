package Services;

import Basics.Gender;
import Basics.Group;
import Basics.Lesson;
import Basics.Student;

import java.util.List;

public interface AdministrationInterface {
    Group creatingNewGroup(List<Group> groups);

    void getGroupByName(List<Group> groups);

    Group upgradingGroupName(List<Group>groups) throws MyExc;

    void getAllGroups(List<Group> groups);

    List<Group> addStudentToGroup(List<Group>groups);

    List<Group> updatingStudent(String oldFirstName, String oldLastName, String newFirstName, String newLastname);

    Student getStudentByFirstName(List<Group> groups);

    List<Student> getAllStudentsByGroupName(List<Group> groups);

    String addLessonToGroup(List<Group> groups, String inputName, String inputDescription);

    Lesson getAllStudentsLessons(List<Student> students);

    String deletingStudent(List<Student> students);

    Lesson gettingLessonByName(List<Group> groups);

    List<Lesson> gettingAllLessonsByGroupsName(List<Lesson> lessons, List<Group> groups);

    String removingLesson(List<Group> groups);

    String removingGroup(List<Group> groups);
}
