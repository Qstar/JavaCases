package designPattern.simpleFactory;

public class Client {
    public static void main(String[] args) {
        //接口调用
        HairInterface hairInterface = new LeftHair();
        hairInterface.draw();
        System.out.println("--------------接口调用结束----------------");

        HairFactory hairFactory = new HairFactory();

        //工厂调用
        HairInterface hairInterface1 = hairFactory.getHairByString("center");
        hairInterface1.draw();
        System.out.println("--------------工厂调用结束----------------");

        //反射工厂调用
        HairInterface hairInterface2 = hairFactory.getHairByClassName("designPattern.simpleFactory.RightHair");
        hairInterface2.draw();
        System.out.println("--------------反射工厂调用结束----------------");

        //优化,读文件反射调用
        HairInterface hairInterface3 = hairFactory.getHairByClassKey("left");
        hairInterface3.draw();
        System.out.println("--------------优化,读文件反射调用结束----------------");
    }

}
