package ua.com.foxminded.formula.engine;

import java.util.List;
import java.util.stream.Collectors;

public class Parser {
    
    private static final String UNDERSCORE = "_";
    private FileReader reader = new FileReader();
    
    public List<RaceDriver> getRacersList(RaceLog log) {
        List<String> fileLines = reader.read(log.getAbbreviations());
        List<RaceDriver> result = fileLines
                .stream()
                .map(line -> line.split(UNDERSCORE))
                .map(s -> new RaceDriver(s[0], s[1], s[2]))
                .collect(Collectors.toList());
        
        for (RaceDriver racer : result) {
            racer.setStartTime(
                    parseTime(log.getStartLog(), racer.getAbbreviation()));
            racer.setEndTime(
                    parseTime(log.getEndLog(), racer.getAbbreviation()));
        }
        return result;
    }
    
    private String parseTime(String log, String abbr) {
        List<String> fileLines = reader.read(log);
        return fileLines
                .stream()
                .filter(line -> line.contains(abbr))
                .map(line -> line.split(UNDERSCORE))
                .map(subLine -> subLine[1])
                .collect(Collectors.joining());
    }
}