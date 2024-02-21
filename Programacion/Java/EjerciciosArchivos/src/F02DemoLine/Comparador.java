package src.F02DemoLine;

import java.util.Comparator;

public class Comparador implements Comparator<String>{

    @Override
    public int compare(String s1, String s2) {
        return s1.compareToIgnoreCase(s2);
    }
    
}
