package io.atom.electron.cmd;

import io.atom.electron.Preferences;

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
        String exe = preferences.getExecutable();
        if (exe == null) {
            exe = createCommand(ELECTRON);
        }
        return exe;
    }

    protected Preferences getPreferences() {
        return preferences;
    }
}
