package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Computer {
    static final int MAX_SIZE = 3;
    List<Integer> numbers = new ArrayList<>();

    public void initNumbers() {
        while (numbers.size() < MAX_SIZE) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);

            if (!numbers.contains(randomNumber)) {
                numbers.add(randomNumber);
            }
        }
    }


}
