package io.atom.electron;

import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.netbeans.api.extexecution.ExecutionService;
import org.netbeans.api.extexecution.ProcessBuilder;
import org.openide.loaders.DataObject;
import org.openide.awt.ActionID;
import org.openide.awt.ActionReference;
import org.openide.awt.ActionRegistration;
import org.openide.util.NbBundle.Messages;

@ActionID(
        category = "Build",
        id = "io.atom.electron.RunAction"
)
@ActionRegistration(
        displayName = "#CTL_LaunchAction"
)
@ActionReference(path = "Loaders/text/javascript/Actions", position = 0)
@Messages("CTL_LaunchAction=Run with Electron")
public class RunAction extends AbstractElectronAction{

    public RunAction(DataObject context) {
        super(context);
    }

    @Override
    public void actionPerformed(ActionEvent ev) {
        ProcessBuilder processBuilder = createProcessBuilder();
        ExecutionService service = ExecutionService.newService(processBuilder, getDescriptor(), ELECTRON);
        createObserver().observe(service.run());
    }

    private ProcessBuilder createProcessBuilder() {
        List<String> args = new ArrayList<>();
        String exe = getPreferences().getExe();
        if (exe == null) {
            exe = getPreferences().getCommand();
            String[] prefArgs = getPreferences().getArguments();
            args.addAll(Arrays.asList(prefArgs));
        }

        args.add(getFileDisplayName());

        return createProcessBuilder(exe, args);
    }

}
