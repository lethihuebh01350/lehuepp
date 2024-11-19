public class Student {
    private String firstName;
    private String lastName;
    private String studentId;

    // Constructor to initialize student details
    public Student(String firstName, String lastName, String studentId) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.studentId = studentId;
    }

    // Getters and setters
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    // toString method to display student details
    @Override
    public String toString() {
        return "ID: " + studentId + ", Name: " + firstName + " " + lastName;
    }
}

