import java.rmi.RemoteException;
import java.rmi.Remote;

public interface IExam extends Remote {
    public String getDetails() throws RemoteException;

    public String getName() throws RemoteException;

    public void setName(String name) throws RemoteException;

    public float getGrade() throws RemoteException;

    public void setGrade(float grade) throws RemoteException;

    public double getCoefficient() throws RemoteException;

    public void setCoefficient(double coefficient) throws RemoteException;
}