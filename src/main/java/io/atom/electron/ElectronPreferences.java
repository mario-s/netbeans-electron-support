package io.atom.electron;

import java.util.ArrayList;
import static java.util.Collections.singletonList;
import java.util.List;
import static org.openide.util.NbPreferences.forModule;

/**
 *
 * @author spindizzy
 */
class ElectronPreferences {

    private static final String EXE = "exe";
    private static final String CMD = "cmd";
    private static final String CMD_SWITCH = "/c";
    private static final String WIN = "windows";
    private static final String OSNAME = "os.name";
    private static final String DEBUG_PORT = "debug";
    private static final String DEF_DEBUG_PORT = "5858";
    private static final String BREAK = "brk";
    private static final String INSPECTOR = "node-inspector";
    private static final String DEBUG_URL = "debug-url";
    private static final String DEF_DEBUG_URL = "http://127.0.0.1:8080/debug?ws=127.0.0.1:8080&port=";

    private static final String DEBUG_SWITCH = "--debug=";
    private static final String BRK_DEBUG_SWITCH = "--debug-brk=";

    static final String ELECTRON = "electron";

    private final boolean isWin;

    ElectronPreferences() {
        isWin = System.getProperty(OSNAME).toLowerCase().contains(WIN);
    }

    public String getExecutable() {
        return forModule(ElectronPreferences.class).get(EXE, null);
    }

    public void setExecutable(String path) {
        forModule(ElectronPreferences.class).put(EXE, path);
    }

    public String getDebugUrl() {
        return forModule(ElectronPreferences.class).get(DEBUG_URL, DEF_DEBUG_URL);
    }

    public void setDebugUrl(String url) {
        forModule(ElectronPreferences.class).put(DEBUG_URL, url);
    }

    public String getDebugPort() {
        return forModule(ElectronPreferences.class).get(DEBUG_PORT, DEF_DEBUG_PORT);
    }

    public void setDebugPort(String port) {
        forModule(ElectronPreferences.class).put(DEBUG_PORT, port);
    }

    public boolean isBreakOnFirstLine() {
        return forModule(ElectronPreferences.class).getBoolean(BREAK, true);
    }

    public void setBreakOnFirstLine(boolean brk) {
        forModule(ElectronPreferences.class).putBoolean(BREAK, brk);
    }

    public String getElectronCommand() {
        return createCommand(ELECTRON);
    }

    public String getNodeDebugCommand() {
        return createCommand(INSPECTOR);
    }

    public String getDebugProcessName() {
        return INSPECTOR;
    }

    public List<String> getElectronArguments() {
        return createArguments(ELECTRON);
    }

    public List<String> getNodeDebugArguments() {
        return createArguments(INSPECTOR);
    }

    public List<String> getElectronDebugArguments() {
        if (isBreakOnFirstLine()) {
            return singletonList(BRK_DEBUG_SWITCH + getDebugPort());
        }
        return singletonList(DEBUG_SWITCH + getDebugPort());
    }

    private String createCommand(String command) {
        if (isWin) {
            return CMD;
        }
        return command;
    }

    private List<String> createArguments(String command) {
        List<String> args = new ArrayList<>(2);
        if (isWin) {
            args.add(CMD_SWITCH);
            args.add(command);
        }
        return args;
    }
}
