import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PassVerification {
    private static InputMode modeRequest() {
        System.out.println("Включить скрытный режим? " +
                "(Не работает при запуске в IDE, используйте терминал) [y/n]:");

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String answer = "";

        try {
            answer = reader.readLine().toLowerCase();
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (answer.toLowerCase().equals("y")) {
            return InputMode.CLOSE;
        }

        return InputMode.OPEN;
    }

    public static void main(String[] args) {
        Password password = new Password();
        InputMode mode = modeRequest();

        while (true) {
            password.setPassword(mode);
            password.matchesPolicy();
            System.out.println();
        }
    }
}
