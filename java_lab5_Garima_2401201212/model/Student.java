package model;
import java.util.Scanner;
public class Student extends Person {
    private int rollNo;
    private String course;
    private double marks;
    private String grade;
    public Student() {}
    public Student(int rollNo, String name, String email, String course, double marks) {
        super(name, email);
        this.rollNo = rollNo;
        this.course = course;
        this.marks = marks;
        calculateGrade();
    }
    public void inputDetails() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Roll No: ");
        this.rollNo = sc.nextInt(); sc.nextLine();
        System.out.print("Enter Name: "); this.name = sc.nextLine();
        System.out.print("Enter Email: "); this.email = sc.nextLine();
        System.out.print("Enter Course: "); this.course = sc.nextLine();
        System.out.print("Enter Marks: "); this.marks = sc.nextDouble();
        calculateGrade();
    }
    public void calculateGrade() {
        if (marks >= 90) grade = "A";
        else if (marks >= 75) grade = "B";
        else if (marks >= 60) grade = "C";
        else grade = "D";
    }
    @Override
    public void displayInfo() {
        System.out.println("Roll No: " + rollNo);
        System.out.println("Name: " + name);
        System.out.println("Email: " + email);
        System.out.println("Course: " + course);
        System.out.println("Marks: " + marks);
        System.out.println("Grade: " + grade);
    }
    public int getRollNo() { return rollNo; }
    public String getCourse() { return course; }
    public double getMarks() { return marks; }
}