import service.StudentManager;
import model.Student;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        StudentManager sm=new StudentManager();
        Scanner sc=new Scanner(System.in);
        while(true){
            System.out.println("\n===== Capstone Student Menu =====");
            System.out.println("1. Add Student");
            System.out.println("2. View All Students");
            System.out.println("3. Search by Name");
            System.out.println("4. Delete by Name");
            System.out.println("5. Sort by Marks");
            System.out.println("6. Save and Exit");
            System.out.print("Enter choice: ");
            int ch=sc.nextInt(); sc.nextLine();
            switch(ch){
                case 1->sm.addStudent();
                case 2->sm.viewAllStudents();
                case 3->{
                    System.out.print("Enter name to search: ");
                    Student s=sm.searchStudent(sc.nextLine());
                    if(s!=null) s.displayInfo(); else System.out.println("Not found.");
                }
                case 4->{
                    System.out.print("Enter name to delete: ");
                    sm.deleteStudent(sc.nextLine());
                }
                case 5->sm.sortByMarks();
                case 6->{ sm.saveToFile(); System.out.println("Saved & exiting"); return; }
                default->System.out.println("Invalid choice!");
            }
        }
    }
}