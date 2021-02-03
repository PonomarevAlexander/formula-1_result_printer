package ua.com.foxminded.formula.engine;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import ua.com.foxminded.formula.interfaces.Reader;

public class FileReader implements Reader<String> {
    
    private static final String EX_MESSAGE = "Race log file not found";
    
    @Override
    public List<String> read(String path) {
        try (Stream<String> fileStream = Files.lines(Paths.get(path))) {
            return fileStream.collect(Collectors.toList());
        } catch (IOException ex) {
            System.out.println(EX_MESSAGE);
            ex.getStackTrace();
        }
        return new ArrayList<>();
    }

}