package tp1.ej7;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;
import java.util.Map;

public class BarcodeReader extends UnicastRemoteObject implements RemoteBarcodeReader {

    private Map<String,String> products;
    protected BarcodeReader() throws RemoteException {
        products = new HashMap<>();
        products.put("11111", "Producto 1");
        products.put("22222", "Producto 2");
        products.put("33333", "Producto 3");
        products.put("44444", "Producto 4");
        products.put("55555", "Producto 5");
    }

    @Override
    public String search(int code) throws RemoteException {
        String codebar = Integer.toString(code);
        return products.containsKey(codebar) ? products.get(codebar) : "No existe";
    }
}
