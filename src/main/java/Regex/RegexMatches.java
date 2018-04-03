package Regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexMatches {
    private static final String PATTERN = "^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
    private static final Pattern MY_PATTERN = Pattern.compile(PATTERN);

    public static void main(String args[]) {

        String valEmail1 = "testemail@domain.com";
        String invalidEmail1 = "....@domain.com";
        String invalidEmail2 = ".$$%%@domain.com";
        String valEmail2 = "test.email@domain.com";

        System.out.println("Is Email ID1 valid? " + validateEMailID(valEmail1));
        System.out.println("Is Email ID1 valid? " + validateEMailID(invalidEmail1));
        System.out.println("Is Email ID1 valid? " + validateEMailID(invalidEmail2));
        System.out.println("Is Email ID1 valid? " + validateEMailID(valEmail2));

    }

    private static boolean validateEMailID(String emailID) {
        Matcher match = MY_PATTERN.matcher(emailID);
        return match.matches();
    }
}