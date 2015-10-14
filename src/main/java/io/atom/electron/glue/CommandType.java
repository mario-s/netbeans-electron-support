package io.atom.electron.glue;

/**
 *
 * @author spindizzy
 */
public interface CommandType {

    Type getType();
    
    enum Type {

        ELECTRON_RUN, ELECTRON_DEBUG, INSPECTOR
    };

    Preferences getPreferences();
    
}
