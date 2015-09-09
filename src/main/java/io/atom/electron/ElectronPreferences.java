package io.atom.electron;

import static org.openide.util.NbPreferences.forModule;

/**
 *
 * @author spindizzy
 */
class ElectronPreferences {

    private static final String EXE = "exe";
    private static final String CMD = "cmd";
    private static final String ELECTRON = "electron";
    private static final String CMD_SWITCH = "/c";
    private static final String WIN = "windows";
    private static final String OSNAME = "os.name";

    private final boolean isWin;

    ElectronPreferences() {
        isWin = System.getProperty(OSNAME).toLowerCase().contains(WIN);
    }

    public String getExe() {
        return forModule(ElectronPreferences.class).get(EXE, null);
    }

    public void putExe(String path) {
        forModule(ElectronPreferences.class).put(EXE, path);
    }

    public String getCommand() {
        if (isWin) {
            return CMD;
        }
        return ELECTRON;

    }

    public String[] getArguments() {
        if (isWin) {
            return new String[]{CMD_SWITCH, ELECTRON};
        }
        return new String[]{};
    }
}
