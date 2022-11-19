import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.text.MessageFormat;

public class Hello extends UnicastRemoteObject implements IHello {
	private String message;

	public Hello() throws RemoteException {
		super();
	}

	public Hello(String message) throws RemoteException {
		super();
		this.message = message;
	}

	public String say() throws RemoteException {
		return MessageFormat.format("Hello {0}", message);
	}

	public String getMessage() {
		return this.message;
	}

	public void setMessage(String message) {
		this.message = message;
	}	
}