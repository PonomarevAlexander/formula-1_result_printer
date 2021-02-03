package ua.com.foxminded.formula.interfaces;

import java.util.List;

public interface Reader<T> {
    
    List<String> read(T source);
}
