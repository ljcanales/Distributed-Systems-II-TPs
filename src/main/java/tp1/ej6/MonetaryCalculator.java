package tp1.ej6;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class MonetaryCalculator extends UnicastRemoteObject implements RemoteMonetaryCalculator {

    protected MonetaryCalculator() throws RemoteException {
    }

    @Override
    public long cuantoVale(long importe, int plazo) throws RemoteException {
        return (long) (importe - importe * plazo * (INFLATION / 12));
    }
}
