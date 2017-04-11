package com.kaitait.droidtemplate.app.util;

import org.joda.time.DateTime;
import org.junit.Test;

import java.util.Date;

import static com.kaitait.droidtemplate.app.util.DateUtils.dateToDayDateString;
import static com.kaitait.droidtemplate.app.util.DateUtils.epocSecondsToDate;
import static com.kaitait.droidtemplate.app.util.DateUtils.epocSecondsToDisplayDateTimeString;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Created by kai-tait on 11/04/2017.
 */
public class DateUtilsTest
{
    @Test
    public void epocSecondsToDate_returnsCorrectDate() throws Exception {
        long epoc = 1491867404; //11th April 2017
        Date date = epocSecondsToDate(epoc);
        assertThat(epoc * 1000, is(date.getTime()));
        String day = dateToDayDateString(date, true);
        assertThat("TUE", is(day));
    }
    
    @Test
    public void format_returnsCorrectString() {
        String dateFormatted = DateUtils.format(new DateTime(2017, 4, 11, 9, 33, 11));
        assertThat(dateFormatted,is("2017-04-11 09:33:11"));
    }
    
    @Test
    public void dateToDayDateString_returnsCorrectString() throws Exception
    {
        Date date = epocSecondsToDate(1491867404L);
        String shortDateString = dateToDayDateString(date, true);
        String longDateString = dateToDayDateString(date, false);
        assertThat(shortDateString, is("TUE"));
        assertThat(longDateString, is("TUESDAY, 11 APRIL 2017"));
    }
    
    @Test
    public void epocSecondsToDisplayDateTimeString_returnsValidString() throws Exception
    {
        Long epoch = 1491867404L;
        String displayString = epocSecondsToDisplayDateTimeString(epoch);
        assertThat(displayString, is("TUESDAY, 11 APRIL 2017"));
    }
    
}