package org.netbeans.modules.atom.electron.project;

import org.netbeans.modules.atom.electron.project.customizer.ElectronCustomizerProvider;
import org.netbeans.api.project.Project;
import org.netbeans.spi.project.ProjectState;
import org.openide.filesystems.FileObject;
import org.openide.util.Lookup;
import org.openide.util.lookup.Lookups;

/**
 *
 * @author spindizzy
 */
class ElectronProject implements Project {

    private final FileObject projectDir;
    private final ProjectState projectState;
    private Lookup lookup;

    ElectronProject(FileObject projectDir, ProjectState state) {
        this.projectDir = projectDir;
        this.projectState = state;
    }

    @Override
    public FileObject getProjectDirectory() {
        return projectDir;
    }

    @Override
    public Lookup getLookup() {
        if (lookup == null) {
            lookup = Lookups.fixed(new Object[]{
                this,
                new ElectronProjectInformation(this),
                new ElectronProjectLogicalView(this),
                new ElectronProjectDeleteOperation(this),
                new ElectronActionsProvider(this),
                new ElectronCustomizerProvider(this)
            });
        }
        return lookup;
    }

    ProjectState getProjectState() {
        return projectState;
    }
}
