package tp1.ej3;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class PowerCalculator extends UnicastRemoteObject implements RemotePowerCalculator {

    protected PowerCalculator() throws RemoteException {}

    @Override
    public long square(int n) throws RemoteException {
        return (long) Math.sqrt(n);
    }

    @Override
    public long pow(int n1, int n2) throws RemoteException {
        return (long) Math.pow(n1, n2);
    }
}
