package service;
import model.Student;
import util.StudentNotFoundException;
import util.Loader;
import java.io.*; import java.util.*;

public class StudentManager implements RecordActions {
    private List<Student> students = new ArrayList<>();
    private final String FILE = "students.txt";
    public StudentManager() { loadFromFile(); }
    @Override
    public void addStudent() {
        Thread t=new Thread(new Loader()); t.start();
        Student s=new Student(); s.inputDetails(); students.add(s);
        System.out.println("Student Added!");
    }
    @Override
    public void deleteStudent(String name) {
        boolean removed = students.removeIf(s->s.getName().equalsIgnoreCase(name));
        System.out.println(removed? "Student record deleted." : "Student not found!");
    }
    @Override
    public void updateStudent(int roll) {
        for(Student s:students){
            if(s.getRollNo()==roll){
                System.out.println("Enter new details:");
                s.inputDetails(); return;
            }
        }
        System.out.println("Invalid Roll Number!");
    }
    @Override
    public Student searchStudent(String name){
        for(Student s:students) if(s.getName().equalsIgnoreCase(name)) return s;
        return null;
    }
    @Override
    public void viewAllStudents(){
        if(students.isEmpty()){ System.out.println("No records."); return; }
        for(Student s:students){ s.displayInfo(); System.out.println("-----"); }
    }
    public void sortByMarks(){
        students.sort((a,b)->Double.compare(b.getMarks(),a.getMarks()));
        System.out.println("Sorted Student List:");
        for(Student s:students){ s.displayInfo(); System.out.println("-----"); }
    }
    public void saveToFile(){
        try(BufferedWriter bw=new BufferedWriter(new FileWriter(FILE))){
            for(Student s:students){
                bw.write(s.getRollNo()+","+s.getName()+","+s.getEmail()+","+s.getCourse()+","+s.getMarks());
                bw.newLine();
            }
            System.out.println("Saved successfully.");
        } catch(IOException e){ System.out.println("Error saving file."); }
    }
    public void loadFromFile(){
        File file=new File(FILE); if(!file.exists()) return;
        try(BufferedReader br=new BufferedReader(new FileReader(FILE))){
            String line;
            while((line=br.readLine())!=null){
                String[] arr=line.split(",");
                Student s=new Student(Integer.parseInt(arr[0]),arr[1],arr[2],arr[3],Double.parseDouble(arr[4]));
                students.add(s);
            }
        } catch(Exception e){ System.out.println("Error loading file."); }
    }
}