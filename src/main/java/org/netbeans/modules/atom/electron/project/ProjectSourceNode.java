package org.netbeans.modules.atom.electron.project;

import java.awt.Image;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import javax.swing.Action;
import org.netbeans.api.annotations.common.StaticResource;
import org.netbeans.spi.project.ui.support.CommonProjectActions;
import org.openide.nodes.AbstractNode;
import org.openide.nodes.Index;
import org.openide.util.NbBundle;

import static org.openide.util.ImageUtilities.loadImage;
import static org.openide.util.ImageUtilities.mergeImages;

/**
 *
 * @author spindizzy
 */
class ProjectSourceNode extends AbstractNode {

    @StaticResource
    private static final String FOLDER = "org/netbeans/modules/atom/electron/project/folder.png";
    
    private static final String SRC_BADGE = "org/netbeans/modules/atom/electron/project/sources-badge.gif";

    public ProjectSourceNode() {
        super(new Index.ArrayChildren());
        
        String name = NbBundle.getMessage(ProjectSourceNode.class, "LBL_ProjectsRootNode_SrcFolder");
        setName(name);
        setDisplayName(name);
    }

    @Override
    public Image getOpenedIcon(int type) {
        return getIcon(type);
    }
    
    @Override
    public Image getIcon(int type) {
        return mergeImages(loadImage(FOLDER), loadImage(SRC_BADGE, false), 7, 7);
    }

    @Override
        public Action[] getActions(boolean arg0) {
           return new Action[]{
                CommonProjectActions.newFileAction()};
        }
}
