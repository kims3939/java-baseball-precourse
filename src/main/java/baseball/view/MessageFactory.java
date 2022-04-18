package baseball.view;

import baseball.domain.status.GameStatus;

public class MessageFactory {
   public Message build(GameStatus status) {
       switch (status) {
           case PLAYING:
               return new PlayingMessage();
           case JUDGEMENT:
               return new JudgeMessage();
           case WIN:
               return new WinMessage();
           default:
               return new ReadyMessage();
       }
   }
}
