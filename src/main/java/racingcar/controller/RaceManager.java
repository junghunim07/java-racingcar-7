package racingcar.controller;

import racingcar.Cars;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RaceManager {

    private InputView inputView;
    private OutputView outputView;

    public RaceManager(final InputView inputView,
                       final OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        Cars cars = inputView.readCars();
        int count = inputView.readCount();
        process(cars, count);
    }

    private void process(Cars cars, int count) {
        outputView.printResult();
        for (int i = 0; i < count; i++) {
            cars.moveCars();
            outputView.printState(cars);
        }
        outputView.printWinner(cars);
    }
}
