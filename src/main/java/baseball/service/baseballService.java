package baseball.service;

import baseball.ui.handler.UserInputHandler;

import java.io.IOException;

import static baseball.ui.handler.UserInputHandler.userInput;

public class baseballService {

    public static void throwBall() throws IOException {
        String pitcherBall = userInput();
        UserInputHandler.stringParseInt(pitcherBall);
    }
}
