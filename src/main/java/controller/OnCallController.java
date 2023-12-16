package controller;

import view.InputView;
import view.OutputView;

import java.util.List;

public class OnCallController {
    private final InputView inputView;
    private final OutputView outputView;

    public OnCallController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        List<String> monthAndDay = inputView.readMonthAndDay();
        List<String> weekdayWorker = inputView.readWeekdayWorker();
    }
}
