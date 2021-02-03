package ua.com.foxminded.formula.engine;

import java.util.Comparator;
import java.util.List;
import java.util.StringJoiner;
import java.util.concurrent.atomic.AtomicInteger;
import ua.com.foxminded.formula.interfaces.Formatter;

public class PrintFormatter implements Formatter<List<RaceDriver>> {
    
    private static final String V_LINE = "|";
    private static final String SPACE = " ";
    private static final String DOT = ".";
    private static final String LINE = "------------------------------------------------------------";

    @Override
    public String format(List<RaceDriver> racers) {
        int maxNameLen = getMaxNameLength(racers);
        int maxTeamLen = getMaxTeamLength(racers);
        AtomicInteger index = new AtomicInteger();
        StringJoiner joiner = new StringJoiner(System.lineSeparator());
        racers.stream()
                .sorted(Comparator.comparing(RaceDriver::getBestLap))
                .forEach(racer -> {
                        if (index.intValue() == 15) {
                            joiner.add(LINE);
                        }
                        joiner.add(getIndex(index) + DOT
                                + SPACE + racer.getFullName() + nameAlign(racer, maxNameLen) + V_LINE
                                + SPACE + racer.getRaceTeam() + teamAlign(racer, maxTeamLen) + V_LINE
                                + SPACE + racer.getBestLap());
                }); 
        return joiner.toString();
    }
    
    private String getIndex(AtomicInteger index) {
        return String.format("%02d", index.getAndIncrement() + 1);
    }
    
    private String nameAlign(RaceDriver racer, int max) {
        return String.format("%" + (max - racer.getFullName().length()) + "s", SPACE);
    }
    
    private String teamAlign(RaceDriver racer, int max) {
        return String.format("%" + (max - racer.getRaceTeam().length()) + "s", SPACE);
    }
    
    private int getMaxNameLength(List<RaceDriver> racers) {
        return racers.stream()
                .mapToInt(racer -> racer.getFullName().length() + 1)
                .max()
                .orElse(0);
    }
    
    private int getMaxTeamLength(List<RaceDriver> racers) {
        return racers.stream()
                .mapToInt(racer -> racer.getRaceTeam().length() + 1)
                .max()
                .orElse(0);
    }
}