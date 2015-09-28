package io.atom.electron;

import java.awt.event.ActionEvent;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
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

    private static final String DEBUG_SWITCH = "--debug=";
    private static final String BRK_DEBUG_SWITCH = "--debug-brk=";

    public DebugAction(DataObject context) {
        super(context);
    }

    @Override
    public void actionPerformed(ActionEvent ev) {
        try {
            URL url = buildDebugUrl();
            
            launchDebugger();
            launchRunAction(ev);
            createBrowser().setURL(url);
        } catch (MalformedURLException ex) {
            Exceptions.printStackTrace(ex);
        }
    }

    void launchDebugger() {
        ProcessBuilder processBuilder = createProcessBuilder(getPreferences().getNodeDebugCommand(),
                getPreferences().getNodeDebugArguments());
        ExecutionService service = newService(processBuilder,
                getDescriptor(), ElectronPreferences.NODE_DEBUG);
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

        List<String> args = new ArrayList<>();
        if (getPreferences().isBreakOnFirstLine()) {
            args.add(DEBUG_SWITCH + getDebugPort());
        } else {
            args.add(BRK_DEBUG_SWITCH + getDebugPort());
        }
        action.addProcessArguments(args);

        action.actionPerformed(ev);
    }

    AbstractElectronAction createRunAction() {
        return new RunAction(getContext());
    }
}
