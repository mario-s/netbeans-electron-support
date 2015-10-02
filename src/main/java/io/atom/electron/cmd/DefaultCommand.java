package io.atom.electron.cmd;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author spindizzy
 */
class DefaultCommand implements Command {

    private String executable;
    private List<String> arguments;
    
    DefaultCommand(String executable) {
        this(executable, new ArrayList<>());
    }

    DefaultCommand(String executable, List<String> arguments) {
        this.executable = executable;
        this.arguments = arguments;
    }
    
    
    @Override
    public String getExecutable() {
        return executable;
    }

    @Override
    public List<String> getArguments() {
        return arguments;
    }

    void setExecutable(String executable) {
        this.executable = executable;
    }

    void setArguments(List<String> arguments) {
        this.arguments = arguments;
    }

}
