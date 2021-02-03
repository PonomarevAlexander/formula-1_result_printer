package ua.com.foxminded.formula.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ua.com.foxminded.formula.engine.Parser;
import ua.com.foxminded.formula.engine.RaceDriver;
import ua.com.foxminded.formula.engine.RaceLog;

class ParserTest {

    private Parser parser;
    private RaceLog log;
    private static final String ABBR = "src\\main\\resources\\abbreviations.txt";
    private static final String  START = "src\\main\\resources\\start.log";
    private static final String END = "src\\main\\resources\\end.log";    
    private static final List<RaceDriver> EXPECTED_LIST = new ArrayList<RaceDriver>(Arrays.asList(
            new RaceDriver("DRR", "Daniel Ricciardo", "RED BULL RACING TAG HEUER"),
            new RaceDriver("SVF", "Sebastian Vettel", "FERRARI"),
            new RaceDriver("LHM", "Lewis Hamilton", "MERCEDES"),
            new RaceDriver("KRF", "Kimi Raikkonen", "FERRARI"),
            new RaceDriver("VBM", "Valtteri Bottas", "MERCEDES"),
            new RaceDriver("EOF", "Esteban Ocon", "FORCE INDIA MERCEDES"),
            new RaceDriver("FAM", "Fernando Alonso", "MCLAREN RENAULT"),
            new RaceDriver("CSR", "Carlos Sainz", "RENAULT"),
            new RaceDriver("SPF", "Sergio Perez", "FORCE INDIA MERCEDES"),
            new RaceDriver("PGS", "Pierre Gasly", "SCUDERIA TORO ROSSO HONDA"),
            new RaceDriver("NHR", "Nico Hulkenberg", "RENAULT"),
            new RaceDriver("SVM", "Stoffel Vandoorne", "MCLAREN RENAULT"),
            new RaceDriver("SSW", "Sergey Sirotkin", "WILLIAMS MERCEDES"),
            new RaceDriver("CLS", "Charles Leclerc", "SAUBER FERRARI"),
            new RaceDriver("RGH", "Romain Grosjean", "HAAS FERRARI"),
            new RaceDriver("BHS", "Brendon Hartley", "SCUDERIA TORO ROSSO HONDA"),
            new RaceDriver("MES", "Marcus Ericsson", "SAUBER FERRARI"),
            new RaceDriver("LSW", "Lance Stroll", "WILLIAMS MERCEDES"),
            new RaceDriver("KMH", "Kevin Magnussen", "HAAS FERRARI")));
    
    @BeforeEach
    void init() {
        parser = new Parser();
        log = new RaceLog(START, END, ABBR);
    }
    
    @Test
    void testAbbreviationIntoGetRaceDriversList() {
        AtomicInteger index = new AtomicInteger();
        List<RaceDriver> actual = parser.getRacersList(log);
        assertEquals(19, actual.size());
        
        actual.stream().
                forEach(rd -> {
                    assertTrue(rd.getAbbreviation().equals(EXPECTED_LIST.get(index.intValue()).getAbbreviation()));
                    index.getAndIncrement();
                });
    }
    
    @Test
    void testFullNameIntoGetRaceDriversList() {
        AtomicInteger index = new AtomicInteger();
        List<RaceDriver> actual = parser.getRacersList(log);
        assertEquals(19, actual.size());
        
        actual.stream().
        forEach(rd -> {
            assertTrue(rd.getFullName().equals(EXPECTED_LIST.get(index.intValue()).getFullName()));
            index.getAndIncrement();
        });
    }
    
    @Test
    void testRaceTeamIntoGetRaceDriversList() {
        AtomicInteger index = new AtomicInteger();
        List<RaceDriver> actual = parser.getRacersList(log);
        assertEquals(19, actual.size());
        
        actual.stream().
        forEach(rd -> {
            assertTrue(rd.getRaceTeam().equals(EXPECTED_LIST.get(index.intValue()).getRaceTeam()));
            index.getAndIncrement();
        });   
    }
}
