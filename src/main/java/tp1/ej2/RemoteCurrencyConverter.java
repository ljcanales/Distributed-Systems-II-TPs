package tp1.ej2;

import java.rmi.Remote;

public interface RemoteCurrencyConverter extends Remote {
    String ARS_TO_USD = "ARS to USD";
    String USD_TO_ARS = "USD to ARS";
    long arsToUsd(long amount) throws Exception;
    long usdToArs(long amount) throws Exception;
}
