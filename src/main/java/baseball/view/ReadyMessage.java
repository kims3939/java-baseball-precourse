package baseball.view;

public class ReadyMessage implements Message {

    @Override
    public void print(MessageParam param) {
        System.out.println("게임을 새로 시작하려면 1,종료 하려면 2를 입력하세요.");
    }
}
