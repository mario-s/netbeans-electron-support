package org.netbeans.modules.atom.electron.project;

import java.awt.Image;
import org.netbeans.api.annotations.common.StaticResource;
import org.openide.nodes.AbstractNode;
import org.openide.nodes.Index;
import org.openide.util.ImageUtilities;
import org.openide.util.NbBundle;

/**
 *
 * @author spindizzy
 */
class ProjectSourceNode extends AbstractNode {

    @StaticResource
    private static final String FOLDER = "org/netbeans/modules/atom/electron/project/folder.png";

    public ProjectSourceNode() {
        super(new Index.ArrayChildren());
        
        String name = NbBundle.getMessage(ProjectSourceNode.class, "LBL_ProjectsRootNode_SrcFolder");
        setName(name);
        setDisplayName(name);

    }

    @Override
    public Image getIcon(int type) {
        return ImageUtilities.loadImage(FOLDER);
    }

    @Override
    public Image getOpenedIcon(int type) {
        return getIcon(type);
    }
    
    

}
