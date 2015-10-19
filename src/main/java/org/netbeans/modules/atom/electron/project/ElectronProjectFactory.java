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
    
    private static final String SRC = "src/";
    private static final String PACKAGE = SRC + "package.json";
    private static final String MAIN = SRC + "main.js";
    private static final String INDEX = SRC + "index.html";

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
        boolean hasPackage = projectDirectory.getFileObject(PACKAGE) != null;
        boolean hasMain = projectDirectory.getFileObject(MAIN) != null;
        boolean hasIndex = projectDirectory.getFileObject(INDEX) != null;
        return hasPackage && hasMain && hasIndex;
    }

    @Override
    public Project loadProject(FileObject dir, ProjectState ps) throws IOException {
        return isProject(dir) ? new ElectronProject(dir, ps) : null;
    }

    @Override
    public void saveProject(Project prjct) throws IOException, ClassCastException {
    }

}
