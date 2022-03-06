package tp1.ej1;

import utils.Constants;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Server {
    public static void main(String[] args) throws RemoteException {
        Registry registry = LocateRegistry.createRegistry(Constants.REGISTRY_PORT);
        Calendar calendar = new Calendar();
        registry.rebind("calendar", calendar);
    }
}
