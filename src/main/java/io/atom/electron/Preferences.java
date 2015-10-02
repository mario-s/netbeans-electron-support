package io.atom.electron;

/**
 * Interface for user defined prefrences.
 * @author spindizzy
 */
public interface Preferences {
    
    boolean isBreakOnFirstLine();
    
    String getDebugPort();
}
