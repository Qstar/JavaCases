package designPattern.BuilderPattern;

public class MealA extends MealBuilder{

    @Override
    public void buildDrink() {
        meal.setDrink("一杯可乐");
    }

    @Override
    public void buildFood() {
        meal.setFood("一盒薯条");
    }

}
