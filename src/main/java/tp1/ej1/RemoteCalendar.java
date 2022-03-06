package tp1.ej1;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface RemoteCalendar extends Remote {
    String getDate() throws RemoteException;
}
