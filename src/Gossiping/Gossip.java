import java.sql.Timestamp;
import java.io.Serializable;

public class Gossip implements Serializable{
    public int name;
    public int status;
    public Timestamp lastGossip;
    public String path;

    public Gossip (int name, int status, Timestamp lastGossip){
        this.name = name;
        this.status = status;
        this.lastGossip = lastGossip;
    }
}
