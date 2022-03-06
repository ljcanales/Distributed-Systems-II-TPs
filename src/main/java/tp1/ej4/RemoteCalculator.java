package tp1.ej4;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface RemoteCalculator extends Remote {
    long sum(long a, long b) throws RemoteException;
    long subtract(long a, long b) throws RemoteException;
    long multiply(long a, long b) throws RemoteException;
    long divide(long a, long b) throws RemoteException;
}
