package org.example;

import java.time.LocalDate;
import java.util.*;

/**
 * Marking will be based upon producing a readable, well engineered solution rather than factors
 * such as speed of processing or other performance-based optimizations, which are less
 * important.
 * <p>
 * Implement in single class. Don't chane constructor and signature method.
 */
public class DateSorter {

    /**
     * The implementation of this method should sort dates.
     * The output should be in the following order:
     * Dates with an 'r' in the month,
     * sorted ascending (first to last),
     * then dates without an 'r' in the month,
     * sorted descending (last to first).
     * For example, October dates would come before May dates,
     * because October has an 'r' in it.
     * thus: (2004-07-01, 2005-01-02, 2007-01-01, 2032-05-03)
     * would sort to
     * (2005-01-02, 2007-01-01, 2032-05-03, 2004-07-01)
     *
     * @param unsortedDates - an unsorted list of dates
     * @return the collection of dates now sorted as per the spec
     */
    public Collection<LocalDate> sortDates(List<LocalDate> unsortedDates) {
        if (unsortedDates.isEmpty()) {
            throw new IllegalArgumentException("Input can't be empty");
        }
        List<LocalDate> datesWithR = new LinkedList<>();
        List<LocalDate> datesWithOutR = new LinkedList<>();

        divideDates(unsortedDates, datesWithR, datesWithOutR);

        Collections.sort(datesWithR);
        datesWithOutR.sort(Collections.reverseOrder());

        return mergeSortedDates(datesWithR, datesWithOutR);
    }

    private void divideDates(List<LocalDate> unsortedDates,
                             List<LocalDate> datesWithR,
                             List<LocalDate> datesWithoutR) {
        for (LocalDate date : unsortedDates) {
            if (date.getMonth().toString().toLowerCase().contains("r")) {
                datesWithR.add(date);
            } else {
                datesWithoutR.add(date);
            }
        }
    }

    private List<LocalDate> mergeSortedDates(List<LocalDate> datesWithR,
                                             List<LocalDate> datesWithoutR) {
        datesWithR.addAll(datesWithoutR);
        return datesWithR;
    }
}