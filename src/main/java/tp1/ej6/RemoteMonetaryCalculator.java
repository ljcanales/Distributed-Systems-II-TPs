package tp1.ej6;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface RemoteMonetaryCalculator extends Remote {
    double INFLATION = 0.548;
    long cuantoVale(long importe, int plazo) throws RemoteException;
}
