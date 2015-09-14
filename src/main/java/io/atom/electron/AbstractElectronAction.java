package io.atom.electron;

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

    protected static final String ELECTRON = "Electron";

    private final DataObject context;
    
    private final ExecutionDescriptor descriptor;
    
    private final ElectronPreferences preferences;
    
    private final List<String> arguments;

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
        
        addProcessArguments(preferences.getArguments());
    }

    TaskObserver createObserver() {
        return new TaskObserver();
    }

    String getFileDisplayName() {
        FileObject fo = context.getPrimaryFile();
        return FileUtil.getFileDisplayName(fo);
    }

    final void addProcessArguments(List<String> args) {
        if (!args.isEmpty()) {
            arguments.addAll(args);
        }
    }

    ExecutionDescriptor getDescriptor() {
        return descriptor;
    }

    private String getExecutable() {
        String exe = preferences.getExe();
        if (exe == null) {
            exe = preferences.getCommand();
        }
        return exe;
    }
    
    ProcessBuilder createProcessBuilder() {
        
        String executable = getExecutable();
        arguments.add(getFileDisplayName());
        
        ProcessBuilder processBuilder = ProcessBuilder.getLocal();
        processBuilder.setExecutable(executable);
        processBuilder.setArguments(arguments);
        processBuilder.setRedirectErrorStream(true);
        return processBuilder;
    }
}
