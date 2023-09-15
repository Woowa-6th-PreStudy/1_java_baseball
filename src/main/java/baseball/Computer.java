package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Computer {
    static final int MAX_SIZE = 3;
    List<Integer> numbers = new ArrayList<>();

    // 테스트 용도
    private List<Integer> getNumbers() {
        return numbers;
    }

    public void initNumbers() {
        while (numbers.size() < MAX_SIZE) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);

            if (!numbers.contains(randomNumber)) {
                numbers.add(randomNumber);
            }
        }
    }

    public boolean isSameNumbers(String inputNumbers) {
        int strike = getStrike(inputNumbers);
        if (strike == 3) {
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            return true;
        }

        int sameCnt = countSameNumber(inputNumbers);
        int ball = sameCnt - strike;

        if (ball != 0) {
            System.out.print(ball + "볼");
        }
        if (strike != 0) {
            System.out.print(strike + "스트라이크");
        }
        System.out.println();

        return false;
    }

    int countSameNumber(String inputNumbers) {
        int cnt = 0;
        for (int i = 0; i < inputNumbers.length(); i++) {
            int inputNum = inputNumbers.charAt(i) - '0';
            if (this.numbers.contains(inputNum))
                cnt++;
        }

        return cnt;
    }

    int getStrike(String numbers) {
        int cnt = 0;
        for (int i = 0; i < numbers.length(); i++) {
            int inputNum = numbers.charAt(i) - '0';
            int computerNum = this.numbers.get(i);

            if (computerNum == inputNum) {
                cnt++;
            }
        }

        return cnt;
    }
}
