package calculator.view;


import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public static String Input() {
        System.out.println("덧셈할 문자열을 입력해주세요.");
        return Console.readLine();
    }
}
