package tp1.ej2;

import utils.Constants;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Server {
    public static void main(String[] args) throws Exception {
        Registry registry = LocateRegistry.createRegistry(Constants.REGISTRY_PORT);
        CurrencyConverter converter = new CurrencyConverter();
        registry.rebind("currency-converter", converter);
    }
}
