package be.ictdynamic.helloworld.domain;

public class TestClassWithInitializationBlock {
    public static int i;

    {
        System.out.println("I shall never code IIBs");
    }

    // start of static block
    static {
        i = 10;
        System.out.println("static block called ");
    }
}
