package be.ictdynamic.helloworld.cursus_domain;

public interface Father {
    int age = 51;

    public default void enjoysPlayingTennis(){
        System.out.println("Playing tennis is good fun");
    }

    public default void studiesHard(){
        System.out.println("Study hard, work hard, stay humble and be kind.");
    }

//    public default void thinkOfClimate() {
//
//    }

}
