package designPattern.Iterator;

public interface TelevisionMenu {
    public void addItem(int channe, String name, String description);

    public Iterator createIrerator();
}