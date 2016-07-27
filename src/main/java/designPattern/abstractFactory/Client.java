package designPattern.abstractFactory;

public class Client {
    public static void main(String[] args){
        PersonFactory personFactory = new MCFactory();
        //抽象工厂
        BoyInterface boyInterface = personFactory.getBoy();
        boyInterface.drawMan();

        PersonFactory personFactory1 = new HNFactory();
        GirlInterface girlInterface = personFactory1.getGirl();
        girlInterface.drawWoman();
        System.out.println("--------------抽象工厂调用结束----------------");
    }
}
