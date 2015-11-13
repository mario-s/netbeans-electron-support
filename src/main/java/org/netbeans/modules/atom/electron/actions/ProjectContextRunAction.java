package org.netbeans.modules.atom.electron.actions;

import java.awt.event.ActionEvent;
import org.netbeans.api.project.Project;
import org.openide.awt.ActionID;
import org.openide.awt.ActionReference;
import org.openide.awt.ActionRegistration;
import org.openide.util.NbBundle.Messages;

@ActionID(
        category = "Build",
        id = "org.netbeans.modules.atom.electron.actions.ProjectContextRunAction"
)
@ActionRegistration(
        displayName = "#CTL_ProjectContextRunAction"
)
@ActionReference(path="Projects/org-netbeans-modules-web-clientproject/Actions", position=710)
@Messages("CTL_ProjectContextRunAction=Run with Electron")
public final class ProjectContextRunAction extends AbstractElectronAction{

    private final Project context;

    public ProjectContextRunAction(Project context) {
        this.context = context;
    }

    @Override
    public void actionPerformed(ActionEvent ev) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    protected String getFileDisplayName() {
        throw new UnsupportedOperationException("Not supported yet."); 
    }
}
