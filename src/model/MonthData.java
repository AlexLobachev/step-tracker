package model;

// TODO: класс сущность
public class MonthData {

    public MonthData(int day, int steps) {
        this.steps = steps;
        this.day = day;
    }

    private final int steps;
    private final int day;

    public int getSteps() {
        return steps;
    }

    public int getDay() {
        return day;
    }

    @Override
    public String toString() {
        return

                "День = " + day + " ---> " +
                        "Шаги = " + steps +
                        '}';
    }
}
