package io.atom.electron.cmd;

import java.util.ArrayList;
import java.util.List;

/**
 * A parent class for command factories.
 *
 * @author spindizzy
 */
public abstract class AbstractCommandFactory {

    public enum Type {

        ELECTRON_RUN, INSPECTOR
    };

    private static final String CMD = "cmd";
    private static final String CMD_SWITCH = "/c";
    private static final String OSNAME = "os.name";
    private static final String WIN = "windows";
    private final boolean isWin;

    AbstractCommandFactory() {
        isWin = System.getProperty(OSNAME).toLowerCase().contains(WIN);
    }

    public static Command createCommand(Type type) {
        AbstractCommandFactory factory = null;

        switch (type) {
            case INSPECTOR:
                factory = new NodeInspectorCommandFactory();
                break;
            default:
                factory = new ElectronRunCommandFactory();
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
        List<String> args = new ArrayList<>(2);
        if (isWin) {
            args.add(CMD_SWITCH);
            args.add(command);
        }
        return args;
    }

    protected abstract Command createCommand();
}
