package baseball.service;

import baseball.domain.Baseball;
import baseball.domain.Referee;
import baseball.ui.handler.UserInputHandler;
import baseball.util.RandomNumberGenerator;

import java.io.IOException;
import java.util.Arrays;

public class BaseballService {
    private final Referee referee;
    private final Baseball baseball;

    public BaseballService() {
        this.referee = new Referee();
        this.baseball = new Baseball();
    }

    public void gameProcess() throws IOException {
        System.out.println("3개의 숫자를 입력해 주세요. 예: 123");
        int[] userBall = UserInputHandler.stringParseInt(UserInputHandler.userInput());

        baseball.setUserBall(userBall);
        referee.computeScore(baseball);

        System.out.println("Strike Count: " + referee.getStrikeCount());
        System.out.println("Ball Count: " + referee.getBallCount());
    }
}
