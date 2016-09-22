package com.swingtech.common.core.util;

import org.joda.time.DateTimeZone;
import org.joda.time.Duration;
import org.joda.time.LocalDateTime;
import org.joda.time.format.PeriodFormatter;
import org.joda.time.format.PeriodFormatterBuilder;

public class Timer {
    LocalDateTime startTime = null;
    LocalDateTime endTime = null;
    long durationMilis;
    String durationString;

    public long getDurationMilis() {
        return durationMilis;
    }
    
    public static Timer getTimer() {
    	return new Timer();
    }

    public void setDurationMilis(long durationMilis) {
        this.durationMilis = durationMilis;
    }

    public String getDurationString() {
        return durationString;
    }

    public void setDurationString(String durationString) {
        this.durationString = durationString;
    }

    public void startTiming() {
        startTime = new LocalDateTime();
    }

    public void stopTiming() {
        endTime = new LocalDateTime();

        Duration duration = new Duration(startTime.toDateTime(DateTimeZone.UTC), endTime.toDateTime(DateTimeZone.UTC));

        durationMilis = duration.getMillis();
        durationString = this.formatDuration(duration);
    }

    public String formatDuration(Duration duration) {
        PeriodFormatter formatter = new PeriodFormatterBuilder().appendDays().appendSuffix(" days,").appendHours()
                .appendSuffix(" hours,").appendMinutes().appendSuffix(" minutes, ").appendSeconds()
                .appendSuffix(" seconds").appendMillis().appendSuffix(" mili").toFormatter();
        String formatted = formatter.print(duration.toPeriod());

        return formatted;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }
}
