package baseball.controller;

import baseball.domain.game.Game;
import baseball.domain.game.Judgement;
import baseball.domain.answer.RandomAnswerGenerator;
import baseball.domain.status.GameStatus;
import baseball.view.Display;
import baseball.view.message.Message;
import baseball.view.message.MessageFactory;
import baseball.view.message.MessageParam;
import camp.nextstep.edu.missionutils.Console;

public class Launcher {

    private final Display display = new Display();
    private final MessageFactory messageFactory = new MessageFactory();
    private final InputValidator validator = new InputValidator();

    public void start() {
        do {
            playGame();
        } while (!playOrStop().equals(GameStatus.FINISH));
    }

    private GameStatus playOrStop() {
        Message message = messageFactory.build(GameStatus.READY);
        display.print(message);
        String userInput = Console.readLine();

        if (userInput.equals("1")) {
            return GameStatus.PLAYING;
        }

        return GameStatus.FINISH;
    }

    private void playGame() {
        GameStatus status = GameStatus.PLAYING;
        Game game = new Game(new RandomAnswerGenerator());

        while (!status.equals(GameStatus.WIN)) {
            Message prompt = messageFactory.build(GameStatus.PLAYING);
            display.print(prompt);

            String userInput = Console.readLine();
            validator.validate(userInput);
            Judgement judgement = game.play(userInput);
            status = updateStatus(judgement);
        }
    }

    private GameStatus updateStatus(Judgement judgement) {
        printGameMessage(judgement);

        if (judgement.getStrike() == 3) {
            Message winMessage = messageFactory.build(GameStatus.WIN);
            display.print(winMessage);
            return GameStatus.WIN;
        }

        return GameStatus.PLAYING;
    }

    private void printGameMessage(Judgement judgement) {
        Message message = messageFactory.build(GameStatus.JUDGEMENT);
        MessageParam param = new MessageParam();
        param.add("ball", judgement.getBall());
        param.add("strike", judgement.getStrike());
        display.print(message, param);
    }
}
