package calculator.controller;

import static calculator.constants.ErrorMessage.INPUT_STRING_ERROR;

import calculator.domain.CustomWordSplit;
import calculator.domain.DefaultWordSplit;
import calculator.domain.NumberValidation;
import calculator.view.InputView;
import calculator.view.OutputView;

public class Controller {
    private static final int FIRST_LETTER = 0;
    private static final int CUSTOM_SETTING_LENGTH = 5;
    private static final int NEGATIVE_NUMBER = -1;
    private static final char CUSTOM_SETTING_PREFIX = '/';
    private static final char MINUS = '-';

    public void run() {
        String inputWord = InputView.Input();
        int result = selectCustomOrDefault(inputWord);
        OutputView.output(result);
    }

    private static int selectCustomOrDefault(String inputWord) {
        if (inputWord == null || inputWord.isEmpty()) {
            throw new IllegalArgumentException();
        }

        if (inputWord.charAt(FIRST_LETTER) == CUSTOM_SETTING_PREFIX && inputWord.length() > CUSTOM_SETTING_LENGTH) {
            return CustomWordSplit.customSplitService(inputWord);
        }

        if (Character.isDigit(inputWord.charAt(FIRST_LETTER))) {
            return DefaultWordSplit.defaultSplit(inputWord);
        }

        if (inputWord.charAt(FIRST_LETTER) == MINUS) {
            NumberValidation.negativeValidation(NEGATIVE_NUMBER);
        }

        throw new IllegalArgumentException(INPUT_STRING_ERROR.getMessage());
    }
}

