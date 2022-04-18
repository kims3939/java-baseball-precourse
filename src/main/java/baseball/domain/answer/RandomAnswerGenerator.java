package baseball.domain.answer;

import baseball.domain.answer.Answer;
import baseball.domain.answer.AnswerGenerator;
import camp.nextstep.edu.missionutils.Randoms;

public class RandomAnswerGenerator implements AnswerGenerator {

    public Answer generate() {
        Answer answer = new Answer();
        int pos = 0;
        while(answer.size() < 3) {
            int number = Randoms.pickNumberInRange(1, 9);
            if (answer.isNewNumber(number)) {
                answer.add(pos, number);
                pos++;
            }
        }

        return answer;
    }
}
