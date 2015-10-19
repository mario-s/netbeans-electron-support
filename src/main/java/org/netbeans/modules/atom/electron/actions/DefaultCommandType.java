package org.netbeans.modules.atom.electron.actions;

import org.netbeans.modules.atom.electron.glue.Preferences;
import org.netbeans.modules.atom.electron.glue.CommandType;

/**
 * Defines thy type of the required command with additional preferences.
 *
 * @author spindizzy
 */
class DefaultCommandType implements CommandType{

    private Preferences preferences;

    private Type type;
    
    public DefaultCommandType(Type type) {
        this(type, null);
    }

    public DefaultCommandType(Type type, Preferences preferences) {
        this.type = type;
        this.preferences = preferences;
    }

    @Override
    public Preferences getPreferences() {
        return preferences;
    }

    @Override
    public Type getType() {
        return type;
    }
}
