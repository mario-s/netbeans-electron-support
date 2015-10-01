package io.atom.electron;

import io.atom.electron.cmd.AbstractCommandFactory;
import io.atom.electron.cmd.AbstractCommandFactory.Type;
import java.awt.event.ActionEvent;
import java.net.MalformedURLException;
import java.net.URL;
import org.netbeans.api.extexecution.ExecutionDescriptor;
import org.netbeans.api.extexecution.ProcessBuilder;
import org.netbeans.api.extexecution.ExecutionService;
import org.netbeans.modules.extbrowser.ChromeBrowser;
import org.openide.awt.ActionID;
import org.openide.awt.ActionReference;
import org.openide.awt.ActionReferences;
import org.openide.awt.ActionRegistration;
import org.openide.awt.HtmlBrowser;
import org.openide.loaders.DataObject;
import org.openide.util.Exceptions;
import org.openide.util.NbBundle.Messages;

import static org.netbeans.api.extexecution.ExecutionService.newService;
import static io.atom.electron.cmd.AbstractCommandFactory.createCommand;
import io.atom.electron.cmd.Command;

@ActionID(
        category = "Build",
        id = "io.atom.electron.DebugAction"
)
@ActionRegistration(
        displayName = "#CTL_DebugAction"
)
@ActionReferences({
    @ActionReference(path = "Shortcuts", name = "S-C-F6"),
    @ActionReference(path = "Loaders/text/javascript/Actions", position = 665, separatorAfter = 667),
    @ActionReference(path = "Editors/text/javascript/Popup", position = 5065, separatorAfter = 5067)
})
@Messages("CTL_DebugAction=Debug with Electron")
public class DebugAction extends AbstractElectronAction {

    public DebugAction(DataObject context) {
        super(context);
    }

    @Override
    public void actionPerformed(ActionEvent ev) {
        try {
            URL url = buildDebugUrl();
            launchDebugger(); //1. start debugger
            launchRunAction(ev); //2. start app in debug mode
            createBrowser().setURL(url); //3. open chrome
        } catch (MalformedURLException ex) {
            Exceptions.printStackTrace(ex);
        }
    }

    @Override
    ExecutionDescriptor getDescriptor() {
        return super.getDescriptor().inputVisible(true);
    }

    void launchDebugger() {
        Command cmd = createCommand(Type.INSPECTOR);
        ProcessBuilder processBuilder = createProcessBuilder(cmd.getExecutable(),
                cmd.getArguments());
        ExecutionService service = newService(processBuilder,
                getDescriptor(), "node-inspector");
        service.run();
    }

    private URL buildDebugUrl() throws MalformedURLException {
        return new URL(getPreferences().getDebugUrl() + getDebugPort());
    }

    HtmlBrowser.Impl createBrowser() {
        ChromeBrowser browser = new ChromeBrowser();
        return browser.createHtmlBrowserImpl();
    }

    private String getDebugPort() {
        return getPreferences().getDebugPort();
    }

    //delegate to run action
    private void launchRunAction(ActionEvent ev) {
        AbstractElectronAction action = createRunAction();
        action.addProcessArguments(getPreferences().getElectronDebugArguments());
        action.actionPerformed(ev);
    }

    AbstractElectronAction createRunAction() {
        return new RunAction(getContext());
    }
}
