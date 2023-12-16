package controller;

import domain.WorkSchedule;
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
        WorkSchedule workSchedule = new WorkSchedule();
        List<String> schedule = workSchedule.createSchedule(monthAndDay.get(0), monthAndDay.get(1), weekdayWorker, holidayWorker);
        outputView.printSchedule(schedule);
    }

    private void readWorker() {
        try {
            weekdayWorker = inputView.readWeekdayWorker();
            holidayWorker = inputView.readHolidayWorker();
            WorkerValidator.checkWeekdayHolidayWorker(weekdayWorker, holidayWorker);
            System.out.println();
        } catch (Exception exception) {
            inputView.printExceptionMessage(exception);
            readWorker();
        }
    }
}
