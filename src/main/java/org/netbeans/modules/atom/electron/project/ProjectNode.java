package org.netbeans.modules.atom.electron.project;

import java.awt.Image;
import javax.swing.Action;
import org.netbeans.api.project.Project;
import org.netbeans.spi.project.ui.support.CommonProjectActions;
import org.openide.loaders.DataObjectNotFoundException;
import org.openide.nodes.FilterNode;
import org.openide.nodes.Node;
import org.openide.util.ImageUtilities;
import org.openide.util.Lookup;
import org.openide.util.lookup.Lookups;
import org.openide.util.lookup.ProxyLookup;

import static org.netbeans.spi.project.ui.support.NodeFactorySupport.createCompositeChildren;

/**
 *
 * @author spindizzy
 */
final class ProjectNode extends FilterNode {

    private final Project project;

    public ProjectNode(Node node, Project project) throws DataObjectNotFoundException {
        super(node, createCompositeChildren(project,
                "Projects/io-atom-electron-project/Nodes"), new ProxyLookup(
                        new Lookup[]{Lookups.singleton(project),
                            node.getLookup()}));
        this.project = project;
    }

    @Override
    public Action[] getActions(boolean arg0) {
        return new Action[]{CommonProjectActions.newFileAction(),
            CommonProjectActions.copyProjectAction(),
            CommonProjectActions.deleteProjectAction(),
            CommonProjectActions.closeProjectAction(),
            CommonProjectActions.setAsMainProjectAction(),
            CommonProjectActions.renameProjectAction(),
            CommonProjectActions.customizeProjectAction()};
    }

    @Override
    public Image getIcon(int type) {
        return ImageUtilities.loadImage(ElectronProjectInformation.ICON);
    }

    @Override
    public Image getOpenedIcon(int type) {
        return getIcon(type);
    }

    @Override
    public String getDisplayName() {
        return project.getProjectDirectory().getName();
    }

}
