import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Client {
	public static void main(String[] args) {
		try {
			Registry registry = LocateRegistry.getRegistry("localhost", 1236);
			IProcessor processor = (IProcessor) registry.lookup("processor");
			System.out.println(processor.fibonacci(10));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}