package baseball;

import camp.nextstep.edu.missionutils.Console;

public class User {
    private String inputString = "";

    public void inputThreeNumber() {
        String input = Console.readLine();
        this.inputString = input;
    }

}
