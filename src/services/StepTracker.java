package services;

import model.MonthData;

import java.util.ArrayList;
import java.util.HashMap;

// TODO: Реализация функций (backend приложения)
public class StepTracker {
    private ArrayList<MonthData> daySteps;
    private final HashMap<String, ArrayList<MonthData>> monthToData = new HashMap<>();
    private int stepSeries = 10000;

    /**
     * Заполняем месяцами мапу и днями месяца (по условию каждый месяц 31 день)
     */
    public StepTracker() {
        for (Month month : Month.values()) {
            daySteps = new ArrayList<>();
            for (int i = 1; i <= 31; i++) {
                daySteps.add(new MonthData(i, 0));
            }
            String name = month.toString();
            monthToData.put(name, daySteps);
        }
    }

    /**
     * Сохранение статистики
     */
    public void enterSteps(String month, int day, int steps) {
        MonthData monthData = new MonthData(day, steps);
        monthToData.get(month).set(day - 1, monthData);
        System.out.println("Значения за " + month + " успешно сохранены!\n" + monthToData.get(month).get(day - 1));


    }

    /**
     * Печать статистики
     */
    public void printStatistics(String month) {
        int sumSteps = 0;
        int maxSteps = 0;
        int day = 0;
        System.out.println("Ваша статистика:");
        System.out.println("Общая:");
        System.out.println(month);
        System.out.println(monthToData.get(month));
        System.out.println("Общее число пройденных шагов за введенный месяц:");
        for (MonthData monthData : monthToData.get(month)) {
            sumSteps += monthData.getSteps();
            if (maxSteps < monthData.getSteps()) {
                maxSteps = monthData.getSteps();
                day = monthData.getDay();
            }
        }
        System.out.println("Вы прошли в этом месяце: " + sumSteps + " шагов");
        System.out.println("Максимальное пройденное число шагов в этом месяце: " + maxSteps + " шагов это было " + day + " числа");
        System.out.println("Пройденная дистанция: " + sumSteps * 75 + " м");
        System.out.println("Вы сожгли : " + sumSteps * 50 / 1000 + " ккал");
        bestStepSeries(month);


    }

    /**
     * Рассчет максимальнго количество подряд идущих дней, в течение которых количество шагов за день было выше целевого
     */
    private void bestStepSeries(String month) {
        int currentSeries = 0;
        int maxSeries = 0;
        for (MonthData monthData : monthToData.get(month)) {

            if (monthData.getSteps() > stepSeries) {
                currentSeries++;
            } else if (currentSeries > maxSeries) {
                maxSeries = currentSeries;
                currentSeries = 0;
            }
        }
        System.out.println("Лучшая серия: максимальное количество подряд идущих дней, " +
                "в течение которых количество шагов за день было выше целевого " + maxSeries);

    }

    public void setStepSeries(int stepSeries) {
        this.stepSeries = stepSeries;
    }

    @Override
    public String toString() {
        return "StepTracker{" +
                "daySteps=" + daySteps
                + ", monthToData=" + monthToData.keySet() +
                '}';
        
    }


}


