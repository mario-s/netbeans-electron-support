/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.atom.electron;

import java.awt.event.ActionEvent;
import java.net.MalformedURLException;
import java.net.URL;
import org.netbeans.modules.extbrowser.ChromeBrowser;
import org.openide.loaders.DataObject;
import org.openide.awt.ActionID;
import org.openide.awt.ActionReference;
import org.openide.awt.ActionReferences;
import org.openide.awt.ActionRegistration;
import org.openide.awt.HtmlBrowser;
import org.openide.util.Exceptions;
import org.openide.util.NbBundle.Messages;

@ActionID(
        category = "Build",
        id = "io.atom.electron.DebugAction"
)
@ActionRegistration(
        displayName = "#CTL_DebugAction"
)
@ActionReferences({
    @ActionReference(path = "Loaders/text/javascript/Actions", position = 665, separatorAfter = 667),
    @ActionReference(path = "Editors/text/javascript/Popup", position = 5065, separatorAfter = 5067)
})
@Messages("CTL_DebugAction=Debug with Electron")
public final class DebugAction extends AbstractElectronAction{
    
    private ChromeBrowser browser;

    public DebugAction(DataObject context) {
        super(context);
        browser = new ChromeBrowser();
    }

    @Override
    public void actionPerformed(ActionEvent ev) {
        try {
            HtmlBrowser.Impl impl = browser.createHtmlBrowserImpl();
            URL url = new URL("http://www.google.com");
            impl.setURL(url);
        } catch (MalformedURLException ex) {
            Exceptions.printStackTrace(ex);
        }
       
    }
}
