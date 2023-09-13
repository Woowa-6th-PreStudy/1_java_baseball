package baseball;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

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
            /*
            테스트 코드에서 User.inputThreeNumber()를 호출하여
            Console.readLine()을 실행시키면 무한루프에 빠짐
            적절한 해결법이 필요한데 잘 모르겠음
            */

        }
    }


}