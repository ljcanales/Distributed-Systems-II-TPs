package tp1.ej8;

import utils.Constants;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Client {
    public static void main(String[] args) throws Exception {
        Registry registry = LocateRegistry.getRegistry(Constants.REGISTRY_PORT);
        RemoteATMService atmService = (RemoteATMService) registry.lookup("atm");

        JButton depositarButton = new JButton("Depositar");
        JButton retirarButton = new JButton("Retirar");
        JButton consultarButton = new JButton("Consultar Saldo");

        depositarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JTextField amount = new JTextField();
                Object[] message = new Object[]{
                        "Monto: ", amount,
                };
                if(JOptionPane.showConfirmDialog(null, message, "Depositar", JOptionPane.OK_CANCEL_OPTION) != JOptionPane.OK_OPTION)
                    return;
                try {
                    atmService.depositar(Double.parseDouble(amount.getText()));
                } catch (RemoteException ex) {
                    JOptionPane.showMessageDialog(null, "Error inesperado al depositar");
                }
            }
        });

        retirarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JTextField amount = new JTextField();
                Object[] message = new Object[]{
                        "Monto ($): ", amount,
                };
                if(JOptionPane.showConfirmDialog(null, message, "Retirar", JOptionPane.OK_CANCEL_OPTION) != JOptionPane.OK_OPTION)
                    return;
                try {
                    if(atmService.retirar(Double.parseDouble(amount.getText()))) {
                        JOptionPane.showMessageDialog(null, "Retiro exitoso!");
                    } else {
                        JOptionPane.showMessageDialog(null, "No tiene suficiente saldo para realizar el retiro");
                    }
                } catch (RemoteException ex) {
                    JOptionPane.showMessageDialog(null, "Error inesperado al retirar");
                }
            }
        });

        consultarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    double balance = atmService.consultar();
                    JOptionPane.showMessageDialog(null, String.format("Saldo ($): %d", (long) balance));
                } catch (RemoteException ex) {
                    JOptionPane.showMessageDialog(null, "Error inesperado al retirar");
                }
            }
        });

        Object[] message = new Object[]{
                depositarButton,
                retirarButton,
                consultarButton
        };
        JOptionPane.showConfirmDialog(null, message, "ATM", JOptionPane.OK_CANCEL_OPTION);


    }
}
