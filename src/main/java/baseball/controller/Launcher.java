package baseball.controller;

import baseball.domain.GameStatus;
import baseball.domain.StatusUpdater;
import baseball.view.Display;
import baseball.view.Message;
import baseball.view.MessageFactory;
import camp.nextstep.edu.missionutils.Console;

public class Launcher {

    private final Display display = new Display();
    private final MessageFactory messageFactory = new MessageFactory();
    private final StatusUpdater statusUpdater = new StatusUpdater();

    public void start() {
        GameStatus gameStatus = GameStatus.READY;

        while(!gameStatus.equals(GameStatus.FINISH)) {
            printMessage(gameStatus);
            String input = Console.readLine();
            gameStatus = statusUpdater.nextStatusOf(gameStatus, input);
        }
    }

    private void printMessage(GameStatus gameStatus) {
        Message message = messageFactory.build(gameStatus);
        display.printMessage(message);
    }


}
