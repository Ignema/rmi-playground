import java.rmi.RemoteException;
import java.rmi.Remote;
import java.util.List;

public interface IClassroom extends Remote {
	public void addStudent(IStudent student) throws RemoteException;

	public IStudent findStudent(int studentId) throws RemoteException;

	public float computeStudentAverage(int studentId) throws RemoteException;

    public float computeClassroomAverage() throws RemoteException;

	public List<IStudent> getStudents() throws RemoteException;

	public void setStudents(List<IStudent> students) throws RemoteException;
}