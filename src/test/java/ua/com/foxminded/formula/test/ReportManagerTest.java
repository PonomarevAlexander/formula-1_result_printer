package ua.com.foxminded.formula.test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InOrder;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import ua.com.foxminded.formula.engine.Parser;
import ua.com.foxminded.formula.engine.PrintFormatter;
import ua.com.foxminded.formula.engine.RaceDriver;
import ua.com.foxminded.formula.engine.RaceLog;
import ua.com.foxminded.formula.manager.ReportManager;

@ExtendWith(MockitoExtension.class)
class ReportManagerTest {
    
    private ReportManager manager;
    private static final String ABBR = "src\\main\\resources\\abbreviations.txt";
    private static final String START_LOG = "src\\main\\resources\\start.log";
    private static final String END_LOG = "src\\main\\resources\\end.log";
    private RaceLog raceLog = new RaceLog(START_LOG, END_LOG, ABBR);
    private List<RaceDriver> racers = new ArrayList<>();
    private static final String EXPECTED = "01. Daniel Ricciardo  | RED BULL RACING TAG HEUER | 1:12.013\r\n"
            + "02. Valtteri Bottas   | MERCEDES                  | 1:12.434\r\n"
            + "03. Lewis Hamilton    | MERCEDES                  | 1:12.460\r\n"
            + "04. Kimi Raikkonen    | FERRARI                   | 1:12.639\r\n"
            + "05. Sergio Perez      | FORCE INDIA MERCEDES      | 1:12.848\r\n"
            + "06. Marcus Ericsson   | SAUBER FERRARI            | 1:13.265\r\n"
            + "07. Lance Stroll      | WILLIAMS MERCEDES         | 1:13.323\r\n"
            + "08. Stoffel Vandoorne | MCLAREN RENAULT           | 1:13.463\r\n"
            + "09. Fernando Alonso   | MCLAREN RENAULT           | 1:13.657\r\n"
            + "10. Sergey Sirotkin   | WILLIAMS MERCEDES         | 1:13.706\r\n"
            + "11. Charles Leclerc   | SAUBER FERRARI            | 1:13.829\r\n"
            + "12. Romain Grosjean   | HAAS FERRARI              | 1:13.930\r\n"
            + "13. Pierre Gasly      | SCUDERIA TORO ROSSO HONDA | 1:13.941\r\n"
            + "14. Carlos Sainz      | RENAULT                   | 1:13.950\r\n"
            + "15. Sebastian Vettel  | FERRARI                   | 2:05.415\r\n"
            + "------------------------------------------------------------\r\n"
            + "16. Esteban Ocon      | FORCE INDIA MERCEDES      | 2:13.028\r\n"
            + "17. Nico Hulkenberg   | RENAULT                   | 2:13.065\r\n"
            + "18. Kevin Magnussen   | HAAS FERRARI              | 2:13.393\r\n"
            + "19. Brendon Hartley   | SCUDERIA TORO ROSSO HONDA | 2:14.179";

    @Mock
    Parser mockedParser;
    
    @Mock
    PrintFormatter mockedFormatter;
    
    @Mock
    RaceLog mockedLog;
    
    @Mock
    RaceDriver mockedRacer;
    
    @InjectMocks
    ReportManager mockedManager = new ReportManager(mockedFormatter, mockedParser);
    
    @Test
    void testTimesOfCallMethods() {
        mockedManager.getRaceReport(mockedLog);
        
        verify(mockedParser).getRacersList(mockedLog);
        verify(mockedFormatter).format(racers);
    }
    
    @Test
    void testInvokationOrder() {
        InOrder inOrder = inOrder(mockedParser, mockedFormatter);
        mockedManager.getRaceReport(mockedLog);
        
        inOrder.verify(mockedParser).getRacersList(mockedLog);
        inOrder.verify(mockedFormatter).format(racers);
    }
    
    @BeforeEach
    void init() {
        manager = new ReportManager(new PrintFormatter(), new Parser());
        raceLog = new RaceLog(START_LOG, END_LOG, ABBR);
    }
    
    @Test
    void testGetRaceReportResult() {
        String actual = manager.getRaceReport(raceLog);
        assertEquals(EXPECTED, actual);
    }
}
