package Reflect.StaticDynamic;

public class DynamicOffice {
    public static void main(String[] args) {
        try {
            Class office = Class.forName(args[0]);
            OfficeAble oa = (OfficeAble) office.newInstance();
            oa.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
