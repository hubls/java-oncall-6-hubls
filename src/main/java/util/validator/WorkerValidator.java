package util.validator;

import util.ExceptionMessage;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WorkerValidator {
    private static int MIN_WORKER_NUMBER = 5;
    private static int MAX_WORKER_NUMBER = 35;
    private static int MIN_NICKNAME_SIZE = 1;
    private static int MAX_NICKNAME_SIZE = 5;

    public static void checkNickName(String nickName) throws IllegalArgumentException {
        if (nickName.isBlank()) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_VALUE.getMessage());
        }

        if (nickName.length() < MIN_NICKNAME_SIZE || nickName.length() > MAX_NICKNAME_SIZE) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_VALUE.getMessage());
        }
    }

    public static void checkSize(List<String> worker) throws IllegalArgumentException {
        if (worker.size() < MIN_WORKER_NUMBER || worker.size() > MAX_WORKER_NUMBER) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_VALUE.getMessage());
        }
    }

    public static void checkDuplicateNickName(List<String> worker) throws IllegalArgumentException {
        Set<String> uniqueNames = new HashSet<>(worker);

        if (uniqueNames.size() != worker.size()) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_VALUE.getMessage());
        }
    }

    public static void checkWeekdayHolidayWorker(List<String> weekdayWorker, List<String> holidayWorker) {
        Set<String> weekdayWorkerAsSet = new HashSet<>(weekdayWorker);
        Set<String> holidayWorkerAsSet = new HashSet<>(holidayWorker);

        if (!weekdayWorkerAsSet.equals(holidayWorkerAsSet)) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_VALUE.getMessage());
        }
    }
}
