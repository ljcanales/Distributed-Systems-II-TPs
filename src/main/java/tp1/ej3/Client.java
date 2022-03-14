package tp1.ej3;

import utils.Constants;

import javax.swing.*;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Client {
    public static void main(String[] args) throws RemoteException, NotBoundException {
        Registry registry = LocateRegistry.getRegistry(Constants.REGISTRY_PORT);
        RemotePowerCalculator calculator = (RemotePowerCalculator) registry.lookup("power-calculator");

        Object[] options = {RemotePowerCalculator.POWER, RemotePowerCalculator.SQRT};
        String selectedOption = (String) JOptionPane.showInputDialog(null,"Seleccionar:", "Power Calculator",JOptionPane.QUESTION_MESSAGE,null, options, options[0]);

        if(selectedOption == null)
            return;

        Object[] message;
        String result;
        switch (selectedOption) {
            case RemotePowerCalculator.POWER:
                JTextField baseField = new JTextField();
                JTextField exponentField = new JTextField();
                message = new Object[]{
                        "Base: ", baseField,
                        "Exponent: ", exponentField
                };
                if(JOptionPane.showConfirmDialog(null, message, selectedOption, JOptionPane.OK_CANCEL_OPTION) != JOptionPane.OK_OPTION)
                    return;
                int base = Integer.parseInt(baseField.getText());
                int exponent = Integer.parseInt(exponentField.getText());
                long power = calculator.pow(base, exponent);
                result = String.format("%d raised to the power of %d is %d", base, exponent, power);
                break;
            case RemotePowerCalculator.SQRT:
                JTextField numberField = new JTextField();
                message = new Object[]{
                        "Number: ", numberField,
                };
                if(JOptionPane.showConfirmDialog(null, message, selectedOption, JOptionPane.OK_CANCEL_OPTION) != JOptionPane.OK_OPTION)
                    return;
                int number = Integer.parseInt(numberField.getText());
                long sqrt = calculator.square(number);
                result = String.format("The square root of %d is %d", number, sqrt);
                break;
            default:
                return;
        }
        JOptionPane.showMessageDialog(null, result);
    }
}
