package org.netbeans.modules.atom.electron.project;

import org.netbeans.api.project.Project;
import org.netbeans.spi.project.ui.support.NodeFactory;
import org.netbeans.spi.project.ui.support.NodeList;

/**
 *
 * @author spindizzy
 */
@NodeFactory.Registration(projectType = "io-atom-electron-project", position = 10)
public class SourceNodeFactory implements NodeFactory {

    @Override
    public NodeList<?> createNodes(Project project) {
        ElectronProject ep = project.getLookup().lookup(ElectronProject.class);
        assert ep != null;
        return new SourceNodeList(ep);
    }
    
}
