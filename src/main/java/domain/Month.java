package domain;

public enum Month {
    JANUARY("1", 31),
    FEBRUARY("2", 28),
    MARCH("3", 31),
    APRIL("4", 30),
    MAY("5", 31),
    JUNE("6", 30),
    JULY("7", 31),
    AUGUST("8", 31),
    SEPTEMBER("9", 30),
    OCTOBER("10", 31),
    NOVEMBER("11", 30),
    DECEMBER("12", 31);

    private final String name;
    private final int days;

    Month(String name, int days) {
        this.name = name;
        this.days = days;
    }

    public String getName() {
        return name;
    }

    public int getDays() {
        return days;
    }

    public static int getDaysForMonth(String monthName) {
        for (Month month : Month.values()) {
            if (month.getName().equals(monthName)) {
                return month.getDays();
            }
        }
        return -1;
    }
}
