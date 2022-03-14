package tp1.ej2;

import utils.Constants;

import javax.swing.*;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Client {
    public static void main(String[] args) throws Exception {
        Registry registry = LocateRegistry.getRegistry(Constants.REGISTRY_PORT);
        RemoteCurrencyConverter converter = (RemoteCurrencyConverter) registry.lookup("currency-converter");

        Object[] options = {RemoteCurrencyConverter.ARS_TO_USD, RemoteCurrencyConverter.USD_TO_ARS};
        String selectedOption = (String) JOptionPane.showInputDialog(null,"Seleccionar:", "Currency converter",JOptionPane.QUESTION_MESSAGE,null, options, options[0]);

        if(selectedOption == null)
            return;

        JTextField amountField = new JTextField();
        Object[] message = {selectedOption.substring(0, 3)+":", amountField};
        int option = JOptionPane.showConfirmDialog(null, message, selectedOption, JOptionPane.OK_CANCEL_OPTION);

        if(option != JOptionPane.OK_OPTION)
            return;

        String result;
        long amount = Long.parseLong(amountField.getText());
        switch (selectedOption) {
            case RemoteCurrencyConverter.ARS_TO_USD:
                long usd = converter.arsToUsd(amount);
                result = String.format("%d ARS is %d USD", amount, usd);
                break;
            case RemoteCurrencyConverter.USD_TO_ARS:
                long ars = converter.usdToArs(amount);
                result = String.format("%d USD is %d ARS", amount, ars);
                break;
            default:
                return;
        }
        JOptionPane.showMessageDialog(null, result);
    }
}
