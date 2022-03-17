package tp1.ej8;

import tp1.ej6.MonetaryCalculator;
import utils.Constants;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Server {
    public static void main(String[] args) throws Exception {
        Registry registry = LocateRegistry.createRegistry(Constants.REGISTRY_PORT);
        ATMService atmService = new ATMService();
        registry.rebind("atm", atmService);
    }
}
