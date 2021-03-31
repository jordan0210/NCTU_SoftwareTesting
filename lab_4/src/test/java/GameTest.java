import jdk.jfr.Name;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.stream.Stream;

class GameTest {
    private static Stream<Arguments> AllWinTestInputParameter(){
        return Stream.of(
                Arguments.of(new int[]{0, 2}, "Player 1 win!\n"),
                Arguments.of(new int[]{1, 0}, "Player 1 win!\n"),
                Arguments.of(new int[]{2, 1}, "Player 1 win!\n")
        );
    }
    private static Stream<Arguments> AllLoseTestInputParameter(){
        return Stream.of(
                Arguments.of(new int[]{0, 1}, "Player 2 win!\n"),
                Arguments.of(new int[]{1, 2}, "Player 2 win!\n"),
                Arguments.of(new int[]{2, 0}, "Player 2 win!\n")
        );
    }
    private static Stream<Arguments> AllDrawTestInputParameter(){
        return Stream.of(
                Arguments.of(new int[]{0, 0}, "Draw!\n"),
                Arguments.of(new int[]{1, 1}, "Draw!\n"),
                Arguments.of(new int[]{2, 2}, "Draw!\n")
        );
    }
    private static Stream<Arguments> TestValidInputParameter(){
        return Stream.of(
                Arguments.of("rock", 0),
                Arguments.of("paper", 1),
                Arguments.of("scissors", 2)
        );
    }
    private static Stream<Arguments> TestInvalidInputParameter(){
        return Stream.of(
                Arguments.of("123123"),
                Arguments.of("Rock"),
                Arguments.of("ppaper"),
                Arguments.of("Scisors")
        );
    }

    Game game = new Game();

    ByteArrayOutputStream stream = new ByteArrayOutputStream();
    PrintStream printStream = new PrintStream(stream);

    @ParameterizedTest
    @MethodSource("AllWinTestInputParameter")
    @Name("All win case")
    void TestAllWinCase(int[] player, String ExpectedOutput) {
        game.player = player;
        System.setOut(printStream);

        game.checkWinner();
        Assertions.assertEquals(ExpectedOutput, stream.toString());
    }

    @ParameterizedTest
    @MethodSource("AllLoseTestInputParameter")
    @Name("All lose case")
    void TestAllLoseCase(int[] player, String ExpectedOutput) {
        game.player = player;
        System.setOut(printStream);

        game.checkWinner();
        Assertions.assertEquals(ExpectedOutput, stream.toString());
    }

    @ParameterizedTest
    @MethodSource("AllDrawTestInputParameter")
    @Name("All draw case")
    void TestAllDrawCase(int[] player, String ExpectedOutput) {
        game.player = player;
        System.setOut(printStream);

        game.checkWinner();
        Assertions.assertEquals(ExpectedOutput, stream.toString());
    }

    @ParameterizedTest
    @MethodSource("TestValidInputParameter")
    @Name("Valid input case")
    void TestVaildInputCase(String inputString, int ExpectedOutput) {
        Assertions.assertEquals(ExpectedOutput, game.validation(inputString));
    }

    @ParameterizedTest
    @MethodSource("TestInvalidInputParameter")
    @Name("Invalid input case")
    void TestInvaildInputCase(String inputString) {
        Exception exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            game.validation(inputString);
        });

        String expectedMessage = "Bad Choice!";
        String actualMessage = exception.getMessage();
        System.out.println(actualMessage);
        Assertions.assertTrue(actualMessage.contains(expectedMessage));
    }
}