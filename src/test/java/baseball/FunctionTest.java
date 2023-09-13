package baseball;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class FunctionTest {

    static class ComputerTest {

        @Test
        void 컴퓨터에_저장된_값이_3개인지() {
            Computer computer = new Computer();
            computer.initNumbers();

            List<Integer> computerNumbers = computer.numbers;
            assertThat(computerNumbers.size()).isEqualTo(3);
        }

        @Test
        void 컴퓨터에_저장된_값이_모두_다른지() {
            Computer computer = new Computer();
            computer.initNumbers();

            List<Integer> computerNumbers = computer.numbers;
            assertThat(isUniqueElements(List.of(1,1,2))).isEqualTo(false);
            assertThat(isUniqueElements(computerNumbers)).isEqualTo(true);

        }

        static boolean isUniqueElements(List<Integer> list) {
            int size = list.size();
            for (int i = 0; i < size; i++) {
                int gotNumber = list.get(i);
                for (int j = i+1; j < size; j++) {
                    int compareNumber = list.get(j);
                    if (gotNumber == compareNumber)
                        return false;
                }
            }
            return true;
        }
    }

}