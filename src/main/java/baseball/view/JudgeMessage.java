package baseball.view;

public class JudgeMessage implements Message{

    @Override
    public void print(MessageParam param) {
        StringBuilder message = new StringBuilder();
        writeMessage(message, param);
        System.out.println(message);
    }

    private void writeMessage(StringBuilder message, MessageParam param) {
        writeBall(message, param);
        writeStrike(message, param);

        if (message.length() < 1) {
            message.append("낫싱");
        }
    }

    private void writeBall(StringBuilder message, MessageParam param) {
        int ball = Integer.parseInt(param.get("ball"));
        if (ball > 0) {
            message.append(ball).append("볼").append(" ");
        }
    }

    private void writeStrike(StringBuilder message, MessageParam param) {
        int strike = Integer.parseInt(param.get("strike"));
        if (strike > 0) {
            message.append(strike).append("스트라이크");
        }
    }


}
