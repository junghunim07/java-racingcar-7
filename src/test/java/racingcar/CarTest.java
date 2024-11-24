package racingcar;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarTest {

    @DisplayName("자동차는 5자 이하의 이름을 가질 수 있다.")
    @Test
    void 자동차_5자_이하_이름() {
        String name = "자바스프링";

        Car car = new Car(name);

        assertThat(car.name).isEqualTo(name);
    }

    @DisplayName("자동차 6자 이상일 경우 예외 발생")
    @Test
    void 자동차_6자_이상_예외() {
        String name = "백엔드개발자";

        assertThatThrownBy(() -> new Car(name))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("자동차 이름이 공백일 경우 예외")
    @Test
    void 자동차_이름_공백_예외() {
        String name = "";

        assertThatThrownBy(() -> new Car(name))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("자동차는 위치 값을 가진다.")
    @Test
    void 자동차_위치() {
        Car car = new Car("자동차");

        assertThat(car.position).isEqualTo(0);
    }

    @DisplayName("자동차는 0에서 9 사이에서 무작위 값을 구한 후 값이 4 이상일 경우 전진한다.")
    @Test
    void 자동차_전진() {
        Car car = new Car("자동차");

        car.move(4);

        assertThat(car.position).isEqualTo(1);
    }

    @DisplayName("자동차는 0에서 9 사이에서 무작위 값을 구한 후 값이 3 이상일 경우 전진하지 않는다.")
    @Test
    void 자동차_정지() {
        Car car = new Car("자동차");

        car.move(0);

        assertThat(car.position).isEqualTo(0);
    }
}
