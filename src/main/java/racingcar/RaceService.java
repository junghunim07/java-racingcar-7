package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import racingcar.dto.RaceResult;
import racingcar.dto.RaceResults;

public class RaceService {

    public RaceResults process(Cars cars, int count) {
        List<RaceResult> raceResults = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            raceResults.add(processEach(cars));
        }
        return new RaceResults(raceResults);
    }

    private RaceResult processEach(Cars cars) {
        for (Car car : cars.getCars()) {
            car.move(generateRandomValue());
        }
        return new RaceResult(cars);
    }

    private int generateRandomValue() {
        return Randoms.pickNumberInRange(0, 9);
    }
}
