package org.netbeans.modules.atom.electron.project;

import java.io.IOException;
import org.netbeans.api.project.Project;
import org.netbeans.api.project.ProjectManager;
import org.netbeans.spi.project.ProjectFactory;
import org.netbeans.spi.project.ProjectFactory2;
import org.netbeans.spi.project.ProjectState;
import org.openide.filesystems.FileObject;
import org.openide.util.lookup.ServiceProvider;

/**
 *
 * @author spindizzy
 */
@ServiceProvider(service = ProjectFactory.class)
public class ElectronProjectFactory implements ProjectFactory2 {

    @Override
    public ProjectManager.Result isProject2(FileObject fo) {
        ProjectManager.Result result = null;
        if (isProject(fo)) {
            result = new ProjectManager.Result(ElectronProjectInformation.loadIcon());
        }
        return result;
    }

    @Override
    public boolean isProject(FileObject projectDirectory) {
        PackagesFinder finder = new PackagesFinder(projectDirectory);
        return finder.hasPackage() && finder.hasMainJs() && finder.hasIndex();
    }

    @Override
    public Project loadProject(FileObject dir, ProjectState ps) throws IOException {
        return isProject(dir) ? new ElectronProject(dir, ps) : null;
    }

    @Override
    public void saveProject(Project prjct) throws IOException, ClassCastException {
    }

}
