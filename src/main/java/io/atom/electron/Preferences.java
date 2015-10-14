package io.atom.electron;

/**
 * Interface for user defined preferences.
 * @author spindizzy
 */
public interface Preferences {
    
    boolean isBreakOnFirstLine();
    
    /**
     * This method returns the path to user's selected executable.
     * @return path to executable as String 
     */
    String getExecutable();

    String getDebugUrl();
    
    String getDebugPort();
}
