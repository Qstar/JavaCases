package designPattern.adapter;

class TwoplugAdapterExtends extends GBTwoPlug implements ThreePlugIf {

    @Override
    public void powerWithThree(){
        System.out.println("借助继承适配器");
        this.powerWithTwo();
    }
}
