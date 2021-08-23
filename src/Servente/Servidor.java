import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

public class Servidor {

	public static void main(String[] args){
		try {
			ServidorInterface calc = new ServidorImplementacao();
			String objName = "rmi://localhost/ServidorGoogle";

			System.out.println("Resgistrando o objeto no RMIRegistry...");
			LocateRegistry.createRegistry(3001);
			Naming.rebind(objName, calc);

			System.out.println("Aguardando ....");
			// System.setProperty("java.rmi.server.hostname","CalculatorService");
			// Calculadora c = new CalculadoraImple();
			// Naming.rebind("192.168.194.115:3001/CalculatorService", c);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
