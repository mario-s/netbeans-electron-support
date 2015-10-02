package io.atom.electron;

import static io.atom.electron.cmd.AbstractCommandFactory.createCommand;
import io.atom.electron.cmd.Command;
import io.atom.electron.cmd.CommandType;
import io.atom.electron.cmd.CommandType.Type;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import org.netbeans.api.extexecution.ExecutionDescriptor;
import org.netbeans.api.extexecution.ProcessBuilder;
import org.openide.filesystems.FileObject;
import org.openide.filesystems.FileUtil;
import org.openide.loaders.DataObject;

/**
 * Parent class for action to execute electron.
 *
 * @author spindizzy
 */
public abstract class AbstractElectronAction implements ActionListener {

    private final DataObject context;

    private final ExecutionDescriptor descriptor;

    private final ElectronPreferences preferences;

    private final List<String> arguments;
    
    private Command command;

    public AbstractElectronAction(DataObject context) {
        this.context = context;
        this.preferences = new ElectronPreferences();
        this.arguments = new ArrayList<>();
        descriptor = new ExecutionDescriptor()
                .frontWindow(true)
                .frontWindowOnError(true)
                .controllable(true)
                .showProgress(true)
                .errLineBased(true);
    }

    DataObject getContext() {
        return context;
    }

    TaskObserver createObserver() {
        return new TaskObserver();
    }

    ExecutionDescriptor getDescriptor() {
        return descriptor;
    }

    ElectronPreferences getPreferences() {
        return preferences;
    }
    
    String getFileDisplayName() {
        FileObject fo = context.getPrimaryFile();
        return FileUtil.getFileDisplayName(fo);
    }

    private String getExecutable() {
        //TODO review
        String exe = preferences.getExecutable();
        if (exe == null) {
            exe = command.getExecutable();
        }
        return exe;
    }
    
    final void setCommand(Command command) {
        this.command = command;
    }
    
    final Command getCommand() {
        return command;
    }
    
    private void addProcessArguments(List<String> args) {
        if (!args.isEmpty()) {
            arguments.addAll(args);
        }
    }

    ProcessBuilder createProcessBuilder() {

        String executable = getExecutable();
        addProcessArguments(command.getArguments());
        
        arguments.add(getFileDisplayName());

        return createProcessBuilder(executable, arguments);
    }
    
    ProcessBuilder createProcessBuilder(String executable, List<String> args) {

        ProcessBuilder processBuilder = ProcessBuilder.getLocal();
        processBuilder.setExecutable(executable);
        processBuilder.setArguments(args);
        processBuilder.setRedirectErrorStream(true);
        return processBuilder;
    }
}
