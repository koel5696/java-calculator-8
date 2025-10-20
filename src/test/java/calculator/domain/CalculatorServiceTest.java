package calculator.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CalculatorServiceTest {

    @Test
    void 빈_입력_실패() {
        assertThatThrownBy(() -> new CalculatorService(""))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("빈 값은 허용되지 않습니다.");
    }

    @Test
    void 커스텀_분리_호출() {
        CalculatorService calculatorService = new CalculatorService("//&\n1");

        assertThat(calculatorService.selectCustomOrDefault())
                .isInstanceOf(CustomWordSplit.class);

    }

    @Test
    void 기본_분리_호출() {
        CalculatorService calculatorService = new CalculatorService("1,2,3");

        assertThat(calculatorService.selectCustomOrDefault())
                .isInstanceOf(DefaultWordSplit.class);

    }

    @Test
    void 숫자_검증_실패() {
        String[] numbers = {"a", "2", "3"};

        assertThatThrownBy(() -> {
            for (String number : numbers) {
                new PositiveNumber(number);
            }
        })
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("0 혹은 양의 정수만 가능합니다.");
    }

    @Test
    void 정상입력_덧셈_성공() {

        String inputWord = "1,2,3";
        CalculatorService service = new CalculatorService(inputWord);
        SplitService numbers = service.selectCustomOrDefault();
        int result = service.numberValidService(numbers.split(inputWord));
        // then
        assertThat(result).isEqualTo(6);
    }

    @Test
    @DisplayName("커스텀 구분자와 기본 구분자의 혼용입력")
    void 정상입력_커스텀_기본_혼용() {

        String inputWord = "//%\\n1%2,3:5";
        CalculatorService service = new CalculatorService(inputWord);
        SplitService numbers = service.selectCustomOrDefault();
        int result = service.numberValidService(numbers.split(inputWord));

        assertThat(result).isEqualTo(11);
    }

    @Test
    @DisplayName("커스텀 구분자와 기본 구분자의 혼용입력")
    void 오입력_합산_실패() {

        String inputWord = "//^\\n1%2,3:5";
        CalculatorService service = new CalculatorService(inputWord);
        SplitService numbers = service.selectCustomOrDefault();

        assertThatThrownBy(() -> service.numberValidService(numbers.split(inputWord)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("잘못된 문자(숫자) 입력: 0 혹은 양의 정수만 가능합니다.");
    }

}
