package baseball;

import camp.nextstep.edu.missionutils.Console;

public class User {
    private String inputString = "";

    // 테스트 용도
    public String getInputString() {
        return inputString;
    }

    public void inputThreeNumber() {
        String input = Console.readLine();

        if (isInvalidInputString(input)) {
            throw new IllegalArgumentException();
        }

        this.inputString = input;
    }

    boolean isInvalidInputString(String inputString) {
        if (inputString.length() != 3)
            return true;

        for (int i = 0; i < inputString.length(); i++) {
            char letter = inputString.charAt(i);
            if (!Character.isDigit(letter))
                return true;
        }

        return false;
    }

}
