package racingcar;

public class Car {

    private static final int MOVE_THRESHOLD = 4;
    private static final int STEP = 1;

    private final Name name;
    private int position;

    Car(final Name name) {
        this.name = name;
        this.position = 0;
    }

    public void move(int condition) {
        if (condition >= MOVE_THRESHOLD) {
            this.position += STEP;
        }
    }

    public int getPosition() {
        return position;
    }
}
