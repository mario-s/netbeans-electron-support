package org.netbeans.modules.atom.electron.project;

import java.beans.PropertyChangeListener;
import javax.swing.Icon;
import org.netbeans.api.annotations.common.StaticResource;
import org.netbeans.api.project.Project;
import org.netbeans.api.project.ProjectInformation;
import org.openide.util.ImageUtilities;

/**
 *
 * @author spindizzy
 */
class ElectronProjectInformation implements ProjectInformation {
    @StaticResource
    static final String ICON = "org/netbeans/modules/atom/electron/atom_16x16.png";
    
    private final Project project;

    ElectronProjectInformation(Project project) {
        this.project = project;
    }

    @Override
    public String getName() {
        return project.getProjectDirectory().getName();
    }

    @Override
    public String getDisplayName() {
        return getName();
    }

    @Override
    public Icon getIcon() {
        return loadIcon();
    }
    
    static Icon loadIcon() {
        return ImageUtilities.loadImageIcon(ICON, false);
    }

    @Override
    public Project getProject() {
        return project;
    }

    @Override
    public void addPropertyChangeListener(PropertyChangeListener pl) {
    }

    @Override
    public void removePropertyChangeListener(PropertyChangeListener pl) {
    }
    
}
