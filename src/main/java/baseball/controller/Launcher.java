package baseball.controller;

import baseball.domain.game.Game;
import baseball.domain.game.Judgement;
import baseball.domain.answer.RandomAnswerGenerator;
import baseball.domain.status.GameStatus;
import baseball.view.Display;
import baseball.view.Message;
import baseball.view.MessageFactory;
import baseball.view.MessageParam;
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

        while(!status.equals(GameStatus.WIN)) {
            Message prompt = messageFactory.build(GameStatus.PLAYING);
            display.print(prompt);

            String userInput = Console.readLine();
            validator.validate(userInput);
            Judgement judgement = game.play(userInput);
            printGameMessage(judgement);

            if (judgement.getStrike() == 3) {
                status = GameStatus.WIN;
                Message winMessage = messageFactory.build(status);
                display.print(winMessage);
            }
        }
    }

    private void printGameMessage(Judgement judgement) {
        Message message = messageFactory.build(GameStatus.JUDGEMENT);
        MessageParam param = new MessageParam();
        param.add("ball", judgement.getBall());
        param.add("strike", judgement.getStrike());
        display.print(message, param);
    }
}
