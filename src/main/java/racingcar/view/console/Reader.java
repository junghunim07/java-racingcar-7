package racingcar.view.console;

import camp.nextstep.edu.missionutils.Console;

public class Reader {

    public static String read() {
        return Console.readLine();
    }

    private static String validate(String input) {
        if (isBlank(input)) {
            throw new IllegalArgumentException("입력을 해주세요.");
        }
        return input;
    }

    private static boolean isBlank(String input) {
        return input.isBlank();
    }
}
