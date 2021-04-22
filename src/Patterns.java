import java.util.regex.Pattern;

public class Patterns {
    private static String length = ".{6,20}";
    private static String upperCaseENOnce = "(?=.*[A-Z])";
    private static String upperCaseRUOnce = "(?=.*[А-ЯЁ])";
    private static String lowCaseENOnce = "(?=.*[a-z])";
    private static String lowCaseRUOnce = "(?=.*[а-яё])";
    private static String digitOnce = "(?=.*[0-9])";
    private static String specialCharacterOnce = "(?=.*[@#$%^&+=])";
    private static String noSpace = "(?=\\S+$)";

    private Patterns() {}

    public static boolean length(String string) {
        Pattern pattern = Pattern.compile(length);
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

    public static boolean SpecialCharacterOnce(String string) {
        Pattern pattern = Pattern.compile(specialCharacterOnce);
        return pattern.matcher(string).lookingAt();
    }

    public static boolean noSpace(String string) {
        Pattern pattern = Pattern.compile(noSpace);
        return pattern.matcher(string).lookingAt();
    }
}