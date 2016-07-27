package designPattern.abstractFactory;

interface PersonFactory {
    BoyInterface getBoy();

    GirlInterface getGirl();
}
