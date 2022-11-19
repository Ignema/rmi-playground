import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.text.MessageFormat;

public class Processor extends UnicastRemoteObject implements IProcessor {
	public Processor() throws RemoteException {
		super();
	}

    public String fibonacci(int n) throws RemoteException {
        int a = 0, b = 1, c = 0;
        for (int i = 0; i < n; i++) {
            c = a + b;
            a = b;
            b = c;
        }
        return MessageFormat.format("Fibonacci of {0} is {1}", n, c);
    }
}