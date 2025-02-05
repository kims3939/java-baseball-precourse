package baseball.domain.game;

public class Judgement {

    private final int strike;
    private final int ball;

    public Judgement(int strike, int ball) {
        this.strike = strike;
        this.ball = ball;
    }

    public int getStrike() {
        return strike;
    }

    public int getBall() {
        return ball;
    }
}
