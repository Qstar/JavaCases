package designPattern.abstractFactory.PersonFactory;

interface PersonFactory {
    BoyInterface getBoy();

    GirlInterface getGirl();
}
