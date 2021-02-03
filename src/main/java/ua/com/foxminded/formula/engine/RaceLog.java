package ua.com.foxminded.formula.engine;

public class RaceLog {
    
    private String startLog;
    private String endLog;
    private String abbreviations;
    
    public RaceLog(String startLog, String endLog, String abbreviations) {
        this.startLog = startLog;
        this.endLog = endLog;
        this.abbreviations = abbreviations;
    }

    public String getStartLog() {
        return startLog;
    }

    public String getEndLog() {
        return endLog;
    }

    public String getAbbreviations() {
        return abbreviations;
    }

}