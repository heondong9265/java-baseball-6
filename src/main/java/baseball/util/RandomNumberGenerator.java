package baseball.util;

import baseball.config.GameConfig;
import camp.nextstep.edu.missionutils.Randoms;

public class RandomNumberGenerator {
    private static final int BASEBALL_LENGTH = GameConfig.BASEBALL_LENGTH;
    private static final int BASEBALL_START_NUMBER = GameConfig.BASEBALL_START_NUMBER;
    private static final int BASEBALL_END_NUMBER = GameConfig.BASEBALL_END_NUMBER;

    public int[] computerBall() {
        int[] numbers = new int[BASEBALL_LENGTH];
        for(int i = 0; i < BASEBALL_LENGTH; i++) {
            numbers[i] = Randoms.pickNumberInRange(BASEBALL_START_NUMBER, BASEBALL_END_NUMBER);
        }
        return numbers;
    }

}
