import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Calculadora extends Remote{
	public double calc(double a,double b, char c) throws RemoteException;
}
