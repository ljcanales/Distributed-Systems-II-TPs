package tp1.ej4;

import tp1.ej3.PowerCalculator;
import utils.Constants;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Server {
    public static void main(String[] args) throws RemoteException {
        Registry registry = LocateRegistry.createRegistry(Constants.REGISTRY_PORT);
        Calculator calculator = new Calculator();
        registry.rebind("calculator", calculator);
    }
}
