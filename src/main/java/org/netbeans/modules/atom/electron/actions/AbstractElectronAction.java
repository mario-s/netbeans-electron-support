package org.netbeans.modules.atom.electron.actions;

import org.netbeans.modules.atom.electron.glue.Preferences;
import org.netbeans.modules.atom.electron.cmd.Command;
import org.netbeans.modules.atom.electron.options.ElectronPreferences;
import java.util.ArrayList;
import java.util.List;
import javax.swing.AbstractAction;
import org.netbeans.api.extexecution.ExecutionDescriptor;
import org.netbeans.api.extexecution.ProcessBuilder;

/**
 * Parent class for action to execute electron.
 *
 * @author spindizzy
 */
public abstract class AbstractElectronAction extends AbstractAction {


    private final ExecutionDescriptor descriptor;

    private final Preferences preferences;

    private final List<String> arguments;
    
    private Command command;

    public AbstractElectronAction() {
        this.preferences = new ElectronPreferences();
        this.arguments = new ArrayList<>();
        descriptor = new ExecutionDescriptor()
                .frontWindow(true)
                .frontWindowOnError(true)
                .controllable(true)
                .showProgress(true)
                .errLineBased(true);
    }


    TaskObserver createObserver() {
        return new TaskObserver();
    }
    
    final DefaultCommandType createCommandType(DefaultCommandType.Type type) {
        return  new DefaultCommandType(type, getPreferences());
    }

    ExecutionDescriptor getDescriptor() {
        return descriptor;
    }

    Preferences getPreferences() {
        return preferences;
    }
    
    final void setCommand(Command command) {
        this.command = command;
    }
    
    final Command getCommand() {
        return command;
    }
    
    protected abstract String getFileDisplayName();

    ProcessBuilder createProcessBuilder() {

        String executable = command.getExecutable();
        arguments.addAll(command.getArguments());
        
        arguments.add(getFileDisplayName());

        return createProcessBuilder(executable, arguments);
    }
    
    ProcessBuilder createProcessBuilder(Command command) {
        return createProcessBuilder(command.getExecutable(), command.getArguments());
    }
    
    private ProcessBuilder createProcessBuilder(String executable, List<String> args) {

        ProcessBuilder processBuilder = ProcessBuilder.getLocal();
        processBuilder.setExecutable(executable);
        processBuilder.setArguments(args);
        processBuilder.setRedirectErrorStream(true);
        return processBuilder;
    }
}
