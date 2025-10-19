package calculator.controller;


public class Controller {

    public void run() {
        String inputWord = InputView.Input();
        int result = firstWordValidation(inputWord);
        OutputView.output(result);
    }

}

