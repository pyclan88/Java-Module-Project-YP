public class Calculator {
    String allItems = "Добавленные товары:\n";
    double total;
    public void sumItem(String name) {
        allItems = allItems.concat(name);
    }
    public void sumPrice(double price) {
                total += price;
        Formatter formatter = new Formatter();
        allItems = allItems.concat(" / стоимость: " + formatter.getCurrencyCorrectly(price) + "\n");
    }

    public double getPaymentOfEachOne(double total, int persons) {
        return total / persons;
    }
}
