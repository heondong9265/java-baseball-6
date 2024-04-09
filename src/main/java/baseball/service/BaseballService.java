package baseball.service;

import baseball.domain.Referee;
import baseball.ui.handler.UserInputHandler;
import baseball.util.RandomNumberGenerator;

import java.io.IOException;
import java.util.Arrays;

public class BaseballService {
    private final Referee referee;
    private final RandomNumberGenerator randomNumberGenerator;

    public BaseballService() {
        this.referee = new Referee();
        this.randomNumberGenerator = new RandomNumberGenerator();
    }

    public void gameProcess() throws IOException {
        int[] computerBall = randomNumberGenerator.computerBall();

        System.out.println("3개의 숫자를 입력해 주세요. 예: 123");
        String userInputString = UserInputHandler.userInput();
        int[] userBall = UserInputHandler.stringParseInt(userInputString);

        referee.computeScore(computerBall, userBall);

        System.out.println("Strike Count: " + referee.getStrikeCount());
        System.out.println("Ball Count: " + referee.getBallCount());
        System.out.println("Computer Balls: " + Arrays.toString(computerBall));
    }
}
