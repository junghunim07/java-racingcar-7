package racingcar;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class NameTest {

    @DisplayName("이름은 5자 이하이다.")
    @Test
    void 이름_5자_이하() {
        String value = "자바스프링";

        Name name = new Name(value);

        assertThat(name.getValue()).isEqualTo(value);
    }

    @DisplayName("6자 이상일 경우 예외를 발생시킨다.")
    @Test
    void 이름_6자_이상_예외() {
        assertThatThrownBy(() -> new Name("백엔드개발자"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("이름이 공백일 경우 예외를 발생시킨다.")
    @Test
    void 이름_공백_예외() {
        assertThatThrownBy(() -> new Name(""))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
