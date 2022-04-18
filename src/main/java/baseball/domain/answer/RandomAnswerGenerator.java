package baseball.domain.answer;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomAnswerGenerator implements AnswerGenerator {

    public Answer generate() {
        Answer answer = new Answer();
        int pos = 0;
        while (answer.size() < 3) {
            int number = Randoms.pickNumberInRange(1, 9);
            pos = addNumber(answer, pos, number);
        }

        return answer;
    }

    private int addNumber(Answer answer, int pos, int number) {
        if (answer.isNewNumber(number)) {
            answer.add(pos, number);
            return pos + 1;
        }

        return pos;
    }
}
