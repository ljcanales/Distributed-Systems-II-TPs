package tp1.ej7;

import utils.Constants;

import javax.swing.*;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Client {
    public static void main(String[] args) throws Exception {
        Registry registry = LocateRegistry.getRegistry(Constants.REGISTRY_PORT);
        RemoteBarcodeReader barcodeReader = (RemoteBarcodeReader) registry.lookup("barcode-reader");

        JTextField codeField = new JTextField();
        Object[] message = new Object[]{
                "C\u00f3digo de barras: ", codeField
        };
        if(JOptionPane.showConfirmDialog(null, message, "Barcode Reader", JOptionPane.OK_CANCEL_OPTION) != JOptionPane.OK_OPTION)
            return;
        int code = Integer.parseInt(codeField.getText());
        String result = barcodeReader.search(code);
        JOptionPane.showMessageDialog(null, String.format("Producto: %s", result));
    }
}
