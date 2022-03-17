package tp1.ej8;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class ATMService extends UnicastRemoteObject implements RemoteATMService {

    private double balance = 0;

    protected ATMService() throws RemoteException {
    }

    @Override
    public void depositar(double monto) throws RemoteException {
        if(monto > 0) {
            balance += monto;
        }
    }

    @Override
    public boolean retirar(double monto) throws RemoteException {
        if(balance >= monto) {
            balance -= monto;
            return true;
        }
        return false;
    }

    @Override
    public double consultar() throws RemoteException {
        return balance;
    }
}
