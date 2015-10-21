package org.netbeans.modules.atom.electron.project;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.netbeans.spi.project.DeleteOperationImplementation;
import org.openide.filesystems.FileObject;

/**
 *
 * @author spindizzy
 */
class ElectronProjectDeleteOperation implements DeleteOperationImplementation {
    
    private final ElectronProject project;

    ElectronProjectDeleteOperation(ElectronProject project) {
        this.project = project;
    }
    
    @Override
    public void notifyDeleting() throws IOException {
    }

    @Override
    public void notifyDeleted() throws IOException {
        project.getProjectState().notifyDeleted();
    }

    @Override
    public List<FileObject> getMetadataFiles() {
        return Collections.emptyList();
    }

    @Override
    public List<FileObject> getDataFiles() {
        return Arrays.asList(project.getProjectDirectory().getChildren());
    }
    
}
