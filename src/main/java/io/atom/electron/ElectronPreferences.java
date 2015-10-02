package io.atom.electron;

import static org.openide.util.NbPreferences.forModule;

/**
 *
 * @author spindizzy
 */
class ElectronPreferences implements Preferences{

    private static final String EXE = "exe";
    
    private static final String DEBUG_PORT = "debug";
    private static final String DEF_DEBUG_PORT = "5858";
    private static final String BREAK = "brk";
    private static final String DEBUG_URL = "debug-url";
    private static final String DEF_DEBUG_URL = "http://127.0.0.1:8080/debug?ws=127.0.0.1:8080&port=";

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

    @Override
    public String getDebugPort() {
        return forModule(ElectronPreferences.class).get(DEBUG_PORT, DEF_DEBUG_PORT);
    }

    public void setDebugPort(String port) {
        forModule(ElectronPreferences.class).put(DEBUG_PORT, port);
    }

    @Override
    public boolean isBreakOnFirstLine() {
        return forModule(ElectronPreferences.class).getBoolean(BREAK, true);
    }

    public void setBreakOnFirstLine(boolean brk) {
        forModule(ElectronPreferences.class).putBoolean(BREAK, brk);
    }


}
