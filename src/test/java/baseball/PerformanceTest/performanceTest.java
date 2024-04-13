package baseball.PerformanceTest;

import baseball.domain.Baseball;
import baseball.domain.Referee;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class PerformanceTest {
    private Baseball baseball;
    private ListBaseball listBaseball;
    private Referee referee;
    private ListReferee listReferee;
    private int[] testArray;
    private List<Integer> testList;

    @BeforeEach
    public void setUp() {
        baseball = new Baseball();
        listBaseball = new ListBaseball();
        referee = new Referee();
        listReferee = new ListReferee();
        testArray = new int[]{7, 8, 9}; // 고정된 컴퓨터 볼
        testList = new ArrayList<>(Arrays.asList(7, 8, 9)); // 동적 리스트 컴퓨터 볼
        baseball.setComputerBall(testArray);
        listBaseball.setComputerBall(new ArrayList<>(testList));
    }

    @Test
    public void performanceTest() {
        System.gc(); // 가비지 컬렉션 수행
        warmup(); // JIT 최적화를 위한 워밍업

        long totalArrayTime = runArrayTest();
        long totalListTime = runListTest();

        System.out.println("Total Array Execution time: " + totalArrayTime + " ns");
        System.out.println("Total List Execution time: " + totalListTime + " ns");
    }

    private void warmup() {
        for (int i = 0; i < 1000; i++) {
            baseball.setUserBall(new int[]{i % 9 + 1, (i+1) % 9 + 1, (i+2) % 9 + 1});
            listBaseball.setUserBall(new ArrayList<>(Arrays.asList(i % 9 + 1, (i+1) % 9 + 1, (i+2) % 9 + 1)));
            referee.computeScore(baseball);
            listReferee.computeScore(listBaseball);
        }
    }

    private long runArrayTest() {
        long startTime = System.nanoTime();
        for (int i = 1; i <= 9; i++) {
            testArray = new int[]{i, i+1, i+2};
            baseball.setUserBall(testArray);
            referee.computeScore(baseball);
        }
        long endTime = System.nanoTime();
        return endTime - startTime;
    }

    private long runListTest() {
        long startTime = System.nanoTime();
        for (int i = 1; i <= 9; i++) {
            testList = Arrays.asList(i, i+1, i+2);
            listBaseball.setUserBall(new ArrayList<>(testList));
            listReferee.computeScore(listBaseball);
        }
        long endTime = System.nanoTime();
        return endTime - startTime;
    }
}
