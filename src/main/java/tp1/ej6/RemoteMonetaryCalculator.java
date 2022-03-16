package tp1.ej6;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface RemoteMonetaryCalculator extends Remote {
    long cuantoVale(long importe, int plazo) throws RemoteException;
}
