package org.netbeans.modules.atom.electron.project;

import org.netbeans.api.project.Project;
import org.netbeans.spi.project.ui.LogicalViewProvider;
import org.openide.filesystems.FileObject;
import org.openide.loaders.DataFolder;
import org.openide.loaders.DataObjectNotFoundException;
import org.openide.nodes.AbstractNode;
import org.openide.nodes.Children;
import org.openide.nodes.Node;
import org.openide.util.Exceptions;

import static org.openide.loaders.DataFolder.findFolder;

/**
 *
 * @author spindizzy
 */
class ElectronProjectLogicalView implements LogicalViewProvider {

    private final Project project;

    public ElectronProjectLogicalView(Project project) {
        this.project = project;
    }

    @Override
    public Node createLogicalView() {
        try {
            //Obtain the project directory's node:
            FileObject projectDirectory = project.getProjectDirectory();
            DataFolder projectFolder = findFolder(projectDirectory);
            Node nodeOfProjectFolder = projectFolder.getNodeDelegate();
            //Decorate the project directory's node: 
            return new ProjectNode(nodeOfProjectFolder, project);
        } catch (DataObjectNotFoundException ex) {
            Exceptions.printStackTrace(ex);
            //Fallback-the directory couldn't be created - 
            //read-only filesystem or something evil happened 
            return new AbstractNode(Children.LEAF);
        }
    }


    @Override
    public Node findPath(Node root, Object target) {
        return null;
    }
}
