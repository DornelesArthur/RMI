import java.rmi.RemoteException;
import java.rmi.Naming;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.sql.Timestamp;
import java.io.Serializable;

public class NodeImplementation extends UnicastRemoteObject implements NodeInterface, Serializable{

    public static int name;
    public static ArrayList<Gossip> gossips =  new ArrayList<Gossip>();
	private static final long serialVersionUID = 1L;

	public NodeImplementation(int name) throws RemoteException{
        this.name = name;
        this.gossips.add(new Gossip(1,-1,new Timestamp(0)));
        this.gossips.add(new Gossip(2,-1,new Timestamp(0)));
        this.gossips.add(new Gossip(3,-1,new Timestamp(0)));
        this.gossips.add(new Gossip(4,-1,new Timestamp(0)));
        this.gossips.add(new Gossip(5,-1,new Timestamp(0)));
	}

    public void setGossip(Gossip gossip){
        this.gossips.set(this.name-1,gossip);
    }

    public ArrayList<Gossip> getGossips(){
        return this.gossips;
    }

    public void gossip(ArrayList<Gossip> gossips){
        System.out.println("Recebendo");
        for(int i = 0; i < this.gossips.size(); i++){
            if (gossips.get(i).name != name && this.gossips.get(i).lastGossip.before(gossips.get(i).lastGossip)){
                Gossip aux = new Gossip(gossips.get(i).name,gossips.get(i).status,gossips.get(i).lastGossip);
                this.gossips.set(i,aux);
            }
        }
    }
}
