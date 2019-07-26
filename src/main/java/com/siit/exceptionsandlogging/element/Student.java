package main.java.com.siit.exceptionsandlogging.element;

import java.time.LocalDate;
import java.util.Objects;

/**
 * Exceptions and logging
 * <p>
 * Create a student repository which supports:
 * <p>
 * <p>
 * - add student
 * <p>
 * * exceptions when validating conditions mentioned bellow
 * <p>
 * - delete student (by ID)
 * <p>
 * * exceptions: ID is empty, student does not exist
 * <p>
 * - retrieve all students with Age X (for each student the age must be calculated, not stored in a field).
 * <p>
 * * exceptions: age is not a number, age is negative
 * <p>
 * - (optional) list students order by Last Name or Birth Date
 * <p>
 * * exceptions: any input is empty
 * <p>
 * These methods must validate inputs and throw exceptions if necessary.
 * <p>
 * <p>
 * <p>
 * <p>
 * For each Student the following information needs to be collected:
 * <p>
 * - First Name
 * <p>
 * - Last Name
 * <p>
 * - Date of Birth
 * <p>
 * - Gender
 * <p>
 * - ID (CNP)
 * <p>
 * <p>
 * The following validations are expected:
 * <p>
 * - date of birth between 1900 and current year - 18
 * <p>
 * - first name and last name should not be empty
 * <p>
 * - gender should be male or female (or M and F), upper/lower case should both be accepted
 * <p>
 * <p>
 * <p>
 * For all the validations, the corresponding exception(s) should be thrown when a Student is created with data which
 * breaks the validation constraint.
 * <p>
 * <p>
 * The testing application can demonstrate the implementation of the above requirements without requiring a special
 * menu for creating the students or for choosing the operation. Just create several test methods which perform
 * separately a given scenario.
 * <p>
 * <p>
 * Additionally, you should use Logger for tracing and error handling.
 */
public class Student {

    private String firstName;
    private String lastName;
    private LocalDate dateOfBirth;
    private String gender;
    private long ID;

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

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public long getID() {
        return ID;
    }

    public void setID(long ID) {
        this.ID = ID;
    }

    public Student(String firstName, String lastName, LocalDate dateOfBirth, String gender, long ID) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.ID = ID;
    }

    @Override
    public String toString() {
        return "Student{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", gender='" + gender + '\'' +
                ", ID=" + ID +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Student)) return false;
        Student student = (Student) o;
        return Objects.equals(lastName, student.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lastName);
    }
}