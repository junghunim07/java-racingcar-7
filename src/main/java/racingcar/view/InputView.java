package racingcar.view;

import java.util.List;
import racingcar.Car;
import racingcar.Cars;
import racingcar.Name;
import racingcar.view.console.Reader;
import racingcar.view.console.Writer;

public class InputView {

    private static final String QUESTION_INPUT_NAME = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String QUESTION_TRY_COUNT = "시도할 회수는 몇회인가요?";
    private static final String NAME_SEPARATOR = ",";

    public Cars readCars() {
        Writer.println(QUESTION_INPUT_NAME);
        return new Cars(validateCars(Reader.read()));
    }

    public int readCount() {
        Writer.println(QUESTION_TRY_COUNT);
        return validateCount(Reader.read());
    }

    private static List<Car> validateCars(String input) {
        List<String> names = validateSeparator(input, NAME_SEPARATOR);
        return names.stream()
                .map(Name::new)
                .map(Car::new)
                .toList();
    }

    private static int validateCount(String input) {
        if (isNotNumeric(input)) {
            throw new IllegalArgumentException("숫자만 입력 가능 합니다.");
        }
        return Integer.parseInt(input);
    }

    private static boolean isNotNumeric(String input) {
        return !input.matches("\\d+");
    }

    private static List<String> validateSeparator(String input, String separator) {
        validateEdgeSeparator(input, separator);
        validateContinuousSeparator(input, separator);
        return List.of(input.split(separator));
    }

    private static void validateContinuousSeparator(String input, String separator) {
        if (hasContinuous(input, separator)) {
            throw new IllegalArgumentException("잘못된 입력 형식입니다.");
        }
    }

    private static boolean hasContinuous(String input, String separator) {
        return input.matches(separator.repeat(2));
    }

    private static void validateEdgeSeparator(String input, String separator) {
        if (hasEdgeSeparator(input, separator)) {
            throw new IllegalArgumentException("잘못된 입력 형식입니다.");
        }
    }

    private static boolean hasEdgeSeparator(String input, String separator) {
        return input.startsWith(separator) || input.endsWith(separator);
    }
}
