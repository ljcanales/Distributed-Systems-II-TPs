package tp1.ej5;

import utils.Constants;

import javax.swing.*;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Client {
    public static void main(String[] args) throws Exception {
        Registry registry = LocateRegistry.getRegistry(Constants.REGISTRY_PORT);
        RemoteTimeService timeService = (RemoteTimeService) registry.lookup("time-service");

        JTextField secondsField = new JTextField();
        Object[] message = new Object[]{
                "Total seconds: ", secondsField,
        };
        if(JOptionPane.showConfirmDialog(null, message, "Seconds Converter", JOptionPane.OK_CANCEL_OPTION) != JOptionPane.OK_OPTION)
            return;
        long seconds = Long.parseLong(secondsField.getText());
        String result = timeService.covertSeconds(seconds);
        JOptionPane.showMessageDialog(null, result);

    }
}
