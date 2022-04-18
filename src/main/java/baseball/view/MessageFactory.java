package baseball.view;

import baseball.domain.GameStatus;

public class MessageFactory {
    public Message build(GameStatus status) {
        if (status.equals(GameStatus.PLAYING)) {
            return new PlayingMessage();
        }

        return new ReadyMessage();
    }
}
