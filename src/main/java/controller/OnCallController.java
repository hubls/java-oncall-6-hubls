package controller;

import util.validator.WorkerValidator;
import view.InputView;
import view.OutputView;

import java.util.List;

public class OnCallController {
    private final InputView inputView;
    private final OutputView outputView;
    private List<String> weekdayWorker;
    private List<String> holidayWorker;

    public OnCallController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        List<String> monthAndDay = inputView.readMonthAndDay();
        readWorker();
    }

    private void readWorker() {
        try {
            weekdayWorker = inputView.readWeekdayWorker();
            holidayWorker = inputView.readHolidayWorker();
            WorkerValidator.checkWeekdayHolidayWorker(weekdayWorker, holidayWorker);
        } catch (Exception exception) {
            inputView.printExceptionMessage(exception);
            readWorker();
        }
    }
}
