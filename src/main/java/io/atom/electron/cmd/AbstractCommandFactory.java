package io.atom.electron.cmd;

import io.atom.electron.glue.CommandType;
import java.util.ArrayList;
import java.util.List;

/**
 * A parent class for command factories.
 *
 * @author spindizzy
 */
public abstract class AbstractCommandFactory {

    private static final String OSNAME = "os.name";
    private static final String WIN = "windows";
    private final boolean isWin;

    static final String CMD = "cmd";
    static final String CMD_SWITCH = "/c";

    AbstractCommandFactory() {
        isWin = System.getProperty(OSNAME).toLowerCase().contains(WIN);
    }

    public static Command createCommand(CommandType cmdType) {
        AbstractCommandFactory factory;

        switch (cmdType.getType()) {
            case INSPECTOR:
                factory = new NodeInspectorCommandFactory();
                break;
            case ELECTRON_DEBUG:
                factory = new ElectronDebugCommandFactory(cmdType.getPreferences());
                break;
            default:
                factory = new ElectronRunCommandFactory(cmdType.getPreferences());
        }

        return factory.createCommand();
    }

    protected String createCommand(String command) {
        if (isWin) {
            return CMD;
        }
        return command;
    }

    protected List<String> createArguments(String command) {
        List<String> args = new ArrayList<>();
        if (isWin) {
            args.add(CMD_SWITCH);
            args.add(command);
        }
        return args;
    }

    protected abstract Command createCommand();
}
