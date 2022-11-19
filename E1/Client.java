import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Client {
	public static void main(String[] args) {
		try {
			Registry registry = LocateRegistry.getRegistry("localhost", 1236);
			IHello hello = (IHello) registry.lookup("hello");
			System.out.println(hello.say());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}