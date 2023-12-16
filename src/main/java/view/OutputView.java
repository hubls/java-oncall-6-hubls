package view;

import java.util.List;

public class OutputView {
    private static final OutputView instance = new OutputView();

    public static OutputView getInstance() {
        return instance;
    }

    public void printSchedule(List<String> schedule) {
        for (String worker : schedule) {
            System.out.println(worker);
        }
    }
}
