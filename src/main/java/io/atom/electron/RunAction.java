package io.atom.electron;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import org.netbeans.api.extexecution.ExecutionDescriptor;
import org.netbeans.api.extexecution.ExecutionService;
import org.netbeans.api.extexecution.ExternalProcessBuilder;
import org.openide.filesystems.FileObject;
import org.openide.loaders.DataObject;
import org.openide.awt.ActionID;
import org.openide.awt.ActionReference;
import org.openide.awt.ActionRegistration;
import org.openide.filesystems.FileUtil;
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
public final class RunAction implements ActionListener {


    private final DataObject context;

    private final ExecutionDescriptor descriptor;

    public RunAction(DataObject context) {
        this.context = context;

        descriptor = new ExecutionDescriptor()
                .frontWindow(true).controllable(true);
    }

    @Override
    public void actionPerformed(ActionEvent ev) {
        String cmd = PreferencesAccess.Instance.getExe();
        FileObject fo = context.getPrimaryFile();
        String name = FileUtil.getFileDisplayName(fo);
        
        ExternalProcessBuilder processBuilder = new ExternalProcessBuilder(cmd).addArgument(name);
        ExecutionService service = ExecutionService.newService(processBuilder, descriptor, "electron");
        service.run();
    }

}
