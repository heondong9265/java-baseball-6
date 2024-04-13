package baseball.domain;

import baseball.util.RandomNumberGenerator;

import java.util.List;

public class Baseball {
    private int[] computerBall;
    private int[] userBall;

    public Baseball() {
        this.computerBall = new RandomNumberGenerator().generateBall();
    }

    public void setUserBall(int[] userBall) {
        this.userBall = userBall;
    }

    public int[] getComputerBall() {
        return computerBall;
    }

    public int[] getUserBall() {
        return userBall;
    }

    public void reset() {
        this.computerBall = new RandomNumberGenerator().generateBall();
    }

    public void setComputerBall(int[] computerBall) {
        this.computerBall = computerBall;
    }
}
