package racingcar;

public class Name {

    private final String value;

    Name(final String value) {
        validate(value);
        this.value = value;
    }

    public String getValue() {
        return value;
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

    @Override
    public boolean equals(final Object o) {
        return value.equals(((Name) o).value);
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }
}
