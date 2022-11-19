import java.rmi.RemoteException;
import java.rmi.Remote;

public interface IProcessor extends Remote {
	public String fibonacci(int n) throws RemoteException;
}