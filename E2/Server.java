import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Server {
	public static void main(String[] args) {
		try {
			Registry registry = LocateRegistry.createRegistry(1236);
			registry.bind("processor", new Processor());
			System.out.println("Server is ready.");
		} catch (Exception e) {
			System.err.println("Server failed.");
			e.printStackTrace();
		}
	}
}