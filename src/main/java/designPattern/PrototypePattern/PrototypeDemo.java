package designPattern.PrototypePattern;

public class PrototypeDemo implements Cloneable {
    @Override
    public Object clone() {
        Object object = null;
        try {
            object = super.clone();
        } catch (CloneNotSupportedException exception) {
            System.err.println("Not support cloneable");
        }
        return object;
    }
}