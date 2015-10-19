package org.netbeans.modules.atom.electron.cmd;

import org.netbeans.modules.atom.electron.glue.Preferences;

/**
 * Factory for the run command
 * @author spindizzy
 */
class ElectronRunCommandFactory extends AbstractCommandFactory{
    static final String ELECTRON = "electron";
    
    private final Preferences preferences;

    public ElectronRunCommandFactory(Preferences preferences) {
        this.preferences = preferences;
    }
    
    @Override
    protected Command createCommand() {
        return new DefaultCommand(createElectronCommand(), createArguments(ELECTRON));
    }
    
    protected String createElectronCommand() {
        String exe = getExecutable();
        if (exe == null) {
            exe = createCommand(ELECTRON);
        }
        return exe;
    }

    private String getExecutable() {
        return (preferences != null) ? preferences.getExecutable() : null;
    }

    protected Preferences getPreferences() {
        return preferences;
    }
}
