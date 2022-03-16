package tp1.ej5;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface RemoteTimeService extends Remote {
    String covertSeconds(long seconds) throws RemoteException;
}
