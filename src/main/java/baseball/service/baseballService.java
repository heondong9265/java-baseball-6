package baseball.service;

import baseball.ui.handler.UserInputHandler;

import java.io.IOException;

import static baseball.ui.handler.UserInputHandler.userInput;

public class baseballService {

    public static void gameProcess() throws IOException {
        int[] ball = throwBall();
    }

    public static int[] throwBall() throws IOException {
        String pitcherBall = userInput();
        return UserInputHandler.stringParseInt(pitcherBall);
    }
}
