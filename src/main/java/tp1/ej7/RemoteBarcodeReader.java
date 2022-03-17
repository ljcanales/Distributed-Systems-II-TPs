package tp1.ej7;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface RemoteBarcodeReader extends Remote {
    String search(int code) throws RemoteException;
}
