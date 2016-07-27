package designPattern.template;

public class Tea extends RefreshBeverage {
    @Override
    protected void brew() {
        System.out.println("用80度的热水浸泡茶叶5分钟");
    }

    @Override
    protected void addCondiments() {
        System.out.println("加入柠檬");
    }

    /**
     * hook函数,提供一个默认或空的实现
     * 询问是否加入调料
     *
     * @return
     */
    @Override
    protected boolean isCustomerWantsCondiments() {
        return false;
    }
}
