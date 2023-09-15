package baseball;

import camp.nextstep.edu.missionutils.Console;

public class JavaBaseball {
    static final int RESTART = 1;
    static final int EXIT = 2;

    static void start() {
        System.out.println("숫자 야구 게임을 시작합니다");

        run();
    }

    static void run() {
        Computer computer = new Computer();
        computer.initNumbers();

        User user = new User();

        boolean predictSuccess = false;
        while (!predictSuccess) {
            try {
                predictSuccess = predicateNumber(computer, user);
            }
            catch (IllegalArgumentException e) {
                printTerminateMessage();
                return;
            }
        }

        int response = askRestart();
        switch (response) {
            case RESTART:
                start();
                break;
            case EXIT:
            default:
                printExitMessage();
        }
    }

    private static void printExitMessage() {
        System.out.println("게임이 종료되었습니다..");
    }

    static int askRestart() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

        int response = Integer.parseInt(Console.readLine());
        return response;
    }

    static void printTerminateMessage() {
        System.out.println("비정상적인 입력으로 프로그램이 종료되었습니다");
    }

    static boolean predicateNumber(Computer com, User user) {
        user.inputThreeNumber();
        String userInputString = user.getInputString();

        boolean isSame = com.isSameNumbers(userInputString);
        if (isSame) {
            return true;
        }

        return false;
    }
}
