package tp1.ej2;

import java.rmi.Remote;

public interface RemoteCurrencyConverter extends Remote {
    long arsToUsd(long amount) throws Exception;
    long usdToArs(long amount) throws Exception;
}
