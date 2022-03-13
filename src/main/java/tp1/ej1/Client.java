package tp1.ej1;

import utils.Constants;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import javax.swing.JOptionPane;

public class Client {
    public static void main(String[] args) throws RemoteException, NotBoundException {
        Registry registry = LocateRegistry.getRegistry(Constants.REGISTRY_PORT);
        RemoteCalendar calendar = (RemoteCalendar) registry.lookup("calendar");
        String date = calendar.getDate();
        JOptionPane.showMessageDialog(null, "Date: " + date);
    }
}
