package org.netbeans.modules.atom.electron.project;

import org.netbeans.api.project.Project;
import org.netbeans.spi.project.ProjectState;
import org.openide.filesystems.FileObject;
import org.openide.util.Lookup;
import org.openide.util.lookup.Lookups;

/**
 *
 * @author spindizzy
 */
public class ElectronProject implements Project {

    private final FileObject projectDir;
    private final ProjectState state;
    private Lookup lookup;

    public ElectronProject(FileObject projectDir, ProjectState state) {
        this.projectDir = projectDir;
        this.state = state;
    }

    @Override
    public FileObject getProjectDirectory() {
        return projectDir;
    }

    @Override
    public Lookup getLookup() {
        if (lookup == null) {
            lookup = Lookups.fixed(new Object[]{});
        }
        return lookup;
    }

}
