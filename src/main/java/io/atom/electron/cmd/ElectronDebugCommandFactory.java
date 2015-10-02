package io.atom.electron.cmd;

import io.atom.electron.Preferences;
import java.util.List;

/**
 *
 * @author spindizzy
 */
class ElectronDebugCommandFactory extends ElectronRunCommandFactory {

    private static final String DEBUG_SWITCH = "--debug=";
    private static final String BRK_DEBUG_SWITCH = "--debug-brk=";

    private final Preferences preferences;

    public ElectronDebugCommandFactory(Preferences preferences) {
        this.preferences = preferences;
    }

    @Override
    protected Command createCommand() {
        return new DefaultCommand(createCommand(ELECTRON), createArguments(ELECTRON));
    }

    @Override
    protected List<String> createArguments(String command) {
        List<String> args = super.createArguments(command);
        if (preferences.isBreakOnFirstLine()) {
            args.add(BRK_DEBUG_SWITCH + preferences.getDebugPort());
        } else {
            args.add(DEBUG_SWITCH + preferences.getDebugPort());
        }
        return args;
    }

}
