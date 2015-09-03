package io.atom.electron;

import org.openide.util.NbPreferences;

/**
 *
 * @author spindizzy
 */
public enum PreferencesAccess {

    Instance;

    private static final String EXE = "exe";
    private static final String CMD = "cmd";
    private static final String ELECTRON = "electron";

    private final boolean isWin;

    private PreferencesAccess() {
        isWin = System.getProperty("os.name").toLowerCase().contains("windows");
    }

    public String getExe() {
        return NbPreferences.forModule(PreferencesAccess.class).get(EXE, null);
    }

    public void putExe(String path) {
        NbPreferences.forModule(PreferencesAccess.class).put(EXE, path);
    }

    public String getCommand() {
        if (isWin) {
            return CMD;
        }
        return ELECTRON;

    }

    public String[] getArguments() {
        if (isWin) {
            return new String[]{"/c", ELECTRON};
        }
        return new String[]{};
    }
}
