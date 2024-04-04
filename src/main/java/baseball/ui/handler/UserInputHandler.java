package baseball.ui.handler;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class UserInputHandler {

    public static int[] stringParseInt(String input) {
        checkUserInputLength(input);

        int[] userInput = new int[3];
        for(int i = 0; i < 3; i++) {
            char ch = input.charAt(i);
            if(48 <= ch && ch <= 57) {
                userInput[i] = ch - '0';
            } else {
                throw new IllegalArgumentException("입력은 숫자만 포함되어야 합니다.");
            }
        }
        return userInput;
    }

    public static void checkUserInputLength(String input) {
        if(input.length() != 3) {
            throw new IllegalArgumentException("올바르지 않은 입력");
        }
    }

    public static String userInput() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        return br.readLine();
    }
}
