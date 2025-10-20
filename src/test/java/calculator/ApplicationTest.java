package calculator;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

class ApplicationTest extends NsTest {
    @Test
    void 커스텀_구분자_사용() {
        assertSimpleTest(() -> {
            run("//;\\n1");
            assertThat(output()).contains("결과 : 1");
        });
    }

    @Test
    void 커스텀_구분자_사용_띄어쓰기() {
        assertSimpleTest(() -> {
            run("// \\n1 2:3");
            assertThat(output()).contains("결과 : 6");
        });
    }

    @Test
    void 커스텀_구분자_사용_예외() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("//^\\n1^2&3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 오버플로우_예외() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("//^\\n2147483647^10"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 숫자_구분자_예외() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("//8\\n18283"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("-1,2,3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
