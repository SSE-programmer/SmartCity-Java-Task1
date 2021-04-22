import java.io.BufferedReader;
import java.io.Console;
import java.io.IOException;
import java.io.InputStreamReader;

public class Password {
    private String password;

    Password() {
        password = "";
    }

    private String getClosePassword() {
        Console console = System.console();

        if (console == null) {
            ColorPrint.red("Не удалось получить экземпляр консоли.");
            System.exit(0);
        }

        System.out.print("Введите пароль: ");
        char[] charPassword = console.readPassword();

        return String.valueOf(charPassword, 0, charPassword.length);
    }

    private String getOpenPassword() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String line = "";

        try {
            System.out.print("Введите пароль: ");
            line = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return line;
    }

    public void setPassword(InputMode mode) {
        switch (mode) {
            case OPEN -> password = getOpenPassword();
            case CLOSE -> password = getClosePassword();
        }
    }

    public boolean matchesPolicy() {
        if (!Patterns.length(password)) {
            ColorPrint.red("Длина пароля должна составлять 6-20 символов.");
            return false;
        }

        if (!Patterns.digitOnce(password) && !Patterns.SpecialCharacterOnce(password)) {
            ColorPrint.red("Пароль должен содержать хотя бы одну цифру или один специальный символ.");
            return false;
        }

        if (!Patterns.lowCaseENOnce(password) && !Patterns.lowCaseRUOnce(password)) {
            ColorPrint.red("Пароль должен содержать хотя бы одну русскую или латинскую строчную букву.");
            return false;
        }

        if (!Patterns.upperCaseENOnce(password) && !Patterns.upperCaseRUOnce(password)) {
            ColorPrint.red("Пароль должен содержать хотя бы одну русскую или латинскую прописную букву.");
            return false;
        }

        if (!Patterns.noSpace(password)) {
            ColorPrint.red("Пароль не должен содержать пробелов.");
            return false;
        }

        ColorPrint.green("Пароль соответствует требованиям.");
        return true;
    }
}
