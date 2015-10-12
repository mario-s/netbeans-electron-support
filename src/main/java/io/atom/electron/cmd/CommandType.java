package io.atom.electron.cmd;

import io.atom.electron.Preferences;

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
