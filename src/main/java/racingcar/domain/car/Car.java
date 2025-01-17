package racingcar.domain.car;

import racingcar.domain.Name;

public class Car {
    private static final int INITIAL_VALUE = 0;
    private static final int STOP_THRESHOLD = 4;

    private final Name name;
    private int position;

    public Car(String name) {
        this.name = new Name(name);
        this.position = INITIAL_VALUE;
    }

    public Name getCarName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public void process(int value) {
        if (isOverStopThreshold(value)) {
            position++;
        }
    }

    private boolean isOverStopThreshold(int value) {
        return value >= STOP_THRESHOLD;
    }

    public boolean isEqualPosition(int value) {
        return position == value;
    }
}
