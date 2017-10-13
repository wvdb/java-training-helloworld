package be.ictdynamic.helloworld.utilities;

import java.util.Scanner;

/**
 * Created by admin on 12/10/2017.
 */
public final class KeyboardUtility {
    private KeyboardUtility() {
    }

    public final static int readInt() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    public final static StringBuilder readStringAndReturnStringBuilder() {
        Scanner scanner = new Scanner(System.in);
        String myString = scanner.nextLine();
        StringBuilder stringBuilder = new StringBuilder(myString);
        return stringBuilder;
    }

    public final static String readStringAndReturnString() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

}
