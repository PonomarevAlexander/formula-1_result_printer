package ua.com.foxminded.formula.manager;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import ua.com.foxminded.formula.engine.*;

public class ReportManager {
    
    private Parser parser;
    private PrintFormatter formatter;
    private static final String FORMAT = "HH:mm:ss.SSS";
    
    public ReportManager(PrintFormatter formatter, Parser parser) {
        this.formatter = formatter;
        this.parser = parser;
    }
    
    public String getRaceReport(RaceLog log) {
        List<RaceDriver> racers = parser.getRacersList(log);
        for (RaceDriver racer : racers) {
            racer.setBestLap(
                    calculateBestLap(racer.getStartTime(), racer.getEndTime()));
        }
        return formatter.format(racers);
    }
    
    private String calculateBestLap(String startTime, String endTime) {
        DateTimeFormatter format = DateTimeFormatter.ofPattern(FORMAT);
        LocalTime start = LocalTime.parse(startTime, format);
        LocalTime end = LocalTime.parse(endTime, format);
        
        return String.format("%d:%02d.%03d",
                end.minusMinutes(start.getMinute()).getMinute(),
                end.minusSeconds(start.getSecond()).getSecond(),
                end.minusNanos(start.getNano()).getNano() / 1_000_000);
        
    }
}
