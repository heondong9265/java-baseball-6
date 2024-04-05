package baseball.util;

import baseball.config.GameConfig;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class RandomNumberGeneratorTest {

    @DisplayName("정답 랜덤 값 생성")
    @RepeatedTest(50) // 테스트 반복 횟수
    public void testComputerBall() {
        final int BASEBALL_LENGTH = GameConfig.BASEBALL_LENGTH;
        RandomNumberGenerator game = new RandomNumberGenerator();
        int[] numbers = game.computerBall();

        assertEquals(BASEBALL_LENGTH, numbers.length, "숫자의 개수는 GameConfig의 개수를 따라야 한다.");

        for (int number : numbers) {
            assertTrue(number >= 1 && number <= 9, "모든 숫자는 1부터 9 사이의 값이어야 한다.");
        }
    }
}
