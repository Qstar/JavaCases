package designPattern.BuilderPattern;

public class MealB extends MealBuilder{

    @Override
    public void buildDrink() {
        meal.setDrink("一杯柠檬果汁");
    }

    @Override
    public void buildFood() {
        meal.setFood("三个鸡翅");
    }

}
