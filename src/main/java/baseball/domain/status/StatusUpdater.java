package baseball.domain.status;

public class StatusUpdater {
    public GameStatus nextStatusOf(GameStatus prevStatus, String input) {
        if (prevStatus.equals(GameStatus.READY)) {
            return whenReadyStatus(input);
        }

        return prevStatus;
    }

    private GameStatus whenReadyStatus(String input) {
        if (input.equals("1")) {
            return GameStatus.PLAYING;
        }

        return GameStatus.FINISH;
    }
}
