/*
@Author Yassir Douslimi
 */

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;

public class Classroom extends UnicastRemoteObject implements IClassroom {

    private List<IStudent> students = new ArrayList<>();

	public Classroom() throws RemoteException {
		super();
	}

    public void addStudent(IStudent student) throws RemoteException {
        students.add(student); 
    }

    public IStudent findStudent(int studentId) throws RemoteException {
        return students.stream().filter(student -> {
            try {
                return student.getStudentId() == studentId;
            } catch (RemoteException e) {
                e.printStackTrace();
            }
            return false;
        }).findFirst().orElse(null);
    }

    public float computeStudentAverage(int studentId) throws RemoteException{
        return findStudent(studentId).computeGlobalGrade();
    }

    public float computeClassroomAverage() throws RemoteException {
        float sum = 0;
        for (IStudent student: students) {
            sum += student.computeGlobalGrade();
        }
        return sum / students.size();
    }

    public List<IStudent> getStudents() throws RemoteException {
        return this.students;
    }

    public void setStudents(List<IStudent> students) throws RemoteException {
        this.students = students;
    }
}