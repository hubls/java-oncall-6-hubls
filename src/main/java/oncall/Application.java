package oncall;

import controller.OnCallController;
import view.InputView;
import view.OutputView;

public class Application {
    public static void main(String[] args) {
        OnCallController onCallController = new OnCallController(InputView.getInstance(), OutputView.getInstance());
        onCallController.run();
    }
}
