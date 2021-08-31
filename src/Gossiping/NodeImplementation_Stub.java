// Stub class generated by rmic, do not edit.
// Contents subject to change without notice.

public final class NodeImplementation_Stub
    extends java.rmi.server.RemoteStub
    implements NodeInterface, java.rmi.Remote
{
    private static final long serialVersionUID = 2;
    
    private static java.lang.reflect.Method $method_getGossips_0;
    private static java.lang.reflect.Method $method_gossip_1;
    private static java.lang.reflect.Method $method_setGossip_2;
    
    static {
	try {
	    $method_getGossips_0 = NodeInterface.class.getMethod("getGossips", new java.lang.Class[] {});
	    $method_gossip_1 = NodeInterface.class.getMethod("gossip", new java.lang.Class[] {java.util.ArrayList.class});
	    $method_setGossip_2 = NodeInterface.class.getMethod("setGossip", new java.lang.Class[] {Gossip.class});
	} catch (java.lang.NoSuchMethodException e) {
	    throw new java.lang.NoSuchMethodError(
		"stub class initialization failed");
	}
    }
    
    // constructors
    public NodeImplementation_Stub(java.rmi.server.RemoteRef ref) {
	super(ref);
    }
    
    // methods from remote interfaces
    
    // implementation of getGossips()
    public java.util.ArrayList getGossips()
	throws java.rmi.RemoteException
    {
	try {
	    Object $result = ref.invoke(this, $method_getGossips_0, null, -4112585019902789124L);
	    return ((java.util.ArrayList) $result);
	} catch (java.lang.RuntimeException e) {
	    throw e;
	} catch (java.rmi.RemoteException e) {
	    throw e;
	} catch (java.lang.Exception e) {
	    throw new java.rmi.UnexpectedException("undeclared checked exception", e);
	}
    }
    
    // implementation of gossip(ArrayList)
    public void gossip(java.util.ArrayList $param_ArrayList_1)
	throws java.rmi.RemoteException
    {
	try {
	    ref.invoke(this, $method_gossip_1, new java.lang.Object[] {$param_ArrayList_1}, 4713626610984534L);
	} catch (java.lang.RuntimeException e) {
	    throw e;
	} catch (java.rmi.RemoteException e) {
	    throw e;
	} catch (java.lang.Exception e) {
	    throw new java.rmi.UnexpectedException("undeclared checked exception", e);
	}
    }
    
    // implementation of setGossip(Gossip)
    public void setGossip(Gossip $param_Gossip_1)
	throws java.rmi.RemoteException
    {
	try {
	    ref.invoke(this, $method_setGossip_2, new java.lang.Object[] {$param_Gossip_1}, -684977724984502566L);
	} catch (java.lang.RuntimeException e) {
	    throw e;
	} catch (java.rmi.RemoteException e) {
	    throw e;
	} catch (java.lang.Exception e) {
	    throw new java.rmi.UnexpectedException("undeclared checked exception", e);
	}
    }
}
