package org.netbeans.modules.atom.electron.project;

import org.netbeans.spi.project.ActionProvider;
import static org.netbeans.spi.project.ActionProvider.COMMAND_DELETE;
import org.netbeans.spi.project.ui.support.DefaultProjectOperations;
import org.openide.util.Lookup;

/**
 *
 * @author spindizzy
 */
final class ElectronActionsProvider implements ActionProvider{
    
    private final ElectronProject project;

    public ElectronActionsProvider(ElectronProject project) {
        this.project = project;
    }
    
    private static final String[] supportedActions = {
        COMMAND_RUN,
        COMMAND_DEBUG,
        COMMAND_TEST,
        COMMAND_DELETE
    };

    @Override
    public String[] getSupportedActions() {
        return supportedActions;
    }

    @Override
    public void invokeAction(String command, Lookup context) throws IllegalArgumentException {
        switch(command){
            case COMMAND_DELETE:
                DefaultProjectOperations.performDefaultDeleteOperation(project);
                break;
            default:
        }
    }

    @Override
    public boolean isActionEnabled(String command, Lookup context) throws IllegalArgumentException {
        return true;
    }
    
}
