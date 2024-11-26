package racingcar;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarsTest {

    @DisplayName("자동차들 객체 생성 테스트")
    @Test
    void 객체_생성() {
        Car car1 = new Car(new Name("자바"));
        Car car2 = new Car(new Name("백엔드"));

        Cars cars = new Cars(List.of(car1, car2));

        assertThat(cars).isNotNull();
    }

    @DisplayName("중복이 있을 경우 예외 발생")
    @Test
    void 중복_존재_리스트() {
        Car car1 = new Car(new Name("자바"));
        Car car2 = new Car(new Name("백엔드"));
        Car car3 = new Car(new Name("자바"));

        assertThatThrownBy(() -> new Cars(List.of(car1, car2, car3)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("참여자가 1명일 경우 예외")
    @Test
    void 참여자_홀로() {
        Car car = new Car(new Name("자바"));

        assertThatThrownBy(() -> new Cars(List.of(car)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("가장 멀리간 자동차를 알려준다.")
    @Test
    void 멀리간_자동차_단독() {
        Car car1 = new Car(new Name("자바"), 2);// 우승자
        Car car2 = new Car(new Name("개발자"), 1);

        Cars cars = new Cars(List.of(car1, car2));

        assertThat(cars.findWinner().size()).isEqualTo(1);
        assertThat(cars.findWinner().get(0)).isEqualTo(car1);
    }
}
