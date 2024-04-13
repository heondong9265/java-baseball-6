package baseball.PerformanceTest;

import baseball.util.RandomNumberGenerator;

import java.util.List;

public class ListBaseball {
    private List<Integer> computerBall;
    private List<Integer> userBall;

    public ListBaseball() {
        this.computerBall = new RandomNumberGenerator().generateBalltoList;
    }

    public void setUserBall(List<Integer> userBall) {
        this.userBall = userBall;
    }

    public List<Integer> getComputerBall() {
        return computerBall;
    }

    public List<Integer> getUserBall() {
        return userBall;
    }

    public void reset() {
        this.computerBall = new RandomNumberGenerator().generateBalltoList();
    }

    public void setComputerBall(List<Integer> computerBall) {
        this.computerBall = computerBall;
    }
}
