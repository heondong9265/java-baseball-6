package baseball.service;

import baseball.domain.Baseball;
import baseball.domain.Referee;
import baseball.ui.handler.UserInputHandler;

import java.io.IOException;

public class BaseballService {
    private final Referee referee;
    private final Baseball baseball;

    public BaseballService() {
        this.referee = new Referee();
        this.baseball = new Baseball();
    }

    public void gameProcess() throws IOException {
        System.out.println("숫자 야구 게임을 시작합니다.");
        boolean continuePlaying;
        do {
            baseball.setUserBall(UserInputHandler.getUserInputAsIntArray());
            referee.computeScore(baseball);
            continuePlaying = referee.gameOver(baseball);
        } while (continuePlaying);
    }
}
