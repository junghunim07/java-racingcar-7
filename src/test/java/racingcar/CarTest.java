package racingcar;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarTest {

    @DisplayName("자동차는 위치 값을 가진다.")
    @Test
    void 자동차_위치() {
        Name name = new Name("자동차");
        Car car = new Car(name);

        assertThat(car.getPosition()).isEqualTo(0);
    }

    @DisplayName("자동차는 0에서 9 사이에서 무작위 값을 구한 후 값이 4 이상일 경우 전진한다.")
    @Test
    void 자동차_전진() {
        Name name = new Name("자동차");
        Car car = new Car(name);

        car.move(4);

        assertThat(car.getPosition()).isEqualTo(1);
    }

    @DisplayName("자동차는 0에서 9 사이에서 무작위 값을 구한 후 값이 3 이상일 경우 전진하지 않는다.")
    @Test
    void 자동차_정지() {
        Name name = new Name("자동차");
        Car car = new Car(name);

        car.move(0);

        assertThat(car.getPosition()).isEqualTo(0);
    }

    @DisplayName("같은 자동차 판별")
    @Test
    void 중복_자동차() {
        Car car1 = new Car(new Name("자바"));
        Car car2 = new Car(new Name("자바"));

        assertEquals(car1, car2);
    }
}
