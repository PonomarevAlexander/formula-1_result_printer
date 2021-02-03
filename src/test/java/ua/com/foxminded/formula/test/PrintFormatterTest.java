package ua.com.foxminded.formula.test;


import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ua.com.foxminded.formula.engine.PrintFormatter;
import ua.com.foxminded.formula.engine.RaceDriver;

class PrintFormatterTest {
    
    private PrintFormatter formatter;
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
    
    private List<RaceDriver> racersList = new ArrayList<RaceDriver>(Arrays.asList(
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
        formatter = new PrintFormatter();
        racersList.get(0).setBestLap("1:12.013");
        racersList.get(1).setBestLap("2:05.415");
        racersList.get(2).setBestLap("1:12.460");
        racersList.get(3).setBestLap("1:12.639");
        racersList.get(4).setBestLap("1:12.434");
        racersList.get(5).setBestLap("2:13.028");
        racersList.get(6).setBestLap("1:13.657");
        racersList.get(7).setBestLap("1:13.950");
        racersList.get(8).setBestLap("1:12.848");
        racersList.get(9).setBestLap("1:13.941");
        racersList.get(10).setBestLap("2:13.065");
        racersList.get(11).setBestLap("1:13.463");
        racersList.get(12).setBestLap("1:13.706");
        racersList.get(13).setBestLap("1:13.829");
        racersList.get(14).setBestLap("1:13.930");
        racersList.get(15).setBestLap("2:14.179");
        racersList.get(16).setBestLap("1:13.265");
        racersList.get(17).setBestLap("1:13.323");
        racersList.get(18).setBestLap("2:13.393");        
    }
    
    @Test
    void testFormat() {
        String actual = formatter.format(racersList);
        assertEquals(EXPECTED, actual);
    }
    
}
