package tp1.ej1;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.time.Instant;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;

public class Calendar extends UnicastRemoteObject implements RemoteCalendar {
    protected Calendar() throws RemoteException {
        super();
    }

    @Override
    public String getDate() throws RemoteException {
        return Instant.now().atOffset(ZoneOffset.ofHours(-3)).format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm"));
    }
}
