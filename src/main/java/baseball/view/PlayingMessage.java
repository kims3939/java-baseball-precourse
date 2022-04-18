package baseball.view;

public class PlayingMessage implements Message{

    @Override
    public void print(MessageParam param) {
        System.out.print("숫자를 입력해주세요 : ");
    }
}
