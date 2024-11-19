import java.util.ArrayList;
import java.util.Scanner;

public class StudentManagement {
    private ArrayList<Student> students = new ArrayList<>();

    // Method to enter student list
    public void enterStudentList() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter number of students: ");
        int numStudents = scanner.nextInt();
        scanner.nextLine(); // Consume newline character

        for (int i = 0; i < numStudents; i++) {
            System.out.println("Enter details for student " + (i + 1));
            System.out.print("First Name: ");
            String firstName = scanner.nextLine();
            System.out.print("Last Name: ");
            String lastName = scanner.nextLine();
            System.out.print("Student ID: ");
            String studentId = scanner.nextLine();
            students.add(new Student(firstName, lastName, studentId));
        }
    }

    // Method to find students by last name
    public void findStudentsByLastName(String lastName) {
        boolean found = false;
        for (Student student : students) {
            if (student.getLastName().equalsIgnoreCase(lastName)) {
                System.out.println(student);
                found = true;
            }
        }
        if (!found) {
            System.out.println("No student found with last name: " + lastName);
        }
    }

    // Method to find and edit students by full name
    public void findAndEditStudentByFullName(String fullName) {
        String[] nameParts = fullName.split(" ");
        if (nameParts.length < 2) {
            System.out.println("Please provide both first and last name.");
            return;
        }
        String firstName = nameParts[0];
        String lastName = nameParts[1];

        for (Student student : students) {
            if (student.getFirstName().equalsIgnoreCase(firstName) && student.getLastName().equalsIgnoreCase(lastName)) {
                System.out.println("Student found: " + student);
                Scanner scanner = new Scanner(System.in);
                System.out.print("Enter new first name (or leave empty to keep current): ");
                String newFirstName = scanner.nextLine();
                if (!newFirstName.isEmpty()) {
                    student.setFirstName(newFirstName);
                }
                System.out.print("Enter new last name (or leave empty to keep current): ");
                String newLastName = scanner.nextLine();
                if (!newLastName.isEmpty()) {
                    student.setLastName(newLastName);
                }
                System.out.print("Enter new student ID (or leave empty to keep current): ");
                String newStudentId = scanner.nextLine();
                if (!newStudentId.isEmpty()) {
                    student.setStudentId(newStudentId);
                }
                System.out.println("Student updated: " + student);
                return;
            }
        }
        System.out.println("Student with full name " + fullName + " not found.");
    }

    // Method to display all students
    public void displayAllStudents() {
        if (students.isEmpty()) {
            System.out.println("No students available.");
        } else {
            for (Student student : students) {
                System.out.println(student);
            }
        }
    }

    // Main method to drive the program
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StudentManagement management = new StudentManagement();
        int choice;

        do {
            System.out.println("\nStudent Management System");
            System.out.println("1. Enter student list");
            System.out.println("2. Find students by last name");
            System.out.println("3. Find and edit students by full name");
            System.out.println("4. End");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    management.enterStudentList();
                    break;
                case 2:
                    System.out.print("Enter last name to search: ");
                    String lastName = scanner.nextLine();
                    management.findStudentsByLastName(lastName);
                    break;
                case 3:
                    System.out.print("Enter full name (First Last) to search and edit: ");
                    String fullName = scanner.nextLine();
                    management.findAndEditStudentByFullName(fullName);
                    break;
                case 4:
                    System.out.println("Goodbye...");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 4);
    }
}
