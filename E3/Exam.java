import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class Exam extends UnicastRemoteObject implements IExam {
    private String name;
    private float grade;
    private double coefficient;
    
    public Exam() throws RemoteException{
        super();
    }
    
    public Exam(String name, float grade, double coefficient) throws RemoteException {
        super();
        this.name = name;
        this.grade = grade;
        this.coefficient = coefficient;
    }

    public String getDetails() throws RemoteException {
        return "Exam [name=" + name + ", grade=" + grade + ", coefficient=" + coefficient + "]";
    }
    
    public String getName() throws RemoteException {
        return this.name;
    }
    
    public void setName(String name) throws RemoteException {
        this.name = name;
    }
    
    public float getGrade() throws RemoteException {
        return this.grade;
    }
    
    public void setGrade(float grade) throws RemoteException {
        this.grade = grade;
    }

    public double getCoefficient() throws RemoteException {
        return this.coefficient;
    }

    public void setCoefficient(double coefficient) throws RemoteException {
        this.coefficient = coefficient;
    }
}