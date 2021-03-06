package designPattern.Behavioral.Command;

public class OpenTvCommand implements Command{
    private Television tv;

    public OpenTvCommand(){
        tv = new Television();
    }

    @Override
    public void execute() {
        tv.open();
    }

}
