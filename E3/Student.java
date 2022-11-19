import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;

public class Student extends UnicastRemoteObject implements IStudent {

    private String firstName;
    private String lastName;
    private int studentId;
    private List<IExam> exams = new ArrayList<>();

	public Student() throws RemoteException {
		super();
	}

    public Student(String firstName, String lastName, int studentId) throws RemoteException {
        super();
        this.firstName = firstName;
        this.lastName = lastName;
        this.studentId = studentId;
    }

    public void addExam(IExam exam) throws RemoteException {
        exams.add(exam);
    }

    public void displayExams() throws RemoteException {
        for (IExam exam: exams) {
            System.out.println(exam.getDetails());
        }
    }

    public float computeGlobalGrade() throws RemoteException {
        float sum = 0;
        for (IExam exam: exams) {
            sum += exam.getGrade()*exam.getCoefficient();
        }
        return sum / exams.size();
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getStudentId() {
        return this.studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public List<IExam> getExams() {
        return this.exams;
    }

    public void setExams(List<IExam> exams) {
        this.exams = exams;
    }
}