package baseball.service;

import baseball.ui.handler.UserInputHandler;
import baseball.util.RandomNumberGenerator;

import java.io.IOException;

import static baseball.ui.handler.UserInputHandler.userInput;

public class baseballService {

    public static void gameProcess() throws IOException {
        int[] computerBall = computerBall();
        int[] userBall = userBall();
    }

    public static int[] userBall() throws IOException {
        String pitcherBall = userInput();
        return UserInputHandler.stringParseInt(pitcherBall);
    }

    public static int[] computerBall() {
        return new RandomNumberGenerator().computerBall();
    }
}
