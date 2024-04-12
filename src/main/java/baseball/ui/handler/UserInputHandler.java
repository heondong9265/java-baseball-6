package baseball.ui.handler;

import camp.nextstep.edu.missionutils.Console;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class UserInputHandler {

    public static int[] getUserInputAsIntArray() throws IOException {
        System.out.print("숫자를 입력해 주세요 : ");
        String input = Console.readLine();
        return stringParseInt(input);
    }

    public static boolean promptForNewGame() throws IOException {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String input = Console.readLine();
        return "1".equals(input);
    }

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
}
