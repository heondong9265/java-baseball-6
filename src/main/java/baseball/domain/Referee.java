package baseball.domain;

import baseball.config.GameConfig;

public class Referee {
    private static final int BASEBALL_LENGTH = GameConfig.BASEBALL_LENGTH;
    private int ballCount = 0;
    private int strikeCount = 0;

    public void computeScore(Baseball baseball) {
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

    public int getBallCount() {
        return ballCount;
    }

    public int getStrikeCount() {
        return strikeCount;
    }
}
