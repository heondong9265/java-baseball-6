package baseball;

import baseball.service.BaseballService;

import java.io.IOException;

public class Application {
    public static void main(String[] args) throws IOException {
        BaseballService.gameProcess();
    }
}
