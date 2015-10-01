package io.atom.electron.cmd;

import java.util.List;

/**
 * This interface contains the values to launch an external process.
 *
 * @author spindizzy
 */
public interface Command {

    /**
     * Returns the actual executable.
     *
     * @return
     */
    String getExecutable();

    /**
     * Returns the arguments for the executable
     *
     * @return
     */
    List<String> getArguments();
}
