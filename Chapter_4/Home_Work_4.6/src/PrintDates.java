import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Locale;

public class PrintDates {

    public static  LocalDate BIRTHDAY;

    public static void main(String[] args) {


        BIRTHDAY = LocalDate.of(1988, 3, 9);
        LocalDate todayDate = LocalDate.now();
        String date = BIRTHDAY.toString();
        int userAge = todayDate.getYear() - BIRTHDAY.getYear();
        LocalDate now;
        for (int day = 0; day < userAge + 1; day++){
            now = BIRTHDAY;
            System.out.println(
                    day + "\t- " +
                            BIRTHDAY.getDayOfMonth() + "." +
                            BIRTHDAY.getMonthValue() + "." +
                            BIRTHDAY.getYear() + " - " +
                            BIRTHDAY.getDayOfWeek() + " - " +
                            now.format(DateTimeFormatter.ofPattern("EEEE", Locale.forLanguageTag("RU")))
            );
            BIRTHDAY = BIRTHDAY.plus(1, ChronoUnit.YEARS);
        }
    }
}
