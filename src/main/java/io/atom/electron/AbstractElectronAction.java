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
    }

    TaskObserver createObserver() {
        return new TaskObserver();
    }

    String getFileDisplayName() {
        FileObject fo = context.getPrimaryFile();
        return FileUtil.getFileDisplayName(fo);
    }

    ProcessBuilder createProcessBuilder() {
        String exe = getExecutable();
        addProcessArguments(arguments);
        return createProcessBuilder(exe, arguments);
    }
    
    void addProcessArguments(List<String> args) {
        List<String> prefArgs = getPreferences().getArguments();
        if (!prefArgs.isEmpty()) {
            args.addAll(prefArgs);
        }
        
        args.add(getFileDisplayName());
    }

    ExecutionDescriptor getDescriptor() {
        return descriptor;
    }

    ElectronPreferences getPreferences() {
        return preferences;
    }

    String getExecutable() {
        String exe = getPreferences().getExe();
        if (exe == null) {
            exe = getPreferences().getCommand();
        }
        return exe;
    }
    
    ProcessBuilder createProcessBuilder(String executable, List<String> arguments) {
        ProcessBuilder processBuilder = ProcessBuilder.getLocal();
        processBuilder.setExecutable(executable);
        processBuilder.setArguments(arguments);
        processBuilder.setRedirectErrorStream(true);
        return processBuilder;
    }
}
