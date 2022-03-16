package tp1.ej5;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class TimeService extends UnicastRemoteObject implements RemoteTimeService {

    protected TimeService() throws RemoteException {
    }

    @Override
    public String covertSeconds(long seconds) throws RemoteException {
        return String.format("%02d hours %02d minutes %02d seconds", seconds / 3600, (seconds % 3600) / 60, seconds % 60);
    }
}
