package baseball.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class AnswerGenerator {

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
