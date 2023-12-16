package util.validator;

import util.ExceptionMessage;

import java.util.List;
import java.util.PrimitiveIterator;

public class MonthAndDayValidator {
    private static final int MONTH = 0;
    private static final int DAY = 1;
    private static final int VALID_MONTH_DAY_SIZE = 2;

    public static void validate(List<String> monthAndDay) throws IllegalArgumentException {
        String month = monthAndDay.get(MONTH);
        String day = monthAndDay.get(DAY);
        checkMonth(month);
    }

    public static void checkSize(List<String> monthAndDay) throws IllegalArgumentException {
        if (monthAndDay.size() != VALID_MONTH_DAY_SIZE) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_VALUE.getMessage());
        }
    }

    private static void checkMonth(String month) {
        if (!month.matches("^(1[0-2]|[1-9])$")) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_VALUE.getMessage());
        }
    }
}
