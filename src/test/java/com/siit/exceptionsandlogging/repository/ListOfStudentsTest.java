package test.java.com.siit.exceptionsandlogging.repository;

import main.java.com.siit.exceptionsandlogging.element.ApplicationException;
import main.java.com.siit.exceptionsandlogging.element.Student;
import main.java.com.siit.exceptionsandlogging.repository.ListOfStudents;
import org.junit.*;

import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ListOfStudentsTest {
    private static Logger LOGGER = Logger.getLogger(Student.class.getName());

    private ListOfStudents listOfStudents = new ListOfStudents();
    private Student ionescu = new Student("ion", "ionescu",
            LocalDate.of(1901, 01, 01), "MALE", 7);
    private Student vasilescu = new Student("vasile", "vasilescu",
            LocalDate.of(1911, 02, 02), "MALE", 6);

    @BeforeClass
    public static void beforeClass() {
        LOGGER.log(Level.INFO, "start logging");
        System.out.println("before class");
    }

    @AfterClass
    public static void afterClass() {
        System.out.println("after class");
        LOGGER.log(Level.INFO, "end logging");
    }

    @Before
    public void setup() {
        System.out.println("in setup");
    }

    @After
    public void after() {
        System.out.println("after");
    }

    @Test
    public void testFirstNameNull() throws ApplicationException {
        ionescu.setFirstName(null);
        listOfStudents.addStudent(ionescu);
    }

    @Test
    public void testLastNameNull() throws ApplicationException {
        ionescu.setLastName(null);
        listOfStudents.addStudent(ionescu);
    }

    @Test
    public void testTooOldConsideringDateOfBirth() throws ApplicationException {
        ionescu.setDateOfBirth(LocalDate.of(1800, 05, 06));
        listOfStudents.addStudent(ionescu);
    }

    @Test
    public void testTooYoungConsideringDateOfBirth() throws ApplicationException {
        ionescu.setDateOfBirth(LocalDate.of(2018, 05, 06));
        listOfStudents.addStudent(ionescu);
    }

    @Test
    public void testGender() throws ApplicationException {
        ionescu.setGender("A");
        listOfStudents.addStudent(ionescu);
    }

    @Test
    public void testRemoveAbsentID() throws ApplicationException {
        listOfStudents.addStudent(ionescu);
        listOfStudents.deleteByID(1, listOfStudents);

    }

    @Test
    public void testStudentsWithNegativeAges() throws ApplicationException {
        listOfStudents.addStudent(ionescu);
        ionescu.setDateOfBirth(LocalDate.of(2050, 05, 05));
        listOfStudents.studentsWithXAges(-31L, listOfStudents);
    }

    @Test
    public void testListListOfStudentsWithAnEmptyInput() throws ApplicationException {
        listOfStudents.addStudent(vasilescu);
        listOfStudents.addStudent(ionescu);
        ionescu.setLastName(null);
        listOfStudents.sortListOfStudentsByLastName(listOfStudents);
    }
}