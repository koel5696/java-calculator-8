package calculator.controller;

import calculator.domain.CalculatorService;
import calculator.domain.SplitService;
import calculator.view.InputView;
import calculator.view.OutputView;

public class Controller {

    public void run() {
        String inputWord = InputView.Input();
        CalculatorService calculatorService = new CalculatorService(inputWord);
        SplitService splitService = calculatorService.selectCustomOrDefault();
        int result = calculatorService.numberValidService(splitService.split(inputWord));
        OutputView.output(result);
    }
}

