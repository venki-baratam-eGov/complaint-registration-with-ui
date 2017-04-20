package org.complaint.persistence.util;

import org.joda.time.LocalDate;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.springframework.stereotype.Service;

import static org.apache.commons.lang3.RandomStringUtils.randomAlphabetic;
import static org.apache.commons.lang3.StringUtils.upperCase;

@Service
public class Utils {

    private final DateTimeFormatter FORMAT_DATE_TO_YEAR = DateTimeFormat.forPattern("yyyy");

    public String currentDateToYearFormat() {
        return toYearFormat(new LocalDate());
    }

    public String getRandomAlphabets() {
        return upperCase(randomAlphabetic(2));
    }

    private String toYearFormat(final LocalDate date) {
        return FORMAT_DATE_TO_YEAR.print(date);
    }
}
