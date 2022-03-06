package tp1.ej3;

import utils.Constants;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Client {
    public static void main(String[] args) throws RemoteException, NotBoundException {
        Registry registry = LocateRegistry.getRegistry(Constants.REGISTRY_PORT);
        RemotePowerCalculator calculator = (RemotePowerCalculator) registry.lookup("power-calculator");
        System.out.println("The square root of 25 is " + calculator.square(25));
        System.out.println("5 raised to the power of 3 is " + calculator.pow(5, 3));
    }
}
