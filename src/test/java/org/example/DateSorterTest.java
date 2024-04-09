package org.example;

import org.junit.Test;
import java.time.LocalDate;
import java.util.Collection;
import java.util.List;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class DateSorterTest {
    DateSorter dateSorter = new DateSorter();

    @Test
    public void sortDates_emptyInput_throwException() {
        assertThrows(IllegalArgumentException.class, () -> {
            dateSorter.sortDates(List.of());
        });
    }

    @Test
    public void sortDates_nullInput_throwException() {
        assertThrows(RuntimeException.class, () -> {
            dateSorter.sortDates(null);
        });
    }

    @Test
    public void sortDates_validInput_shouldReturnSortedDates() {
        LocalDate date1Actual = LocalDate.parse("2004-07-01");
        LocalDate date2Actual = LocalDate.parse("2005-01-02");
        LocalDate date3Actual = LocalDate.parse("2007-01-01");
        LocalDate date4Actual = LocalDate.parse("2032-05-03");
        List<LocalDate> input = List.of(date1Actual, date2Actual, date3Actual, date4Actual);

        LocalDate date1Expected = LocalDate.parse("2005-01-02");
        LocalDate date2Expected = LocalDate.parse("2007-01-01");
        LocalDate date3Expected = LocalDate.parse("2032-05-03");
        LocalDate date4Expected = LocalDate.parse("2004-07-01");
        Collection<LocalDate> expected = List.of(date1Expected, date2Expected, date3Expected, date4Expected);

        Collection<LocalDate> actual = dateSorter.sortDates(input);

        assertEquals(expected, actual);
    }

}