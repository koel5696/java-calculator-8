package calculator.controller;

import calculator.domain.CustomWordSplit;
import calculator.domain.DefaultWordSplit;
import calculator.view.InputView;
import calculator.view.OutputView;

public class Controller {
    private static final int FIRST_LETTER = 0;
    private static final int CUSTOM_SETTING_LENGTH = 5;
    private static final char CUSTOM_SETTING_PREFIX = '/';

    public void run() {
        String inputWord = InputView.Input();
        int result = firstWordValidation(inputWord);
        OutputView.output(result);
    }

    public static int firstWordValidation(String inputWord) {
        if (inputWord == null || inputWord.isEmpty()) {
            throw new IllegalArgumentException();
        }

        if (inputWord.charAt(FIRST_LETTER) == CUSTOM_SETTING_PREFIX && inputWord.length() > CUSTOM_SETTING_LENGTH) {
            return CustomWordSplit.customSplitService(inputWord);
        }
        if (Character.isDigit(inputWord.charAt(FIRST_LETTER))) {
            return DefaultWordSplit.defaultSplit(inputWord);
        }

        throw new IllegalArgumentException();
    }
}

