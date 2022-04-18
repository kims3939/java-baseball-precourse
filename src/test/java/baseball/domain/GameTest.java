package baseball.domain;

import static org.assertj.core.api.Assertions.assertThat;
import baseball.domain.answer.StaticAnswerGenerator;
import baseball.domain.game.Game;
import baseball.domain.game.Judgement;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

@DisplayName("Game 클래스")
class GameTest {

    Game game = new Game(new StaticAnswerGenerator(1,2,3));

    @Test
    @DisplayName("play 메소드는 사용자 입력을 전달받아서 결과를 반환한다")
    void play_return_judgment() {
        //given
        String userInput = "123";

        //when
        Judgement judgement = game.play(userInput);

        //then
        assertThat(judgement).isNotNull();
    }

    @ParameterizedTest
    @DisplayName("play 메소드는 사용자 입력을 전달받아서 스트라이크 개수를 결과에 포함시켜 반환한다")
    @CsvSource(value = {"123, 3", "124, 2", "145, 1", "456, 0"})
    void play_return_strike_count(String userInput, int numOfStrike) {
        //when
        Judgement judgement = game.play(userInput);

        //then
        assertThat(judgement.getStrike()).isEqualTo(numOfStrike);
    }

    @ParameterizedTest
    @DisplayName("play 메소드는 사용자 입력을 전달받아서 볼 개수를 결과에 포함시켜 반환한다")
    @CsvSource(value = {"123, 0", "134, 1", "234, 2", "231, 3"})
    void play_return_ball_count(String userInput, int numOfBall) {
        //when
        Judgement judgement = game.play(userInput);

        //then
        assertThat(judgement.getBall()).isEqualTo(numOfBall);
    }
}
