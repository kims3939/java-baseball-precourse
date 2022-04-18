package baseball.domain.game;

import baseball.domain.answer.Answer;
import baseball.domain.answer.AnswerGenerator;

public class Game {

    private final Answer answer;

    public Game(AnswerGenerator generator) {
        this.answer = generator.generate();
    }

    public Judgement play(String userInput) {
        String[] numbers = userInput.split("");
        int strike = countStrike(numbers);
        int ball = countBall(numbers);

        return new Judgement(strike, ball);
    }

    private int countStrike(String[] numbers) {
        int count = 0;
        for (int pos = 0; pos < numbers.length; pos++) {
            int num = Integer.parseInt(numbers[pos]);
            count = nextCountForStrike(count, num, pos);
        }

        return count;
    }

    private int nextCountForStrike(int count, int num, int pos) {
        if (num == answer.numberAt(pos)) {
            return count + 1;
        }

        return count;
    }

    private int countBall(String[] numbers) {
        int count = 0;
        for (int pos = 0; pos < numbers.length; pos++) {
            int num = Integer.parseInt(numbers[pos]);
            count = nextCountForBall(count, num, pos);
        }

        return count;
    }

    private int nextCountForBall(int count, int num, int pos) {
        if (answer.contains(num) && answer.numberAt(pos) != num) {
            return count + 1;
        }

        return count;
    }
}
