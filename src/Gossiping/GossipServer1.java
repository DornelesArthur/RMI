import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ArrayList;
import java.io.Serializable;

public class GossipServer1 implements Serializable {
	public static long waitTimeMinimum = 2000;
	public static long waitTimeMaximum = 5000;
	public static long waitTimeCheck = 60000;
	public static long waitToStart = 30000;

	public static void main(String[] args){
		try {
			// Info outros nodos
			ArrayList<String> nameServers = new ArrayList<String>();
			nameServers.add("rmi://localhost:3002/GossipServer2");
			nameServers.add("rmi://localhost:3003/Node3");
			nameServers.add("rmi://localhost:3004/Node4");
			nameServers.add("rmi://localhost:3005/Node5");
			
			// Info Servidor
			NodeInterface nodeImplementation = new NodeImplementation(1);
			String objName = "rmi://localhost:3001/GossipServer1";

			System.out.println("Resgistrando o objeto no RMIRegistry...");
			LocateRegistry.createRegistry(3001);
			Naming.rebind(objName,nodeImplementation);

			System.out.println("Aguardando meio minuto ....");
			
			long espera = System.currentTimeMillis() + waitToStart;
			while(System.currentTimeMillis() != espera){
            }

			long checkTimer = System.currentTimeMillis() + waitTimeCheck;
			while(true){
				if(checkTimer <= System.currentTimeMillis()){
					ArrayList<Gossip> check = nodeImplementation.getGossips();
					Timestamp past = new Timestamp(System.currentTimeMillis()-waitTimeCheck);
					for(int i = 0; i < check.size(); i++){
						if(check.get(i).lastGossip.before(past) && check.get(i).name != 1){
							System.out.println("==========ERRO=================");
							System.out.println("Erro no Nodo: " + (i+1));
						}
					}
					checkTimer = System.currentTimeMillis() + waitTimeCheck;
				}
                long startTime = System.currentTimeMillis();
                long waitTime = (long) Math.random()*((waitTimeMaximum-waitTimeMinimum)+1)+waitTimeMinimum;

                while(System.currentTimeMillis() != startTime+waitTime){
                }
				// mandar gossip
				int nodeNameIndex = (int)(Math.random()*((3)+1));
				System.out.println("Mandando mesagem para = " + (nameServers.get(nodeNameIndex)));

				try{
					NodeInterface node = (NodeInterface) Naming.lookup(nameServers.get(nodeNameIndex));
					Gossip aux = new Gossip(1,1,new Timestamp(System.currentTimeMillis()));
					nodeImplementation.setGossip(aux);
					node.gossip(nodeImplementation.getGossips());
				} catch (java.rmi.ConnectException e){
					System.out.println(e);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
