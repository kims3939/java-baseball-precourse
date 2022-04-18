package baseball.domain.answer;

import baseball.domain.answer.Answer;
import baseball.domain.answer.AnswerGenerator;

public class StaticAnswerGenerator implements AnswerGenerator {

    private final Answer answer;

    public StaticAnswerGenerator(int num1, int num2, int num3) {
        answer = new Answer();
        answer.add(0, num1);
        answer.add(1, num2);
        answer.add(2, num3);
    }

    @Override
    public Answer generate() {
        return answer;
    }
}
