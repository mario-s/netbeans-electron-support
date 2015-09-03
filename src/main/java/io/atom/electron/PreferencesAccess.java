package io.atom.electron;

import org.openide.util.NbPreferences;

/**
 *
 * @author spindizzy
 */
public enum PreferencesAccess {
    Instance;
    
    private static final String EXE = "exe";
    
    public String getExe() {
        return NbPreferences.forModule(PreferencesAccess.class).get(EXE, "");
    }
    
    public void putExe(String path) {
        NbPreferences.forModule(PreferencesAccess.class).put(EXE, path);
    }
    
}
