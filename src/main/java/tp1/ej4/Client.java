package tp1.ej4;

import utils.Constants;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Client {
    public static void main(String[] args) throws RemoteException, NotBoundException {
        Registry registry = LocateRegistry.getRegistry(Constants.REGISTRY_PORT);
        RemoteCalculator calculator = (RemoteCalculator) registry.lookup("calculator");
        System.out.println("20 + 68 is " + calculator.sum(20, 68));
        System.out.println("80 - 68 is " + calculator.subtract(80, 68));
        System.out.println("20 * 68 is " + calculator.multiply(20, 68));
        System.out.println("5000 / 50 is " + calculator.divide(5000, 50));
    }
}
