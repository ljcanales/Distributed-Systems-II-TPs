package tp1.ej4;

import utils.Constants;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Client {
    public static void main(String[] args) throws RemoteException, NotBoundException {
        Registry registry = LocateRegistry.getRegistry(Constants.REGISTRY_PORT);
        RemoteCalculator calculator = (RemoteCalculator) registry.lookup("calculator");

        if(args.length != 3) {
            System.out.println("");
            return;
        }

        long op1 = Long.parseLong(args[0]);
        long op2 = Long.parseLong(args[1]);
        long result;
        String oper = args[2];

        switch (oper) {
            case "+":
                result = calculator.sum(op1, op2); break;
            case "-":
                result = calculator.subtract(op1, op2); break;
            case "*":
                result = calculator.multiply(op1, op2); break;
            case "/":
                result = calculator.divide(op1, op2); break;
            default:
                System.out.println("Wrong operation!"); return;
        }

        System.out.println(String.format("%d %s %d is %d", op1, oper, op2, result));
    }
}
