package calculator.view;

import static calculator.constants.OutPutMessage.SUM_RESULT;

public class OutputView {

    public static void output(int result) {
        System.out.println(SUM_RESULT.getMessage() + result);
    }
}
