import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ServenteInterface extends Remote{
	public boolean login(int tipoLogin, String nome, String senha) throws RemoteException;
}
