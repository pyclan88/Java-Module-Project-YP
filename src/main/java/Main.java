import java.util.Scanner;

// dev branch for Y.Practicum
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Item item = new Item();
        Calculator calculator = new Calculator();
        Formatter formatter = new Formatter();
        String error = "Введено некоректное значение. Повторите ввод: ";

        int numberOfPersons = 0;
        System.out.print("Здравствуйте! На скольких человек необходимо разделить счёт?: ");
        while (scanner.hasNext()) {
            if (scanner.hasNextInt()) {
                numberOfPersons = scanner.nextInt();
                if (numberOfPersons == 1) {
                    System.out.println("В вашем случае нет смысла ничего считать и делить.");
                    return;
                } else if (numberOfPersons < 1) {
                    System.out.println(error);
                } else {
                    break;
                }
            } else {
                System.out.println(error);
                scanner.next();
            }
        }

        System.out.print("Пожалуйста, введите название товара: ");
        while (true) {
            scanner.nextLine();
            String safeWord = "Завершить";
            item.name = scanner.nextLine();
            if (safeWord.equalsIgnoreCase(item.name)) {
                break;
            }
            calculator.sumItem(item.name);
            System.out.print("Введите стоимость товара в формате рубли.копейки: ");
            while (scanner.hasNext()) {
                if (scanner.hasNextDouble()) {
                    item.price = scanner.nextDouble();
                    if (item.price < 0) {
                        System.out.println(error);
                    } else {
                        calculator.sumPrice((item.price));
                        break;
                    }
                } else {
                    System.out.print(error);
                    scanner.next();
                }
            }
            System.out.print("Товар успешно добавлен! Для завершения процесса добавления товара введите \"Завершить\".\n" +
                    "Не хотите ли добавить ещё один товар?: ");

        }

        scanner.close();
        System.out.println();
        System.out.print(calculator.allItems);
        System.out.println("Всего на сумму: " + formatter.getCurrencyCorrectly(calculator.total));
        double eachPay = calculator.getPaymentOfEachOne(calculator.total, numberOfPersons);
        String rubles = formatter.getCurrencyCorrectly(eachPay);
        System.out.println("Каждый из " + numberOfPersons + " посетителей должен заплатить " + rubles);
    }
}