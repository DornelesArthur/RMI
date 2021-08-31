import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ArrayList;

public class JavaTests {

    // public static Gossip gossips1[] = new Gossip[5];
    // public static Gossip gossips2[] = new Gossip[5];
    public static Gossip gossip = new Gossip(0,0,new Timestamp(System.currentTimeMillis()));
    public static ArrayList<Gossip> gossips =  new ArrayList<Gossip>();


    public static void main(String[] args){
        Timestamp teste3 = new Timestamp(System.currentTimeMillis());
        System.out.println("Before");
        System.out.println(teste3);
        Timestamp teste4 = new Timestamp(System.currentTimeMillis());
        System.out.println(teste4);
        System.out.println(teste3.before(teste4));
        Gossip gossip1 = new Gossip(1,1,new Timestamp(0));
        Gossip gossip2 = new Gossip(2,1,new Timestamp(System.currentTimeMillis()));
        Gossip gossip3 = new Gossip(3,1,teste3);
        Gossip gossip4 = new Gossip(4,1,teste4);
        gossips.add(gossip1);
        gossips.add(gossip2);
        gossips.add(gossip3);
        gossips.add(gossip4);

        int node = (int) Math.random()*(5-0+1)+0;
        System.out.println("Node = " + node);

        node = (int)(Math.random()*((4-1)+1))+1;
        System.out.println("Node = " + node);

        // System.out.println(gossips.get(0).lastGossip == gossips.get(1).lastGossip);

        for(int i = 0; i < gossips.size(); i++){
            System.out.println("==============");
            System.out.println(gossips.get(i).name);
            System.out.println(gossips.get(i).status);
            System.out.println(gossips.get(i).lastGossip);
            Gossip teste = new Gossip(gossips.get(0).name,gossips.get(0).status,gossips.get(0).lastGossip);
            gossips.set(i,teste);
            // System.out.println(gossips1[i].name);
            // System.out.println(gossips1[i].status);
            // System.out.println(gossips1[i].lastGossip);
            // System.out.println(gossips2[i].name);
            // System.out.println(gossips2[i].status);
            // System.out.println(gossips2[i].lastGossip);
            
            // if (gossips1[i].getName() != this.gossips[i].getName() && gossip.getLastGossip()){

            // }
        }

        System.out.println("----------------------------------------------");
        for(int i = 0; i < gossips.size(); i++){
            System.out.println("==============");
            System.out.println(gossips.get(i).name);
            System.out.println(gossips.get(i).status);
            System.out.println(gossips.get(i).lastGossip);
            // System.out.println(gossips1[i].name);
            // System.out.println(gossips1[i].status);
            // System.out.println(gossips1[i].lastGossip);
            // System.out.println(gossips2[i].name);
            // System.out.println(gossips2[i].status);
            // System.out.println(gossips2[i].lastGossip);
            
            // if (gossips1[i].getName() != this.gossips[i].getName() && gossip.getLastGossip()){

            // }
        }





        ArrayList<String> nameServers = new ArrayList<String>();
		nameServers.add("rmi://localhost/GossipServer2");
		nameServers.add("rmi://localhost/Node1");
		nameServers.add("rmi://localhost/Node2");
		nameServers.add("rmi://localhost/Node3");

        int nodeNameIndex = (int)(Math.random()*((3)+1));
		//NodeInterface node = (NodeInterface) Naming.lookup(nameServers.get(nodeNameIndex));
        System.out.println(nameServers.get(nodeNameIndex));
        nodeNameIndex = (int)(Math.random()*((3)+1));
		//NodeInterface node = (NodeInterface) Naming.lookup(nameServers.get(nodeNameIndex));
        System.out.println(nameServers.get(nodeNameIndex));
    }

    // public void setGossips1(ArrayList<Gossip> gossips){
    //     this.gossips1 = gossips;
    // }

    // public Gossip[] getGossips1(){
    //     return gossips1;
    // }
    // public void setGossips2(ArrayList<Gossip> gossips){
    //     this.gossips2 = gossips2;
    // }

    // public Gossip[] getGossips2(){
    //     return gossips2;
    // }
}