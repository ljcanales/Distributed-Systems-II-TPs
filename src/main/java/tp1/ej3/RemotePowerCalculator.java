package tp1.ej3;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface RemotePowerCalculator extends Remote {
    long square(int n) throws RemoteException;
    long pow(int n1, int n2) throws RemoteException;
}
