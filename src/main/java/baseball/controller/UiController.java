package baseball.controller;

import baseball.ui.handler.*;

public class UiController {

    public void UserInput(String userInput) {
        int[] userBatting = UserInputHandler.stringParseInt(userInput);
    }
}
