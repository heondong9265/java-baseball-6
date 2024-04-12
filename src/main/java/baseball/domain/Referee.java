package baseball.domain;

import baseball.config.GameConfig;

import java.io.IOException;

import static baseball.ui.handler.UserInputHandler.promptForNewGame;

public class Referee {
    private static final int BASEBALL_LENGTH = GameConfig.BASEBALL_LENGTH;
    private int ballCount = 0;
    private int strikeCount = 0;

    public void computeScore(Baseball baseball) {
        resetCounts();
        int[] computerBall = baseball.getComputerBall();
        int[] userBall = baseball.getUserBall();
        for (int i = 0; i < BASEBALL_LENGTH; i++) {
            compute(computerBall, userBall, i);
        }
    }

    private void compute(int[] computerBall, int[] userBall, int index) {
        int temp = -1;
        for (int i = 0; i < BASEBALL_LENGTH; i++) {
            if(computerBall[i] == userBall[index]) {
                temp = i;
                break;
            }
        }
        correctCount(index, temp);
    }

    private void correctCount(int index, int temp) {
        if (temp != index && temp != -1) { ballCount++; }
        if (temp == index) { strikeCount++; }
    }

    public void resetCounts() {
        this.strikeCount = 0;
        this.ballCount = 0;
    }

    public boolean gameOver(Baseball baseball) throws IOException {
        if(strikeCount == BASEBALL_LENGTH) {
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            if (!promptForNewGame()) {
                System.out.println("게임을 종료합니다.");
                return false;
            }
            baseball.reset();
        }
        return true;
    }

    public void resultDisplay() {
        if (strikeCount == 0 && ballCount == 0) {
            System.out.println("낫싱");
        } else if (strikeCount > 0 && ballCount > 0) {
            System.out.println(ballCount + "볼 " + strikeCount + "스트라이크");
        } else if (strikeCount > 0) {
            System.out.println(strikeCount + "스트라이크");
        } else if (ballCount > 0) {
            System.out.println(ballCount + "볼");
        }
    }

}
