public class Calculator {
    String allItems = "Добавленные товары:\n";
    StringBuilder allAddedItems = new StringBuilder(allItems);
    double total;

    public void addItem(String name) {
        allAddedItems.append(name);
    }

    public void sumPrice(double price) {
        total += price;
        Formatter formatter = new Formatter();
        allAddedItems.append(" / стоимость: " + formatter.getCurrencyCorrectly(price) + "\n");
    }

    public double getPaymentOfEachOne(double total, int persons) {
        return total / persons;
    }
}
