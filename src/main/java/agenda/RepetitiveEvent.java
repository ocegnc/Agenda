package agenda;

import java.util.*;
import java.time.*;
import java.time.temporal.ChronoUnit;

/**
 * Description : A repetitive Event
 */
public class RepetitiveEvent extends Event {
    /**
     * Constructs a repetitive event
     *
     * @param title the title of this event
     * @param start the start of this event
     * @param duration myDuration in seconds
     * @param frequency one of :
     * <UL>
     * <LI>ChronoUnit.DAYS for daily repetitions</LI>
     * <LI>ChronoUnit.WEEKS for weekly repetitions</LI>
     * <LI>ChronoUnit.MONTHS for monthly repetitions</LI>
     * </UL>
     */
    private ChronoUnit frequency;
    private List<LocalDate> exceptionDate;
    public RepetitiveEvent(String title, LocalDateTime start, Duration duration, ChronoUnit frequency) {
        super(title, start, duration);
        this.frequency=frequency;
        exceptionDate = new ArrayList<>();
    }

    /**
     * Adds an exception to the occurrence of this repetitive event
     *
     * @param date the event will not occur at this date
     */
    public void addException(LocalDate date) {
        exceptionDate.add(date);
    }

    /**
     *
     * @return the type of repetition
     */
    public ChronoUnit getFrequency() {
        return frequency;
    }

    @Override
    public boolean isInDay(LocalDate aDay) {
        if (super.isInDay(aDay)) {
            return true;
        }
        for (LocalDate date : exceptionDate) {
            if (aDay.isEqual(date)) {
                return false;
            }
        }
        int year = myStart.getYear();
        int month = myStart.getMonthValue();
        int day = myStart.getDayOfMonth();

        while (aDay.isAfter(LocalDate.of(year, month, day))) {
            if (super.isInDay(LocalDate.of(year, month, day))) {
                return true;
            }else{
                if(ChronoUnit.DAYS==frequency){
                    day+=1;
                }
                if(ChronoUnit.WEEKS==frequency){
                    day+=7;
                }
                if(ChronoUnit.MONTHS==frequency){
                    month+=1;
                }
            }
        }
        return false;
    }
}
