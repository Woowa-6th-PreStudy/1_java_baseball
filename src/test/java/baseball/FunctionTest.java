package baseball;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;
import java.util.Scanner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

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
    } // class

    static class UserTest {

        @Test
        void 사용자_입력_테스트() {
            String input = "123";
            Scanner scanner = getMockScannerFromInput(input);

            User user = new User();
            user.inputThreeNumber();

            assertThat(user.getInputString()).isEqualTo(input);
        }
    }

    private static Scanner getMockScannerFromInput(String input) {
        InputStream in = generateUserInput(input);
        System.setIn(in);
        return new Scanner(System.in);
    }

    static InputStream generateUserInput(String input) {
        return new ByteArrayInputStream(input.getBytes());
    }
}