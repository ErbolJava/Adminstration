package Services;

import Basics.Gender;
import Basics.Group;
import Basics.Lesson;
import Basics.Student;

import java.util.List;

public interface AdministrationInterface {
    Group creatingNewGroup(List<Group> groups);

    void getGroupByName(List<Group> groups);

    Group upDatingGroupName(List<Group>groups) throws MyExc;

    void getAllGroups(List<Group> groups);

    List<Group> addStudentToGroup(List<Group>groups);

    List<Group> updatingStudent(List<Group>groups);

    Student getStudentByFirstName(List<Group> groups);

    List<Student> getAllStudentsByGroupName(List<Group> groups);

    Group addLessonToGroup(List<Group> groups);

    List<Lesson> getAllStudentsLessons(List<Group> groups);

    String deletingStudent(List<Group>groups);

    Lesson gettingLessonByName(List<Group> groups);

    List<Lesson> gettingAllLessonsByGroupsName(List<Group> groups);

    String removingLesson(List<Group> groups);

    String removingGroup(List<Group> groups);
}
