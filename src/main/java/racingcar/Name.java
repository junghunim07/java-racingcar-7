package racingcar;

public class Name {

    String value;

    Name(String value) {
        validate(value);
        this.value = value;
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
