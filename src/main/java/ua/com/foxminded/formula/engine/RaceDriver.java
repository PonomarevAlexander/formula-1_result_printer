package ua.com.foxminded.formula.engine;

public class RaceDriver {
    
    private String fullName;
    private String raceTeam;
    private String bestLap;
    private String startTime;
    private String endTime;
    private String abbreviation;
    
    public RaceDriver(String abbreviation, String fullName, String raceTeam) {
        this.abbreviation = abbreviation;
        this.fullName = fullName;
        this.raceTeam = raceTeam;
    }
    
    public String getFullName() {
        return fullName;
    }
    
    public String getRaceTeam() {
        return raceTeam;
    }
    
    public void setBestLap(String bestLap) {
        this.bestLap = bestLap;
    }
    
    public String getBestLap() {
        return bestLap;
    }
    public String getAbbreviation() {
        return abbreviation;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }
}