public class Formatter {
    public String getCurrencyCorrectly(double payment) {
        double onlyRuble = Math.floor(payment);
        int unit = (int) onlyRuble % 10;
        int decimal = (int) onlyRuble % 100;
        String ruble;
        if (decimal >= 11 && decimal <= 14) {
            ruble = "рублей";
        } else if (unit == 1) {
            ruble = "рубль";
        } else if (unit >= 2 && unit <= 4) {
            ruble = "рубля";
        } else {
            ruble = "рублей";
        }
        return String.format("%.2f %s.", payment, ruble);
    }
}
