import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface NodeInterface extends Remote{
	public static ArrayList<Gossip> gossips =  new ArrayList<Gossip>();
	public void setGossip(Gossip gossip) throws RemoteException;
	public ArrayList<Gossip> getGossips() throws RemoteException;
	public void gossip(ArrayList<Gossip> gossips) throws RemoteException;
}
