import java.rmi.RemoteException;
import java.rmi.Remote;
import java.util.List;

public interface IStudent extends Remote {
	public void addExam(IExam exam) throws RemoteException;

	public void displayExams() throws RemoteException;

    public float computeGlobalGrade() throws RemoteException;
	
	public String getFirstName() throws RemoteException;

	public void setFirstName(String firstName) throws RemoteException;

	public String getLastName() throws RemoteException;

	public void setLastName(String lastName) throws RemoteException;

	public int getStudentId() throws RemoteException;

	public void setStudentId(int studentId) throws RemoteException;

	public List<IExam> getExams() throws RemoteException;

	public void setExams(List<IExam> exams) throws RemoteException;
}