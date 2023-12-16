package view;

import camp.nextstep.edu.missionutils.Console;
import util.validator.MonthAndDayValidator;

import java.util.List;

public class InputView {
    private static final String COMMA = ",";
    private static final InputView instance = new InputView();

    public static InputView getInstance() {
        return instance;
    }

    private InputView() {
    }

    public List<String> readMonthAndDay() {
        try {
            System.out.print(Message.INPUT_MONTH_DAY.message);
            List<String> monthAndDay = List.of(Console.readLine().split(COMMA));
            MonthAndDayValidator.checkSize(monthAndDay);
            MonthAndDayValidator.validate(monthAndDay);
            return monthAndDay;
        } catch (IllegalArgumentException exception) {
            printExceptionMessage(exception);
            return readMonthAndDay();
        }
    }

    private void printExceptionMessage(Exception exception) {
        System.out.println(exception.getMessage());
    }

    private enum Message {
        INPUT_MONTH_DAY("비상 근무를 배정할 월과 시작 요일을 입력하세요> ");

        private final String message;

        Message(String message) {
            this.message = message;
        }
    }
}
