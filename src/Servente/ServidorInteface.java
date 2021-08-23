import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ServidorInterface extends Remote{
	public boolean login(String nome, String senha) throws RemoteException;
}
