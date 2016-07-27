package Annotation.anno;

@Description("I am interface")
interface Person {
    @Description("I am interface method")
    String name();

    int age();

    @Deprecated
    void sing();
}