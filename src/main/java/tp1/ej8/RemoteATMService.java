package tp1.ej8;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface RemoteATMService extends Remote {
    void depositar(double monto) throws RemoteException;
    boolean retirar(double monto) throws RemoteException;
    double consultar() throws RemoteException;
}
