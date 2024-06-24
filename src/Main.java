import services.Month;
import services.StepTracker;

import java.util.Scanner;

// TODO: Главное меню (fronted приложения)
public class Main {
    public static void main(String[] args) {
        /**
         * Приветствие пользователя
         */
        System.out.println("Вас приветствует счетчик калорий!");
        Scanner scanner = new Scanner(System.in);
        printMenu();
        StepTracker stepTracker = new StepTracker();
        int userInput = scanner.nextInt();
        String month;
        int day;
        int steps;
        while (true) {


            switch (userInput) {
                case 1 -> {
                    System.out.println("За какой месяц вы хотите ввести количество шагов?");
                    month = scanner.next();
                    if (validatorMonth(month) < 1) {
                        break;
                    }
                    System.out.println("За какой день вы хотите ввести количество шагов?");
                    day = scanner.nextInt();
                    if (validatorValue(day) < 1) {
                        break;
                    }
                    System.out.println("Введите кол-во пройденных шагов");
                    steps = scanner.nextInt();
                    if (validatorValue(steps) < 0) {
                        break;
                    }
                    stepTracker.enterSteps(month, day, steps);
                }
                case 2 -> {
                    System.out.println("За какой месяц вы хотите ввести количество шагов?");
                    month = scanner.next();
                    if (validatorMonth(month) < 1) {
                        break;
                    }
                    stepTracker.printStatistics(month);
                }
                case 3 -> {
                    System.out.println("Задать целевое количество шагов:");
                    steps = scanner.nextInt();
                    if (validatorValue(steps) < 0) {
                        break;
                    }
                    stepTracker.setStepSeries(steps);
                }
                case 4 -> {
                    System.out.println("Выход");
                    return;
                }
            }
            printMenu();
            userInput = scanner.nextInt();
        }
    }

    /**
     * Печать главного меню
     */
    static void printMenu() {
        System.out.println("1. Ввести количество шагов за определённый день");
        System.out.println("2. Напечатать статистику за определённый месяц");
        System.out.println("3. Изменить цель по количеству шагов в день");
        System.out.println("4. Выйти из приложения.");

    }

    /**
     * Проверка на отрицательное число шагов и дней
     */
    static int validatorValue(int value) {

        if (value < 0) {
            System.out.println("Значение не может быть отрицательным");
            return -1;
        }
        return 1;

    }

    /**
     * Проверка на корректность введенного месяца
     */
    static int validatorMonth(String month) {

        for (Month nameMonth : Month.values()) {
            String name = nameMonth.toString();
            if (name.equals(month)) {
                return 1;
            }
        }
        System.out.println("Неверно введен месяц");
        return -1;
    }
}
