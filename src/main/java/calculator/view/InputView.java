package calculator.view;


import static calculator.constants.OutPutMessage.INPUT_STRING;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public static String Input() {
        System.out.println(INPUT_STRING.getMessage());
        return Console.readLine();
    }
}
