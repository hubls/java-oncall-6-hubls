package util.validator;

import util.ExceptionMessage;

import java.util.List;

public class WorkerValidator {
    private static int MIN_WORKER_NUMBER = 5;
    private static int MAX_WORKER_NUMBER = 35;

    public static void checkSize(List<String> worker) throws IllegalArgumentException {
        if (worker.size() < MIN_WORKER_NUMBER || worker.size() > MAX_WORKER_NUMBER) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_VALUE.getMessage());
        }
    }
}
