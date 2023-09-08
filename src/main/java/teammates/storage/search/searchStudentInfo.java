import java.util.List;

public class Main {
    public static void main(String[] args) {
        StudentDatabase studentDb = new StudentDatabase();

        // Add sample student data to the database
        studentDb.addStudent(new Student("John", 101, 85.5));
        studentDb.addStudent(new Student("Jane", 102, 90.0));
        studentDb.addStudent(new Student("Alice", 103, 78.2));
        studentDb.addStudent(new Student("Bob", 104, 92.5));

        // Search for a student by ID
        int searchId = 102;
        Student foundStudent = studentDb.searchStudentById(searchId);

        if (foundStudent != null) {
            System.out.println("Student found:");
            System.out.println("Name: " + foundStudent.getName());
            System.out.println("ID: " + foundStudent.getId());
            System.out.println("Grade: " + foundStudent.getGrade());
        } else {
            System.out.println("Student not found.");
        }
    }
}
