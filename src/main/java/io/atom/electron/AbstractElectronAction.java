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

    public AbstractElectronAction(DataObject context) {
        this.context = context;
        this.preferences = new ElectronPreferences();
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

    protected void addCommandArguments(List<String> args) {
        List<String> prefArgs = getPreferences().getArguments();
        if (!prefArgs.isEmpty()) {
            args.addAll(prefArgs);
        }
        
        args.add(getFileDisplayName());
    }

    protected ProcessBuilder createProcessBuilder() {
        List<String> args = new ArrayList<>();
        String exe = getExecutable();
        addCommandArguments(args);
        return createProcessBuilder(exe, args);
    }

    protected ExecutionDescriptor getDescriptor() {
        return descriptor;
    }

    ElectronPreferences getPreferences() {
        return preferences;
    }

    protected String getExecutable() {
        String exe = getPreferences().getExe();
        if (exe == null) {
            exe = getPreferences().getCommand();
        }
        return exe;
    }
    
    protected ProcessBuilder createProcessBuilder(String executable, List<String> arguments) {
        ProcessBuilder processBuilder = ProcessBuilder.getLocal();
        processBuilder.setExecutable(executable);
        processBuilder.setArguments(arguments);
        processBuilder.setRedirectErrorStream(true);
        return processBuilder;
    }
}
