package ua.com.foxminded.formula.test;


import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ua.com.foxminded.formula.engine.FileReader;

class FileReaderTest {

    private FileReader reader;
    private static final String ABBR = "src\\main\\resources\\abbreviations.txt";
    private List<String> expected = new ArrayList<String>(Arrays.asList(
            "DRR_Daniel Ricciardo_RED BULL RACING TAG HEUER",
            "SVF_Sebastian Vettel_FERRARI",
            "LHM_Lewis Hamilton_MERCEDES",
            "KRF_Kimi Raikkonen_FERRARI",
            "VBM_Valtteri Bottas_MERCEDES",
            "EOF_Esteban Ocon_FORCE INDIA MERCEDES",
            "FAM_Fernando Alonso_MCLAREN RENAULT",
            "CSR_Carlos Sainz_RENAULT",
            "SPF_Sergio Perez_FORCE INDIA MERCEDES",
            "PGS_Pierre Gasly_SCUDERIA TORO ROSSO HONDA",
            "NHR_Nico Hulkenberg_RENAULT",
            "SVM_Stoffel Vandoorne_MCLAREN RENAULT",
            "SSW_Sergey Sirotkin_WILLIAMS MERCEDES",
            "CLS_Charles Leclerc_SAUBER FERRARI",
            "RGH_Romain Grosjean_HAAS FERRARI",
            "BHS_Brendon Hartley_SCUDERIA TORO ROSSO HONDA",
            "MES_Marcus Ericsson_SAUBER FERRARI",
            "LSW_Lance Stroll_WILLIAMS MERCEDES",
            "KMH_Kevin Magnussen_HAAS FERRARI"));
    
    @BeforeEach
    void init() {
        reader = new FileReader();
    }
    
    @Test
    void testReadMethod() {
        List<String> actual = reader.read(ABBR);
        assertEquals(expected, actual);
    }
}
