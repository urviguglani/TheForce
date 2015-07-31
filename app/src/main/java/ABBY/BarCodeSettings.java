package ABBY;

/**
 * Created by User on 26/7/2015.
 */
public class BarCodeSettings {
    public String asUrlParams() {
        return "barcodeType=" + barcodeType;
    }

    public String getType() {
        return barcodeType;
    }

    public void setType(String newType) {
        barcodeType = newType;
    }

    private String barcodeType = "autodetect";
}
