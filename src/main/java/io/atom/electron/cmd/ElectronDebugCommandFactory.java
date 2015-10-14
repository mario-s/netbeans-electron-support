package io.atom.electron.cmd;

import io.atom.electron.glue.Preferences;
import java.util.List;

/**
 *
 * @author spindizzy
 */
class ElectronDebugCommandFactory extends ElectronRunCommandFactory {

    private static final String DEBUG_SWITCH = "--debug=";
    private static final String BRK_DEBUG_SWITCH = "--debug-brk=";

    public ElectronDebugCommandFactory(Preferences preferences) {
        super(preferences);
    }

    @Override
    protected Command createCommand() {
        return new DefaultCommand(createElectronCommand(), createArguments(ELECTRON));
    }

    @Override
    protected List<String> createArguments(String command) {
        List<String> args = super.createArguments(command);
        if (getPreferences().isBreakOnFirstLine()) {
            args.add(BRK_DEBUG_SWITCH + getPreferences().getDebugPort());
        } else {
            args.add(DEBUG_SWITCH + getPreferences().getDebugPort());
        }
        return args;
    }

}
