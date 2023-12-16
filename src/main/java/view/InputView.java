package view;

import camp.nextstep.edu.missionutils.Console;
import util.validator.MonthAndDayValidator;
import util.validator.WorkerValidator;

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

    public List<String> readWeekdayWorker() {
        try {
            System.out.print(Message.INPUT_WEEKDAY_WORKER.message);
            List<String> weekdayWorker = List.of(Console.readLine().split(COMMA));
            WorkerValidator.checkSize(weekdayWorker);
            weekdayWorker.forEach(nickName -> WorkerValidator.checkNickName(nickName));
            WorkerValidator.checkDuplicateNickName(weekdayWorker);
            return weekdayWorker;
        } catch (IllegalArgumentException exception) {
            printExceptionMessage(exception);
            return readWeekdayWorker();
        }
    }

    public List<String> readHolidayWorker() {
        try {
            System.out.print(Message.INPUT_HOLIDAY_WORKER.message);
            List<String> holidayWorker = List.of(Console.readLine().split(COMMA));
            WorkerValidator.checkSize(holidayWorker);
            holidayWorker.forEach(nickName -> WorkerValidator.checkNickName(nickName));
            WorkerValidator.checkDuplicateNickName(holidayWorker);
            return holidayWorker;
        } catch (IllegalArgumentException exception) {
            printExceptionMessage(exception);
            return readWeekdayWorker();
        }
    }

    private void printExceptionMessage(Exception exception) {
        System.out.println(exception.getMessage());
    }

    private enum Message {
        INPUT_MONTH_DAY("비상 근무를 배정할 월과 시작 요일을 입력하세요> "),
        INPUT_WEEKDAY_WORKER("평일 비상 근무 순번대로 사원 닉네임을 입력하세요> "),
        INPUT_HOLIDAY_WORKER("휴일 비상 근무 순번대로 사원 닉네임을 입력하세요> ");


        private final String message;

        Message(String message) {
            this.message = message;
        }
    }
}
