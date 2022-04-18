package baseball.view;


import baseball.view.message.Message;
import baseball.view.message.MessageParam;

public class Display {

    public void print(Message message) {
        message.print(MessageParam.empty());
    }

    public void print(Message message, MessageParam param) {
        message.print(param);
    }
}
