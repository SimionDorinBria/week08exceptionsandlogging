package main.java.com.siit.exceptionsandlogging.repository;

import main.java.com.siit.exceptionsandlogging.element.ApplicationException;
import main.java.com.siit.exceptionsandlogging.element.NameComparator;
import main.java.com.siit.exceptionsandlogging.element.Student;

import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;

import static com.sun.xml.internal.ws.spi.db.BindingContextFactory.LOGGER;

public class ListOfStudents {
    private List<Student> students = new ArrayList<>();

    public void addStudent(Student student) {

        try {
            validateStudent(student);
            students.add(student);
        } catch (ApplicationException e) {
            e.printStackTrace();
            LOGGER.log(Level.SEVERE, e.getMessage());
        }
    }

    public void validateStudent(Student student) throws ApplicationException {
        if (student.getFirstName() == null) {
            throw new ApplicationException("First name is null");
        }
        if (student.getLastName() == null) {
            throw new ApplicationException("Last name is null");
        }
        if (student.getDateOfBirth().isBefore(LocalDate.parse("1900-01-01"))) {
            throw new ApplicationException("Dead or Connor MacLeod");
        }
        if ((student.getDateOfBirth()).isAfter(LocalDate.now().minus(18, ChronoUnit.YEARS))) {
            throw new ApplicationException("Too young");
        }
        if (!(student.getGender().toString().equalsIgnoreCase("MALE".toString())) &&
                !(student.getGender().toString().equalsIgnoreCase("FEMALE".toString()))) {
            throw new ApplicationException("Is not a male or a female");
        }
        if (Period.between(student.getDateOfBirth(), LocalDate.now()).getYears() * 1 != Period.between(student.getDateOfBirth(), LocalDate.now()).getYears()) {
            throw new ApplicationException("Age is not a number");
        }
    }

    public void deleteByID(long id, ListOfStudents listOfStudents) throws ApplicationException {
        try {
            validateID(id);
            listOfStudents.deleteByID(id);
        } catch (ApplicationException e) {
            e.printStackTrace();
            LOGGER.log(Level.SEVERE, e.getMessage());
        }
    }

    public void deleteByID(long id) throws ApplicationException {
        Iterator<Student> it = students.iterator();

        while (it.hasNext()) {
            Student student = it.next();
            if (student.getID() == id) {
                it.remove();
            }
        }
    }

    public void validateID(long id) throws ApplicationException {
        Iterator<Student> it = students.iterator();

        while (it.hasNext()) {
            Student student = it.next();
            if (student.getID() == id) {
                break;
            } else {
                throw new ApplicationException("Student does not exist");
            }
        }
    }

    public long age(Student student) throws ApplicationException {
        try {
            validateAge(student);
        } catch (ApplicationException e) {
            e.printStackTrace();
            LOGGER.log(Level.SEVERE, e.getMessage());
        }
        return (Period.between(student.getDateOfBirth(), LocalDate.now())).getYears();
    }

    public void validateAge(Student student) throws ApplicationException {
        long age = Period.between(student.getDateOfBirth(), LocalDate.now()).getYears();
        if (age < 0) {
            throw new ApplicationException("Negative age");
        }
    }

    public List<Student> studentsWithXAges(Long age, ListOfStudents listOfStudents) throws ApplicationException {
        List<Student> result = new ArrayList<>();
        Iterator<Student> it = students.iterator();

        while (it.hasNext()) {
            Student student = it.next();
            if (age(student) == age) {
                result.add(student);
            }
        }
        return result;
    }

    public void sortListOfStudentsByLastName(ListOfStudents listOfStudents) throws ApplicationException {
        try {
            validateLastName(listOfStudents);
            Collections.sort(students, new NameComparator());
        } catch (ApplicationException e) {
            e.printStackTrace();
            LOGGER.log(Level.SEVERE, e.getMessage());
        }
    }

    public void validateLastName(ListOfStudents listOfStudents) throws ApplicationException {
        Iterator<Student> it = students.iterator();
        while (it.hasNext()) {
            Student student = it.next();
            if (student.getLastName() == null) {
                throw new ApplicationException("Input is empty");
            }
        }
    }

    @Override
    public String toString() {
        return "ListOfStudents{" +
                "students=" + students +
                '}';
    }
}