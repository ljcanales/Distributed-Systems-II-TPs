package tp1.ej2;

import utils.Constants;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Client {
    public static void main(String[] args) throws Exception {
        Registry registry = LocateRegistry.getRegistry(Constants.REGISTRY_PORT);
        RemoteCurrencyConverter converter = (RemoteCurrencyConverter) registry.lookup("currency-converter");
        System.out.println("1000 ARS is " + converter.arsToUsd(1000) + " USD");
        System.out.println("1 USD is " + converter.usdToArs(1) + " ARS");

    }
}
