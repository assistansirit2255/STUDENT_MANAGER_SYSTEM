package service;
import model.Student;
public interface RecordActions {
    void addStudent();
    void deleteStudent(String name);
    void updateStudent(int roll);
    Student searchStudent(String name);
    void viewAllStudents();
}