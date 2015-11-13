package org.netbeans.modules.atom.electron.actions;

import org.openide.filesystems.FileObject;
import org.openide.filesystems.FileUtil;
import org.openide.loaders.DataObject;

/**
 *
 * @author spindizzy
 */
public abstract class AbstractDataObjectElectronAction extends AbstractElectronAction {
    
    private final DataObject context;

    public AbstractDataObjectElectronAction(DataObject context) {
        this.context = context;
    }
    
    DataObject getContext() {
        return context;
    }
    
    @Override
    protected String getFileDisplayName() {
        FileObject fo = context.getPrimaryFile();
        return FileUtil.getFileDisplayName(fo);
    }
    
}
