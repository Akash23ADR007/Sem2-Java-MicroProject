import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
class Student {
    protected String name;
    protected int rollNumber;
    public Student(String name, int rollNumber) {
        this.name = name;
        this.rollNumber = rollNumber;
    }
    public String getName() {
        return name;
    }
    public int getRollNumber() {
        return rollNumber;
    }
    public void displayStudentInfo() {
        System.out.println("Student Name: " + name);
        System.out.println("Roll Number: " + rollNumber);
    }
}
class Performance extends Student {
    private HashMap<String, Integer> subjectMarks;
    public Performance(String name, int rollNumber) {
        super(name, rollNumber);
        subjectMarks = new HashMap<>();
    }
    public void addMarks(String subject, int marks) {
        subjectMarks.put(subject, marks);
    }
    public Integer getMarks(String subject) {
        return subjectMarks.get(subject);
    }
    public void displayStudentInfo() {
        super.displayStudentInfo();
        System.out.println("Performance: ");
        for (String subject : subjectMarks.keySet()) {
            System.out.println(subject + ": " + subjectMarks.get(subject));
        }
    }
    public double calculateAverage() {
        int total = 0;
        for (int marks : subjectMarks.values()) {
            total += marks;
        }
        return subjectMarks.size() > 0 ? (double) total / subjectMarks.size() : 0;
}
}
public class StudentPerformanceTrackingSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Performance> students = new ArrayList<>();
        System.out.println("Student Performance Tracking System");
        for (Performance student : students) {
            student.displayStudentInfo();
            System.out.println("Average Marks: " + student.calculateAverage());
            System.out.println();
        }
        while (true) {
            System.out.println("Do you want to see your performance? (yes/no): ");
            String response = scanner.nextLine();
            if (response.equalsIgnoreCase("no")) {
                break;
            }
            System.out.print("Enter student name: ");
            
String name = scanner.nextLine();
            System.out.print("Enter roll number: ");
            int rollNumber = Integer.parseInt(scanner.nextLine());
            Performance newStudent = new Performance(name, rollNumber);
            while (true) {
                System.out.print("Enter subject : ");
                String subject = scanner.nextLine();
                if (subject.equalsIgnoreCase("done")) {
                    break;
                }
                System.out.print("Enter marks for " + subject + ": ");
                int marks = Integer.parseInt(scanner.nextLine());
                newStudent.addMarks(subject, marks);
            }
            students.add(newStudent);
        }
        System.out.println("\nStudent List:");
        for (Performance student : students) {
            student.displayStudentInfo();
            System.out.println("Average Marks: " + student.calculateAverage());
            System.out.println();
        }
        scanner.close();
    }
}
