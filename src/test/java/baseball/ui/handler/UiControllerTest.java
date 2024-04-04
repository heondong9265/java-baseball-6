package baseball.ui.handler;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class UiControllerTest {
    private static Stream<String> invalidInputProvider() {
        return Stream.of("1234", "12", "12a", "1%2", "sp@", "1 2");
    }

    @ParameterizedTest
    @MethodSource("invalidInputProvider")
    @DisplayName("올바르지 않은 사용자 입력 Test")
    public void checkInvalidUserInput(String input) {
        assertThrows(IllegalArgumentException.class, () -> UserInputHandler.stringParseInt(input));
    }

    @ParameterizedTest
    @ValueSource(strings = {"123", "325", "925"})
    @DisplayName("올바른 사용자 입력 Test")
    public void checkValidUserInputLength(String input) {
        assertDoesNotThrow(() -> UserInputHandler.checkUserInputLength(input));
    }
}
