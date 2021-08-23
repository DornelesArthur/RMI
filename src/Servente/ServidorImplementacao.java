import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class ServidorImplementacao extends UnicastRemoteObject implements Calculadora{

	private static final long serialVersionUID = 1L;

	protected ServidorImplementacao() throws RemoteException{
		// super();
	}
	public boolean login(String nome, String senha) throws RemoteException{
		String nomeTeste = new String("google");
        String senhaTeste = new String("1234");
        if (nomeTeste.equals(nome) && senhaTeste.equals(senha)) {
            return true;
        }else {
            return false;
        }
	}
}
