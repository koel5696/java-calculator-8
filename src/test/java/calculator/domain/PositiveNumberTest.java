package calculator.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

public class PositiveNumberTest {

    @Test
    void 일반_숫자_객체_생성() {
        String number = "500";
        PositiveNumber positiveNumber = new PositiveNumber(number);
        assertThat(positiveNumber).isNotNull();
    }

    @Test
    void 문자_입력_객체_생성_실패() {
        assertThatThrownBy(() -> new PositiveNumber("a"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("0 혹은 양의 정수만 가능합니다.");
    }

    @Test
    void 빈값_객체_생성_실패() {
        assertThatThrownBy(() -> new PositiveNumber(""))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("빈 값은 허용되지 않습니다.");
    }

    @Test
    void 숫자0으로_시작_객체_생성_실패() {
        String number = "015";

        assertThatThrownBy(() -> new PositiveNumber(number))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(number + "와 같은 숫자 형식은 올바르지 않습니다.");
    }

    @Test
    void 오버플로우_객체_생성_실패() {
        String overflow = String.valueOf((long) Integer.MAX_VALUE + 1);

        assertThatThrownBy(() -> new PositiveNumber(overflow))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("숫자의 허용 범위를 초과했습니다.");
    }

    @Test
    void 덧셈_오버플로우_계산_실패() {
        PositiveNumber positiveNumber = new PositiveNumber("5");
        int currentNumber = Integer.MAX_VALUE - 1;
        assertThatThrownBy(() -> positiveNumber.sum(currentNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("숫자의 허용 범위를 초과했습니다.");
    }
}
