package designPattern.Mediator;

public class HouseOwner extends Person{

    HouseOwner(String name, Mediator mediator) {
        super(name, mediator);
    }

    /**
     * @desc 与中介者联系
     * @param message
     * @return void
     */
    public void contact(String message){
        mediator.contact(message, this);
    }

    /**
     * @desc 获取信息
     * @param message
     * @return void
     */
    public void getMessage(String message){
        System.out.println("房主:" + name +",获得信息：" + message);
    }
}