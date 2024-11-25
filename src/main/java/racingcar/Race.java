package racingcar;

import java.util.List;

public class Race {

    List<Car> cars;

    public Race(List<Car> cars) {
        this.cars = cars;
    }

    public List<Car> findWinner() {
        return cars.stream()
                .filter(car -> car.getPosition() == findMaxPosition())
                .toList();
    }

    private int findMaxPosition() {
        return cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .getAsInt();
    }
}
