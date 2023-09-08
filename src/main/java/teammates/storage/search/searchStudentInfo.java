import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Student {
    private String name;
    private int id;
    private double grade;

    public Student(String name, int id, double grade) {
        this.name = name;
        this.id = id;
        this.grade = grade;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public double getGrade() {
        return grade;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", grade=" + grade +
                '}';
    }
}

public class StudentDatabase {
    private static List<Student> students = new ArrayList<>();

    public static void main(String[] args) {
        // Populate the student database with sample data
        students.add(new Student("John", 101, 85.5));
        students.add(new Student("Jane", 102, 90.0));
        students.add(new Student("Alice", 103, 78.2));
        students.add(new Student("Bob", 104, 92.5));

        // Create a Scanner for user input
        Scanner scanner = new Scanner(System.in);

        // Prompt the user for a student ID to search
        System.out.print("Enter student ID to search: ");
        int searchId = scanner.nextInt();

        // Search for the student by ID
        Student foundStudent = searchStudentById(searchId);

        // Display the search result
        if (foundStudent != null) {
            System.out.println("Student found:");
            System.out.println(foundStudent);
        } else {
            System.out.println("Student not found.");
        }
    }

    // Search for a student by ID in the database
    private static Student searchStudentById(int id) {
        for (Student student : students) {
            if (student.getId() == id) {
                return student;
            }
        }
        return null; // Student not found
    }
}
