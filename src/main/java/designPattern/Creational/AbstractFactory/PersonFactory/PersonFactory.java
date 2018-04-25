package designPattern.Creational.AbstractFactory.PersonFactory;

interface PersonFactory {
    BoyInterface getBoy();

    GirlInterface getGirl();
}
