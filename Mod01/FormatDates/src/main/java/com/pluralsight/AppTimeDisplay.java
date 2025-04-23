package com.pluralsight;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.ZonedDateTime;
import java.time.ZoneId;

public class AppTimeDisplay {
    public static void main(String[] args) {
        LocalDateTime now = LocalDateTime.now();
// now() returns the current date and time
        dateFormat1(now);
        dateFormat2(now);
        dateFormat3(now);
        dateFormat4(now);
        dateFormat5(now);
        dateFormat6(now);
    }


// displays the date in MM-dd-yyyy
    static void dateFormat1(LocalDateTime now) {
        DateTimeFormatter format1 = DateTimeFormatter.ofPattern("MM-dd-yyyy");
        System.out.println(now.format(format1));
    }

// displays the date in yyyy/MM/dd format.
    static void dateFormat2(LocalDateTime now) {
        DateTimeFormatter format2 = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        System.out.println(now.format(format2));
    }

// displays the date in a long month format: "Month, day, year".
    static void dateFormat3(LocalDateTime now) {
        DateTimeFormatter format3 = DateTimeFormatter.ofPattern("MMMM, dd, yyyy");
        System.out.println(now.format(format3));
    }

// displays the date including day of the week
    static void dateFormat4(LocalDateTime time) {
        DateTimeFormatter format4 = DateTimeFormatter.ofPattern("E, MMM dd, yyyy");
        System.out.println(time.format(format4));
    }

// displays the current time in 24-hour format in GMT time zone.
    static void dateFormat5(LocalDateTime now) {
        ZonedDateTime gmtTime = ZonedDateTime.now(ZoneId.of("GMT"));
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm 'GMT'");
        System.out.println(gmtTime.format(formatter));
    }

//  displays the time and date in local time zone with readable format
    static void dateFormat6(LocalDateTime now) {
        DateTimeFormatter format6 = DateTimeFormatter.ofPattern("H:mm 'on' dd MMM yyyy");
        System.out.println(format6.format(now) + " - display in your local time zone");
    }
}
