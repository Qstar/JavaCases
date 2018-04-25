package designPattern.Creational.AbstractFactory.PersonFactory;

class MCFactory implements PersonFactory {
    @Override
    public BoyInterface getBoy(){
        return new MCBoy();
    }

    @Override
    public GirlInterface getGirl(){
        return new MCGirl();
    }
}
