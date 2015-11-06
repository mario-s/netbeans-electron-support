package org.netbeans.modules.atom.electron.project.customizer;

import java.awt.Dialog;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import org.netbeans.api.project.Project;
import org.netbeans.api.project.ProjectUtils;
import org.netbeans.modules.atom.electron.project.ElectronProject;
import org.netbeans.spi.project.ui.CustomizerProvider;
import org.netbeans.spi.project.ui.support.ProjectCustomizer;
import org.openide.util.lookup.Lookups;

/**
 *
 * @author spindizzy
 */
public class ElectronCustomizerProvider implements CustomizerProvider {

    private static final String CUSTOMIZER_FOLDER_PATH = "Projects/io-atom-electron-project/Customizer";

    private final Project project;

    public ElectronCustomizerProvider(Project project) {
        this.project = project;
    }

    @Override
    public void showCustomizer() {
        Dialog dialog = ProjectCustomizer.createCustomizerDialog(
                //Path to layer folder: 
                CUSTOMIZER_FOLDER_PATH,
                //Lookup, which must contain, at least, the Project: 
                Lookups.fixed(project),
                //Preselected category: 
                "", 
                new OkOptionListener(),
                null);
        dialog.setTitle(ProjectUtils.getInformation(project).getDisplayName());
        dialog.setVisible(true);
    }

    private class OkOptionListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            throw new UnsupportedOperationException("Not supported yet.");
        }
    }
}
