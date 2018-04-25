package designPattern.Behavioral.Command;

public class ChangeChannelCommand implements Command{
    private Television tv;

    public ChangeChannelCommand(){
        tv = new Television();
    }

    @Override
    public void execute() {
        tv.changeChannel();
    }

}
