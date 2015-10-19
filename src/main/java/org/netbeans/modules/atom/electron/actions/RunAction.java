package org.netbeans.modules.atom.electron.actions;

import static org.netbeans.modules.atom.electron.cmd.AbstractCommandFactory.createCommand;
import java.awt.event.ActionEvent;
import org.netbeans.api.extexecution.ExecutionService;
import org.openide.awt.ActionID;
import org.openide.awt.ActionReference;
import org.openide.awt.ActionReferences;
import org.openide.awt.ActionRegistration;
import org.openide.loaders.DataObject;
import org.openide.util.NbBundle.Messages;

@ActionID(
        category = "Build",
        id = "io.atom.electron.RunAction"
)
@ActionRegistration(
        displayName = "#CTL_RunAction"
)
@ActionReferences({
    @ActionReference(path = "Shortcuts", name = "C-F6"),
    @ActionReference(path = "Loaders/text/javascript/Actions", position = 655),
    @ActionReference(path = "Editors/text/javascript/Popup", position = 5055)
})
@Messages("CTL_RunAction=Run with Electron")
public class RunAction extends AbstractElectronAction {
    private static final String PROCESS_NAME = "Electron";

    public RunAction(DataObject context) {
        super(context);
        DefaultCommandType type = createCommandType(DefaultCommandType.Type.ELECTRON_RUN);
        setCommand(createCommand(type));
    }

    @Override
    public void actionPerformed(ActionEvent ev) {
        ExecutionService service = ExecutionService.newService(createProcessBuilder(), getDescriptor(), PROCESS_NAME);
        createObserver().observe(service.run());
    }
}
