package io.oigres.ecomm.bff.admin.usecases.utils;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;

public class TimeConverter {
    private TimeConverter() {
        throw new AssertionError();
    }

    public static long localDateTimeIntoEpoch(LocalDateTime time) {
        Instant instant = time.atZone(ZoneId.systemDefault()).toInstant();
        return instant.toEpochMilli();
    }

}