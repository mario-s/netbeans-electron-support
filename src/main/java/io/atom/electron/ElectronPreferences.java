package io.atom.electron;

import java.util.ArrayList;
import java.util.List;
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
    private static final String DEBUG_PORT = "debug";
    private static final String DEF_DEBUG_PORT = "5858";
    private static final String BREAK = "brk";
    private static final String NODE_DEBUG = "node-debug";

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

    public String getDebugPort() {
        return forModule(ElectronPreferences.class).get(DEBUG_PORT, DEF_DEBUG_PORT);
    }

    public void setDebugPort(String port) {
        forModule(ElectronPreferences.class).get(DEBUG_PORT, port);
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
        return createCommand(NODE_DEBUG);
    }

    private String createCommand(String command) {
        if (isWin) {
            return CMD;
        }
        return command;
    }

    public List<String> getElectronArguments() {
        return createArguments(ELECTRON);
    }

    public List<String> getNodeDebugArguments() {
        return createArguments(NODE_DEBUG);
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
