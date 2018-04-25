package designPattern.Structural.Adapter;


public class NoteBook {
    private ThreePlugIf plug;

    private NoteBook(ThreePlugIf plug){
        this.plug = plug;
    }

    public static void main(String[] args){
        GBTwoPlug two = new GBTwoPlug();
        ThreePlugIf three = new TwoPlugAdapter(two);
        NoteBook nb = new NoteBook(three);
        nb.charge();

        three = new TwoplugAdapterExtends();
        nb = new NoteBook(three);
        nb.charge();
    }

    //使用插座充电
    private void charge(){
        plug.powerWithThree();
    }
}

