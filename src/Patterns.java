import java.util.regex.Pattern;

public class Patterns {
    private static final String length = ".{%d,%d}";
    private static final String upperCaseENOnce = "(?=.*[A-Z])";
    private static final String upperCaseRUOnce = "(?=.*[А-ЯЁ])";
    private static final String lowCaseENOnce = "(?=.*[a-z])";
    private static final String lowCaseRUOnce = "(?=.*[а-яё])";
    private static final String digitOnce = "(?=.*[0-9])";
    private static final String specialCharacterOnce = "(?=.*[@#$%^&+=])";
    private static final String tripleCharacterRepeat = "^.*(.)\\1\\1.*$";
    private static final String noSpace = "(?=\\S+$)";

    private Patterns() {}

    public static boolean length(String string, int min, int max) {
        String regex = String.format(length, min, max);

        Pattern pattern = Pattern.compile(regex);
        return pattern.matcher(string).lookingAt();
    }

    public static boolean upperCaseENOnce(String string) {
        Pattern pattern = Pattern.compile(upperCaseENOnce);
        return pattern.matcher(string).lookingAt();
    }

    public static boolean upperCaseRUOnce(String string) {
        Pattern pattern = Pattern.compile(upperCaseRUOnce);
        return pattern.matcher(string).lookingAt();
    }

    public static boolean lowCaseENOnce(String string) {
        Pattern pattern = Pattern.compile(lowCaseENOnce);
        return pattern.matcher(string).lookingAt();
    }

    public static boolean lowCaseRUOnce(String string) {
        Pattern pattern = Pattern.compile(lowCaseRUOnce);
        return pattern.matcher(string).lookingAt();
    }

    public static boolean digitOnce(String string) {
        Pattern pattern = Pattern.compile(digitOnce);
        return pattern.matcher(string).lookingAt();
    }

    public static boolean specialCharacterOnce(String string) {
        Pattern pattern = Pattern.compile(specialCharacterOnce);
        return pattern.matcher(string).lookingAt();
    }

    public static boolean noTripleCharacterRepeat(String string) {
        Pattern pattern = Pattern.compile(tripleCharacterRepeat);
        return !pattern.matcher(string).find();
    }

    public static boolean noSpace(String string) {
        Pattern pattern = Pattern.compile(noSpace);
        return pattern.matcher(string).lookingAt();
    }
}