package baseball.service;

import baseball.config.GameConfig;
import baseball.ui.handler.UserInputHandler;
import baseball.util.RandomNumberGenerator;

import java.io.IOException;

import static baseball.ui.handler.UserInputHandler.userInput;

public class BaseballService {
    // TODO : 상태는 추후 도메인에 따로 빼기
    private static int[] computerBall;
    private static int[] userBall;
    private static int ballCount = 0;
    private static int strikeCount = 0;
    private static final int BASEBALL_LENGTH = GameConfig.BASEBALL_LENGTH;

    public static void gameProcess() throws IOException {
        computerBall = computerBall();
        userBall = userBall();
        computeScore(computerBall, userBall);
    }

    private static int[] userBall() throws IOException {
        String pitcherBall = userInput();
        return UserInputHandler.stringParseInt(pitcherBall);
    }

    private static int[] computerBall() {
        return new RandomNumberGenerator().computerBall();
    }

    private static void computeScore(int[] computerBall, int[] userBall) {
        for (int i = 0; i < BASEBALL_LENGTH; i++) {
            compute(computerBall, userBall, i);
        }
    }

    private static void compute(int[] computerBall, int[] userBall, int index) {
        int temp = -1;
        for (int i = 0; i < BASEBALL_LENGTH; i++) {
            if(computerBall[i] == userBall[index]) {
                temp = i;
                break;
            }
        }
        correctCount(index, temp);
    }

    private static void correctCount(int index, int temp) {
        if (temp != index && temp != -1) { ballCount++; }
        if (temp == index) { strikeCount++; }
    }
}
