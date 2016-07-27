package designPattern.template;

public abstract class RefreshBeverage {
    /**
     * 制备饮料的模板方法
     * 封装了所有子类共同遵循的算法框架
     */
    public final void prepareRefreshTemplate() {
        //1.将水煮沸
        boilWater();
        //2.泡制饮料
        brew();
        //3.将饮料倒入杯中
        pourInCup();
        if (isCustomerWantsCondiments()) {
            //4.加入调味料
            addCondiments();
        }
    }

    /**
     * hook函数,提供一个默认或空的实现
     * 询问是否加入调料
     *
     * @return
     */
    protected boolean isCustomerWantsCondiments() {

        return true;
    }

    private void boilWater() {
        System.out.println("将水煮沸");
    }

    protected abstract void brew();


    private void pourInCup() {
        System.out.println("将饮料倒入杯中");
    }

    protected abstract void addCondiments();

}
