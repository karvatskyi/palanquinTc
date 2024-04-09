package org.example;

import java.time.LocalDate;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        DateSorter dateSorter = new DateSorter();

        LocalDate date1 = LocalDate.parse("2004-07-01");
        LocalDate date2 = LocalDate.parse("2005-01-02");
        LocalDate date3 = LocalDate.parse("2007-01-01");
        LocalDate date4 = LocalDate.parse("2032-05-03");

        List<LocalDate> list = List.of(date1, date2, date3, date4);

        System.out.println(dateSorter.sortDates(list));
        System.out.println(date1.getMonth().toString());

    }
}