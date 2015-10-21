package org.netbeans.modules.atom.electron.project;

import java.util.ArrayList;
import java.util.List;
import javax.swing.event.ChangeListener;
import org.netbeans.spi.project.ui.support.NodeList;
import org.openide.filesystems.FileObject;
import static org.openide.loaders.DataObject.find;
import org.openide.loaders.DataObjectNotFoundException;
import org.openide.nodes.FilterNode;
import org.openide.nodes.Node;
import org.openide.util.Exceptions;

/**
 *
 * @author spindizzy
 */
final class SourceNodeList implements NodeList<Node> {

    private static final String SRC = "src";

    private final ElectronProject project;

    public SourceNodeList(ElectronProject project) {
        this.project = project;
    }

    @Override
    public List<Node> keys() {
        FileObject folder = project.getProjectDirectory().getFileObject(SRC);
        return createNodeList(folder);
    }

    private List<Node> createNodeList(FileObject folder) {
        List<Node> result = new ArrayList<>();
        if (folder != null) {
            SourceNode srcNode = new SourceNode();
            result.add(srcNode);
            addChildren(folder, srcNode);
        }
        return result;
    }

    private void addChildren(FileObject folder, SourceNode srcNode) {
        List<Node> children = new ArrayList<>();
        for (FileObject child : folder.getChildren()) {
            try {
                children.add(find(child).getNodeDelegate());
            } catch (DataObjectNotFoundException ex) {
                Exceptions.printStackTrace(ex);
            }
        }
        if (!children.isEmpty()) {
            srcNode.getChildren().add(children.toArray(new Node[children.size()]));
        }
    }

    @Override
    public void addChangeListener(ChangeListener l) {
    }

    @Override
    public void removeChangeListener(ChangeListener l) {
    }

    @Override
    public Node node(Node node) {
        return new FilterNode(node);
    }

    @Override
    public void addNotify() {
    }

    @Override
    public void removeNotify() {
    }

}
