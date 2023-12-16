package domain;

import java.util.*;

public class WorkSchedule {
    private final List<String> onCallSchedule = new ArrayList<>();
    private final List<String> workers = new ArrayList<>();

    public void createSchedule(String month, String startDay, List<String> weekdayWorkers, List<String> holidayWorkers) {
        int daysInMonth = Month.getDaysForMonth(month);
        int weekdayWorkerIndex = 0;
        int holidayWorkerIndex = 0;

        for (int day = 1; day <= daysInMonth; day++) {
            String worker;
            String dayOfWeek = getDayOfWeek(day - 1, startDay); // -1을 사용하여 배열 인덱스를 맞춤

            if (isWeekend(dayOfWeek)) {
                worker = holidayWorkers.get(holidayWorkerIndex);
                holidayWorkerIndex = (holidayWorkerIndex + 1) % holidayWorkers.size();
            }
            worker = weekdayWorkers.get(weekdayWorkerIndex);
            weekdayWorkerIndex = (weekdayWorkerIndex + 1) % weekdayWorkers.size();

            dayOfWeek = getHolidayOfWeek(dayOfWeek, month, day);
            onCallSchedule.add(String.format("%s월 %d일 %s %s", month, day, dayOfWeek, worker));
        }
    }

    public List<String> getOnCallSchedule() {
        return onCallSchedule;
    }

    private String getHolidayOfWeek(String dayOfWeek, String month, int day) {
        Set<String> holidays = new HashSet<>(Arrays.asList(
                "1월 1일", "3월 1일", "5월 5일", "6월 6일", "8월 15일", "10월 3일", "10월 9일", "12월 25일"
        ));

        String date = String.format("%s월 %d일", month, day);

        if (holidays.contains(date)) {
            return dayOfWeek+ "(휴일)";
        }

        return dayOfWeek;
    }

    private boolean isWeekend(String dayOfWeek) {
        return dayOfWeek.equals("토") || dayOfWeek.equals("일");
    }

    private String getDayOfWeek(int day, String startDay) {
        List<String> daysOfWeek = new ArrayList<>(Arrays.asList("월", "화", "수", "목", "금", "토", "일"));

        // 시작 요일을 배열의 첫 번째 요소로 설정
        while (!daysOfWeek.get(0).equals(startDay)) {
            daysOfWeek.add(daysOfWeek.remove(0));
        }

        return daysOfWeek.get(day % 7);
    }
}
