package rmiexample;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 *
 * @author Namyoon
 */
public class RMIServer extends UnicastRemoteObject implements RMIInterface {

    private static final long serialVersionUID = 1L;

    protected RMIServer() throws RemoteException {
        super();
    }

    @Override
    public String helloTo(String name) throws RemoteException {
        System.err.println(name + " is trying to contact!");
        return "Server says hello to " + name;
    }

    public static void main(String[] args) {
        try {
            Naming.rebind("//localhost/MyServer", new RMIServer());
            System.err.println("Server ready");
        } catch (Exception ex) {
            System.err.println("Server exception: " + ex.toString());
            ex.printStackTrace();
        }
    }
}
