import java.rmi.RemoteException;
import java.rmi.Remote;

public interface IHello extends Remote {
	public String say() throws RemoteException;
}