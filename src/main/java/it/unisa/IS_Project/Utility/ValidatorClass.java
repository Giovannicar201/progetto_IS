package it.unisa.IS_Project.Utility;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidatorClass {
    private static final String gmailPattern="^[a-zA-Z0-9._%+-]+@gmail.com$";
    private static final Pattern gmail=Pattern.compile(gmailPattern);
    private static final String yhaooPattern="^[a-zA-Z0-9._%+-]+@yhaoo.com$";
    private static final Pattern yhaoo=Pattern.compile(yhaooPattern);
    private static final String hotmailPattern="^[a-zA-Z0-9._%+-]+@hotmail.com$";
    private static final Pattern hotmail=Pattern.compile(hotmailPattern);
    private static final String passwordPattern="^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).{8,}$";
    private static final Pattern password = Pattern.compile(passwordPattern);


    public static boolean emailValidator(String email){
        Matcher gmailMatcher=gmail.matcher(email);
        Matcher yhaooMatcher=yhaoo.matcher(email);
        Matcher hotmailMatcher=hotmail.matcher(email);
        return gmailMatcher.matches() || yhaooMatcher.matches() || hotmailMatcher.matches();
    }

    public static boolean passwordValidator(String passwordVal){
        Matcher passwordMatcher=password.matcher(passwordVal);
        return passwordMatcher.matches();
    }

}
