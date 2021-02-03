package ua.com.foxminded.formula.manager;

import ua.com.foxminded.formula.engine.Parser;
import ua.com.foxminded.formula.engine.PrintFormatter;
import ua.com.foxminded.formula.engine.RaceLog;

public class Main {
    
    private static final String ABBR = "src\\main\\resources\\abbreviations.txt";
    private static final String START_LOG = "src\\main\\resources\\start.log";
    private static final String END_LOG = "src\\main\\resources\\end.log";

    public static void main(String[] args) {
        
        RaceLog raceLog = new RaceLog(START_LOG, END_LOG, ABBR);
        ReportManager manager = new ReportManager(new PrintFormatter(), new Parser());
        
        System.out.println(manager.getRaceReport(raceLog));  
    }
}
