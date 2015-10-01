package io.atom.electron.cmd;

/**
 * Factory for the run command
 * @author spindizzy
 */
class ElectronRunCommandFactory extends AbstractCommandFactory{
    static final String ELECTRON = "electron";

    @Override
    protected Command createCommand() {
        return new DefaultCommand(createCommand(ELECTRON), createArguments(ELECTRON));
    }
    
}
