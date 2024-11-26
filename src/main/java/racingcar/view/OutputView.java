package racingcar.view;

import racingcar.Cars;
import racingcar.Name;
import racingcar.view.console.Writer;

public class OutputView {

    private static final String RESULT = "실행결과";
    private static final String WINNER = "최종 우승자 : %s";

    public void printResult() {
        Writer.println(RESULT);
    }

    public void printState(Cars cars) {
        Writer.println(cars + "\n");
    }

    public void printWinner(Cars cars) {
        Writer.println(fitFormat(cars));
    }

    private String fitFormat(Cars cars) {
        return String.format(
                WINNER,
                String.join(", ",
                        cars.findWinner().stream()
                                .map(Name::toString)
                                .toList()
                )
        );
    }
}
