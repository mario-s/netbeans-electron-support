package io.atom.electron;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import org.netbeans.api.extexecution.ExecutionDescriptor;
import org.netbeans.api.extexecution.ExecutionService;
import org.netbeans.api.extexecution.ProcessBuilder;
import org.openide.DialogDisplayer;
import org.openide.NotifyDescriptor;
import org.openide.filesystems.FileObject;
import org.openide.loaders.DataObject;
import org.openide.awt.ActionID;
import org.openide.awt.ActionReference;
import org.openide.awt.ActionRegistration;
import org.openide.filesystems.FileUtil;
import org.openide.util.NbBundle;
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

    private static final String ELECTRON = "electron";

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
        String cmd = PreferencesAccess.Instance.getExe();
        if (cmd == null) {
            showError(getMessage("exe.missing"));
        } else {
            launch(cmd);
        }
    }

    private String getMessage(String key) {
        return NbBundle.getMessage(getClass(), key);
    }

    private void showError(String msg) {
        NotifyDescriptor notifyDescr = new NotifyDescriptor.Message(msg, NotifyDescriptor.ERROR_MESSAGE);
        DialogDisplayer.getDefault().notify(notifyDescr);
    }

   

    private void launch(String cmd) {
        TaskObserver observer = new TaskObserver(this);
        ProcessBuilder processBuilder = createProcessBuilder(cmd);
        ExecutionService service = ExecutionService.newService(processBuilder, descriptor, ELECTRON);
        observer.observe(service.run());
    }


    private ProcessBuilder createProcessBuilder(String cmd) {
        FileObject fo = context.getPrimaryFile();
        String[] args = new String[]{FileUtil.getFileDisplayName(fo)};

        ProcessBuilder processBuilder = ProcessBuilder.getLocal();
        processBuilder.setExecutable(cmd);
        processBuilder.setArguments(Arrays.asList(args));
        processBuilder.setRedirectErrorStream(true);

        return processBuilder;
    }
}
