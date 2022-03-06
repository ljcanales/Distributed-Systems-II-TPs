package tp1.ej4;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class Calculator extends UnicastRemoteObject implements RemoteCalculator {

    protected Calculator() throws RemoteException {}

    @Override
    public long sum(long a, long b) throws RemoteException {
        return a + b;
    }

    @Override
    public long subtract(long a, long b) throws RemoteException {
        return a - b;
    }

    @Override
    public long multiply(long a, long b) throws RemoteException {
        return a * b;
    }

    @Override
    public long divide(long a, long b) throws RemoteException {
        return a / b;
    }
}
