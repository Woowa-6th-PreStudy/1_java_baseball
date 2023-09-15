package baseball;

public class JavaBaseball {
    public void start() {
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
