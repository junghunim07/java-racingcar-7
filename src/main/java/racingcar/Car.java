package racingcar;

public class Car {

    private static final int MOVE_THRESHOLD = 4;
    private static final int STEP = 1;

    Name name;
    int position = 0;

    Car(Name name) {
        this.name = name;
    }

    void move(int condition) {
        if (condition >= MOVE_THRESHOLD) {
            this.position += STEP;
        }
    }
}
