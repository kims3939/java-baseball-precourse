package baseball.view;


public class Display {
    public void print(Message message) {
        message.print(MessageParam.empty());
    }

    public void print(Message message, MessageParam param) {
        message.print(param);
    }
}
