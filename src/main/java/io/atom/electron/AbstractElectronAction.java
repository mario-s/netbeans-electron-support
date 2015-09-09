package io.atom.electron;

import java.awt.event.ActionListener;
import org.netbeans.api.extexecution.ExecutionDescriptor;
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
        return new TaskObserver(this);
    }

    String getFileDisplayName() {
        FileObject fo = context.getPrimaryFile();
        return FileUtil.getFileDisplayName(fo);
    }

    protected ExecutionDescriptor getDescriptor() {
        return descriptor;
    }

    ElectronPreferences getPreferences() {
        return preferences;
    }
}
