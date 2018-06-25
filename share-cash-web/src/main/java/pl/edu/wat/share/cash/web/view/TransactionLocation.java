package pl.edu.wat.share.cash.web.view;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by Kamil Przyborowski
 * Wojskowa Akademia Techniczna im. Jarosława Dąbrowskiego, Warszawa 2018.
 */
@Data
@NoArgsConstructor
public class TransactionLocation {
    private Double latitude;
    private Double longitude;
    private String transactionAddress;

    public TransactionLocation(Double latitude, Double longitude, String transactionAddress) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.transactionAddress = getAddress(transactionAddress);
    }

    private String getAddress(String addr) {
        if(addr == null) {
            return "";
        }
        String[] addrs = addr.split(";");
        if(addrs.length >= 1) {
            return addrs[0];
        }
        return "";
    }

}
