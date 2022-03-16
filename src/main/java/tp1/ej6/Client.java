package tp1.ej6;

import tp1.ej5.RemoteTimeService;
import utils.Constants;

import javax.swing.*;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Client {
    public static void main(String[] args) throws Exception {
        Registry registry = LocateRegistry.getRegistry(Constants.REGISTRY_PORT);
        RemoteMonetaryCalculator monetaryCalculator = (RemoteMonetaryCalculator) registry.lookup("monetary-calculator");

        JTextField importeField = new JTextField();
        JTextField plazoField = new JTextField();
        Object[] message = new Object[]{
                "Importe ($): ", importeField,
                "Plazo (en meses): ", plazoField,
        };
        if(JOptionPane.showConfirmDialog(null, message, "Monetary Converter", JOptionPane.OK_CANCEL_OPTION) != JOptionPane.OK_OPTION)
            return;
        long importe = Long.parseLong(importeField.getText());
        int plazo = Integer.parseInt(plazoField.getText());
        long result = monetaryCalculator.cuantoVale(importe, plazo);
        JOptionPane.showMessageDialog(null, String.format("Valor: $%d",result));
    }
}
