package io.atom.electron.cmd;

/**
 * Factory to call node-inspector.
 * @author schroeder
 */
class NodeInspectorCommandFactory extends AbstractCommandFactory{
    
    static final String INSPECTOR = "node-inspector";

    @Override
    protected Command createCommand() {
        return new DefaultCommand(createCommand(INSPECTOR), createArguments(INSPECTOR));
    }
    
}
