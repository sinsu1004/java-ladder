package ladder;

import ladder.view.InputView;
import ladder.view.ResultView;

public class GameApplication {
    public static void main(String[] args) {
        LadderGame ladderGame = new LadderGame(new InputView(), new ResultView());
        ladderGame.run();
    }
}
