package org.netbeans.modules.atom.electron.project;


import org.netbeans.spi.project.ActionProvider;
import static org.netbeans.spi.project.ActionProvider.COMMAND_DELETE;

import org.openide.filesystems.FileObject;
import org.openide.loaders.DataObject;
import org.openide.loaders.DataObjectNotFoundException;
import org.openide.util.Exceptions;
import org.openide.util.Lookup;

import static org.netbeans.spi.project.ui.support.DefaultProjectOperations.*;
import static org.netbeans.modules.atom.electron.actions.ElectronActionsPerformer.*;

/**
 *
 * @author spindizzy
 */
final class ElectronActionsProvider implements ActionProvider {

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
        switch (command) {
            case COMMAND_DELETE:
                performDefaultDeleteOperation(project);
                break;
            case COMMAND_RUN:
                performRunAction(getDataObject(project));
                break;
            case COMMAND_DEBUG:
                performDebugAction(getDataObject(
                        project));
                break;
            default:
        }
    }

    @Override
    public boolean isActionEnabled(String command, Lookup context) throws IllegalArgumentException {
        return true;
    }

    private DataObject getDataObject(ElectronProject project) {
        DataObject dao = null;

        PackagesFinder finder = new PackagesFinder(project.getProjectDirectory());
        FileObject fo = finder.getMainJs();

        if (fo != null) {
            try {
                dao = DataObject.find(fo);
            } catch (DataObjectNotFoundException ex) {
                Exceptions.printStackTrace(ex);
            }
        }
        return dao;
    }

}
