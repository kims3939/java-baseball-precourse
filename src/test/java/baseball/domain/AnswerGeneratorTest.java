package baseball.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Collection;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("AnswerGenerator 클래스")
class AnswerGeneratorTest {

    AnswerGenerator generator = new AnswerGenerator();

    @Test
    @DisplayName("generate 메소드가 생성한 answer는 3자리수 숫자를 가진다")
    void generate_three_length_numbers() {
        //when
        Answer answer = generator.generate();
        Map<Integer, Integer> numbers = answer.getNumbers();
        //then
        assertThat(numbers.size()).isEqualTo(3);
    }

}
