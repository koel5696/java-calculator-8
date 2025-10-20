package calculator.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

public class DefaultWordSplitTest {

    @Test
    void 기본_분류_성공() {
        SplitService splitService = new DefaultWordSplit();
        String inputWord = "1,2:3";

        assertThat(splitService.split(inputWord)).contains("1", "2", "3");
    }

    @Test
    void 기본_분류_실패() {
        String inputWord = "1,2@3";
        SplitService splitService = new DefaultWordSplit();
        CalculatorService calculatorService = new CalculatorService(inputWord);

        assertThatThrownBy(() -> calculatorService.numberValidService(splitService.split(inputWord)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("잘못된 문자(숫자) 입력: 0 혹은 양의 정수만 가능합니다.");
    }
}
