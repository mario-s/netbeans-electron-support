package io.atom.electron.cmd;

import io.atom.electron.Preferences;

/**
 * Defines thy type of the required command with additional preferences.
 *
 * @author schroeder
 */
public class CommandType {

    public enum Type {

        ELECTRON_RUN, ELECTRON_DEBUG, INSPECTOR
    };

    private Preferences preferences;

    private Type type;

    public CommandType() {
        type = Type.ELECTRON_RUN;
    }
    
    public CommandType(Type type) {
        this(type, null);
    }

    public CommandType(Type type, Preferences preferences) {
        this.type = type;
        this.preferences = preferences;
    }

    public Preferences getPreferences() {
        return preferences;
    }

    public Type getType() {
        return type;
    }
}
