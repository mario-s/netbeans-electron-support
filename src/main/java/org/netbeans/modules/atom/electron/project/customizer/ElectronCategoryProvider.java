package org.netbeans.modules.atom.electron.project.customizer;

import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import org.netbeans.spi.project.ui.support.ProjectCustomizer;
import org.openide.util.Lookup;
import org.openide.util.NbBundle;

/**
 *
 * @author spindizzy
 */
public class ElectronCategoryProvider implements ProjectCustomizer.CompositeCategoryProvider{
    private static final String CATEGORY = "Electron";

    @ProjectCustomizer.CompositeCategoryProvider.Registration( 
            projectType = "org.netbeans.modules.web.clientproject", 
            position = 500)
    public static ElectronCategoryProvider createElectron() {
        return new ElectronCategoryProvider();
    }
    
    @NbBundle.Messages("LBL_Config_General=Electron")
    @Override
    public ProjectCustomizer.Category createCategory(Lookup context) {
        return ProjectCustomizer.Category.create( CATEGORY, Bundle.LBL_Config_General(), null);
    }

    @Override
    public JComponent createComponent(ProjectCustomizer.Category category, Lookup context) {
        JPanel panel = new ElectronPanel();
        return panel;
    }
    
}
