package calculator.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

public class CustomWordSplitTest {

    @Test
    void 커스텀_분류_성공() {
        SplitService splitService = new CustomWordSplit();
        String inputWord = "//&\\n1&2,3";
        assertThat(splitService.split(inputWord)).contains("1", "2", "3");
    }

    @Test
    void 커스텀_분류_실패() {
        SplitService splitService = new CustomWordSplit();
        String inputWord = "/&\\n1&2,3";
        assertThatThrownBy(() -> splitService.split(inputWord))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("커스텀 구분자는 숫자가 아닌 문자(공백 포함) 1개를 문자열 처음 \"//\"와 \"\\n\" 사이에 지정해야 합니다.");
    }
}
