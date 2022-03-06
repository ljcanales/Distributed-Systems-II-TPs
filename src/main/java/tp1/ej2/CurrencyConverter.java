package tp1.ej2;

import org.json.JSONObject;
import utils.Constants;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class CurrencyConverter extends UnicastRemoteObject implements RemoteCurrencyConverter {

    protected CurrencyConverter() throws RemoteException {
    }

    @Override
    public long arsToUsd(long amount) throws Exception {
        return amount / getUsdValue();
    }

    @Override
    public long usdToArs(long amount) throws Exception {
        return amount * getUsdValue();
    }

    private long getUsdValue() throws Exception {
        HttpRequest request = HttpRequest.newBuilder().uri(new URI(Constants.URI_USD_VALUE)).GET().build();
        String res = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString()).body();
        JSONObject obj = new JSONObject(res);
        return obj.getJSONObject("oficial").getLong("value_buy");
    }
}
