package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class Cars {

    private final List<Car> cars;

    public Cars(final List<Car> cars) {
        validate(cars);
        this.cars = cars;
    }

    public void moveCars() {
        cars.forEach(car -> car.move(Randoms.pickNumberInRange(0, 9)));
    }

    public List<Name> findWinner() {
        return cars.stream()
                .filter(car -> car.isEqualPosition(findMaxPosition()))
                .map(Car::getName)
                .toList();
    }

    public List<Car> getCars() {
        return cars;
    }

    @Override
    public String toString() {
        return String.join(
                "\n",
                cars.stream()
                        .map(Car::toString)
                        .toList()
        );
    }

    private int findMaxPosition() {
        return cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .getAsInt();
    }

    private void validate(List<Car> cars) {
        validateMemberCount(cars);
        validateDuplicateCars(cars);
    }

    private void validateDuplicateCars(List<Car> cars) {
        if (hasDuplicate(cars)) {
            throw new IllegalArgumentException("중복된 자동차가 있습니다.");
        }
    }

    private boolean hasDuplicate(List<Car> cars) {
        return cars.size() != getUniqueCount(cars);
    }

    private int getUniqueCount(List<Car> cars) {
        return (int) cars.stream()
                .distinct()
                .count();
    }

    private void validateMemberCount(List<Car> cars) {
        if (isOnly(cars)) {
            throw new IllegalArgumentException("경주는 혼자할 수 없습니다.");
        }
    }

    private boolean isOnly(List<Car> cars) {
        return cars.size() == 1;
    }
}
