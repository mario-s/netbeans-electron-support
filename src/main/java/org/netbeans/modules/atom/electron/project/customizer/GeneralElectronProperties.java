package org.netbeans.modules.atom.electron.project.customizer;

import javax.swing.JComponent;
import javax.swing.JPanel;
import org.netbeans.spi.project.ui.support.ProjectCustomizer;
import org.openide.util.Lookup;
import org.openide.util.NbBundle;

/**
 *
 * @author spindizzy
 */
public class GeneralElectronProperties implements ProjectCustomizer.CompositeCategoryProvider{
    private static final String GENERAL = "General";

    @ProjectCustomizer.CompositeCategoryProvider.Registration( projectType = "io-atom-electron-project", position = 10)
    public static GeneralElectronProperties createGeneral() {
        return new GeneralElectronProperties();
    }
    
    @NbBundle.Messages("LBL_Config_General=General")
    @Override
    public ProjectCustomizer.Category createCategory(Lookup context) {
        return ProjectCustomizer.Category.create( GENERAL, Bundle.LBL_Config_General(), null);
    }

    @Override
    public JComponent createComponent(ProjectCustomizer.Category category, Lookup context) {
        return new JPanel();
    }
    
}
