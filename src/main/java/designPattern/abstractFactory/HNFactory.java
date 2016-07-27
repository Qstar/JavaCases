package designPattern.abstractFactory;

class HNFactory implements PersonFactory {
    @Override
    public BoyInterface getBoy(){
        return new HNBoy();
    }

    @Override
    public GirlInterface getGirl(){
        return new HNGirl();
    }
}
