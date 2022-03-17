package tp1.ej7;

import utils.Constants;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Server {
    public static void main(String[] args) throws Exception {
        Registry registry = LocateRegistry.createRegistry(Constants.REGISTRY_PORT);
        BarcodeReader barcodeReader = new BarcodeReader();
        registry.rebind("barcode-reader", barcodeReader);
    }
}
