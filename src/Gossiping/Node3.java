import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ArrayList;
import java.io.Serializable;

public class Node3 implements Serializable {
	public static long waitTimeMinimum = 2000;
	public static long waitTimeMaximum = 5000;
	public static long waitToStart = 30000;

	public static void main(String[] args){
		try {
			// Info outros nodos
			ArrayList<String> nameServers = new ArrayList<String>();
			nameServers.add("rmi://localhost:3001/GossipServer1");
			nameServers.add("rmi://localhost:3002/GossipServer2");
			nameServers.add("rmi://localhost:3004/Node4");
			nameServers.add("rmi://localhost:3005/Node5");
			
			// Start Servidor
			NodeInterface nodeImplementation = new NodeImplementation(3);
			String objName = "rmi://localhost:3003/Node3";

			System.out.println("Resgistrando o objeto no RMIRegistry...");
			
			System.out.println("Tentando ....");
			try{
				System.out.println("Tentando ....");
				LocateRegistry.createRegistry(3003);
				Naming.rebind(objName,nodeImplementation);
			} catch (java.rmi.ConnectException e){
				System.out.println(e);
			}
			
			System.out.println("Aguardando meio minuto ....");
			
			long espera = System.currentTimeMillis() + waitToStart;
			while(System.currentTimeMillis() != espera){
            }

			while(true){
                long startTime = System.currentTimeMillis();
                long waitTime = (long) Math.random()*((waitTimeMaximum-waitTimeMinimum)+1)+waitTimeMinimum;

                while(System.currentTimeMillis() != startTime+waitTime){
                }
				// mandar gossip
				int nodeNameIndex = (int)(Math.random()*((3)+1));
				System.out.println("Mandando mesagem para = " + (nameServers.get(nodeNameIndex)));

				try{
					NodeInterface node = (NodeInterface) Naming.lookup(nameServers.get(nodeNameIndex));
					Gossip aux = new Gossip(3,1,new Timestamp(System.currentTimeMillis()));
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
