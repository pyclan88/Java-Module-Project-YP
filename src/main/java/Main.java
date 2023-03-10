import java.util.Scanner;

// dev branch for Y.Practicum
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Здравствуйте! На скольких человек необходимо разделить счёт?: ");
        int numberOfPersons = getRightNumOfPers(scanner);

        String error = "Введено некоректное значение. Повторите ввод: ";
        System.out.print("Пожалуйста, введите название товара: ");
        Calculator calculator = new Calculator();
        while (true) {
            scanner.nextLine();
            String safeWord = "Завершить";
            Item item = new Item();
            item.name = scanner.nextLine();
            if (safeWord.equalsIgnoreCase(item.name)) {
                break;
            }
            calculator.addItem(item.name);
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
            System.out.print("Товар успешно добавлен! Для завершения процесса добавления товара введите \"Завершить\".\n\n" +
                    "Не хотите ли добавить ещё один товар?: ");
        }

        scanner.close();
        System.out.println();
        System.out.print(calculator.allAddedItems);
        Formatter formatter = new Formatter();
        System.out.println("Всего на сумму: " + formatter.getCurrencyCorrectly(calculator.total));
        double eachPay = calculator.getPaymentOfEachOne(calculator.total, numberOfPersons);
        String rubles = formatter.getCurrencyCorrectly(eachPay);
        System.out.println("Каждый из " + numberOfPersons + " посетителей должен заплатить " + rubles);
    }

    static int getRightNumOfPers(Scanner scanner) {
        int numberofPersons = 0;
        String error = "Введено некоректное значение. Повторите ввод: ";
        while (scanner.hasNext()) {
            if (scanner.hasNextInt()) {
                numberofPersons = scanner.nextInt();
                if (numberofPersons == 1) {
                    System.out.print("В вашем случае нет смысла ничего считать и делить.\n" +
                            "Повторите ввод: ");
                } else if (numberofPersons < 1) {
                    System.out.print(error);
                } else {
                    break;
                }
            } else {
                System.out.print(error);
                scanner.next();
            }
        }
        return numberofPersons;
    }
}