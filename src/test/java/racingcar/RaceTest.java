package racingcar;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RaceTest {

    @DisplayName("위치 값이 가장 큰 자동차가 우승한다.")
    @Test
    void 단일_우승() {
        Car car1 = new Car(new Name("자동차"), 2);//우승자
        Car car2 = new Car(new Name("백엔드"), 1);
        Car car3 = new Car(new Name("자바"), 0);

        List<Car> cars = List.of(car1, car2, car3);
        Race race = new Race(cars);

        assertThat(race.findWinner().get(0)).isEqualTo(car1);
    }

    @DisplayName("위치 값이 가장 큰 자동차가 우승한다.")
    @Test
    void 중복_우승() {
        Car car1 = new Car(new Name("자동차"), 2);//우승자
        Car car2 = new Car(new Name("백엔드"), 2);//우승자
        Car car3 = new Car(new Name("자바"), 0);

        List<Car> cars = List.of(car1, car2, car3);
        Race race = new Race(cars);

        assertThat(race.findWinner().size()).isEqualTo(2);
    }
}
