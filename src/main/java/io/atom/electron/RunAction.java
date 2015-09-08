package io.atom.electron;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.netbeans.api.extexecution.ExecutionDescriptor;
import org.netbeans.api.extexecution.ExecutionService;
import org.netbeans.api.extexecution.ProcessBuilder;
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
public class RunAction implements ActionListener {

    private static final String ELECTRON = "Electron";

    private final DataObject context;

    private final ExecutionDescriptor descriptor;

    public RunAction(DataObject context) {
        this.context = context;

        descriptor = new ExecutionDescriptor()
                .frontWindow(true)
                .frontWindowOnError(true)
                .controllable(true)
                .showProgress(true)
                .errLineBased(true);
    }

    @Override
    public void actionPerformed(ActionEvent ev) {
        ProcessBuilder processBuilder = createProcessBuilder();
        ExecutionService service = ExecutionService.newService(processBuilder, descriptor, ELECTRON);
        createObserver().observe(service.run());
    }

    TaskObserver createObserver() {
        return new TaskObserver(this);
    }

    String getFileDisplayName() {
        FileObject fo = context.getPrimaryFile();
        return FileUtil.getFileDisplayName(fo);
    }

    private ProcessBuilder createProcessBuilder() {
        List<String> args = new ArrayList<>();
        PreferencesAccess prefAccess = PreferencesAccess.Instance;
        String exe = prefAccess.getExe();
        if (exe == null) {
            exe = prefAccess.getCommand();
            String[] prefArgs = prefAccess.getArguments();
            args.addAll(Arrays.asList(prefArgs));
        }

        args.add(getFileDisplayName());

        ProcessBuilder processBuilder = ProcessBuilder.getLocal();
        processBuilder.setExecutable(exe);
        processBuilder.setArguments(args);
        processBuilder.setRedirectErrorStream(true);

        return processBuilder;
    }
}
