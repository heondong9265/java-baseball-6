package baseball.util;

import baseball.config.GameConfig;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class RandomNumberGenerator {
    private static final int BASEBALL_LENGTH = GameConfig.BASEBALL_LENGTH;
    private static final int BASEBALL_START_NUMBER = GameConfig.BASEBALL_START_NUMBER;
    private static final int BASEBALL_END_NUMBER = GameConfig.BASEBALL_END_NUMBER;
    public List<Integer> generateBalltoList;

    public int[] generateBall() {
        List<Integer> uniqueNumbers = Randoms.pickUniqueNumbersInRange(BASEBALL_START_NUMBER, BASEBALL_END_NUMBER, BASEBALL_LENGTH);
        return uniqueNumbers.stream().mapToInt(Integer::intValue).toArray();
    }

    public List<Integer> generateBalltoList() {
        List<Integer> uniqueNumbers = Randoms.pickUniqueNumbersInRange(BASEBALL_START_NUMBER, BASEBALL_END_NUMBER, BASEBALL_LENGTH);
        return uniqueNumbers;
    }

}
