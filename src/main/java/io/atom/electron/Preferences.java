package io.atom.electron;

/**
 * Interface for user defined prefrences.
 * @author spindizzy
 */
public interface Preferences {
    
    boolean isBreakOnFirstLine();
    
    String getDebugPort();
    
    /**
     * This method returns the path to user's selected executable.
     * @return path to executable as String 
     */
    String getExecutable();
}
