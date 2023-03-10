public class Formatter {
    public String getCurrencyCorrectly(double payment) {
        double onlyRuble = Math.floor(payment);
        int unit = (int)onlyRuble % 10;
        String ruble;
        if (unit == 1 && ((int)onlyRuble % 100 != 11)) {
            ruble = "рубль";
        } else if (unit > 1 && unit <= 4) {
            ruble = "рубля";
        } else {
            ruble = "рублей";
        }
        String format = String.format("%.2f %s.", payment, ruble);
        return format;
    }
}
