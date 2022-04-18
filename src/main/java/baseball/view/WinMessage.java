package baseball.view;

public class WinMessage implements Message{

    @Override
    public void print() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }
}
