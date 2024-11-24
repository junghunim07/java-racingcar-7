package racingcar;

public class Car {

    private static final int MOVE_THRESHOLD = 4;
    private static final int STEP = 1;

    String name;
    int position = 0;

    Car(String name) {
        validate(name);
        this.name = name;
    }

    void move(int condition) {
        if (condition >= MOVE_THRESHOLD) {
            this.position += STEP;
        }
    }

    private void validate(String name) {
        validateLength(name);
        validateBlank(name);
    }

    private void validateLength(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException("6자 이상은 입력할 수 없습니다.");
        }
    }

    private void validateBlank(String name) {
        if (name.isBlank()) {
            throw new IllegalArgumentException("이름은 공백일 수 없습니다.");
        }
    }
}
