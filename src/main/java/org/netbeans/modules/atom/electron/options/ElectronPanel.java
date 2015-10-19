package org.netbeans.modules.atom.electron.options;

import org.netbeans.modules.atom.electron.glue.Preferences;
import org.netbeans.modules.atom.electron.cmd.Command;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import javax.swing.JFileChooser;
import javax.swing.SwingUtilities;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import org.openide.awt.HtmlBrowser.URLDisplayer;
import org.openide.util.Exceptions;
import org.openide.util.NbBundle;

import static org.netbeans.modules.atom.electron.cmd.AbstractCommandFactory.createCommand;
import org.netbeans.modules.atom.electron.glue.CommandType;
import org.netbeans.modules.atom.electron.glue.CommandType.Type;

final class ElectronPanel extends javax.swing.JPanel {

    private final String invalidPathMessage;

    private final ElectronOptionsPanelController controller;

    private final ElectronPreferences prefs;

    ElectronPanel(ElectronOptionsPanelController controller) {
        this.controller = controller;
        this.prefs = new ElectronPreferences();
        initComponents();

        txtPath.getDocument().addDocumentListener(new DocListener());
        invalidPathMessage = NbBundle.getMessage(ElectronPanel.class, "ElectronPanel.errLblPath.invalid");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblPath = new javax.swing.JLabel();
        txtPath = new javax.swing.JTextField();
        btnBrowse = new javax.swing.JButton();
        errLblPath = new javax.swing.JLabel();
        lblCmd = new javax.swing.JLabel();
        txtRunCmd = new javax.swing.JTextField();
        lblDebugPort = new javax.swing.JLabel();
        txtDebugPort = new javax.swing.JTextField();
        chkPause = new javax.swing.JCheckBox();
        jSeparator1 = new javax.swing.JSeparator();
        lblReq = new javax.swing.JLabel();
        lblNodeInspec = new javax.swing.JLabel();
        lblDebugUrl = new javax.swing.JLabel();
        txtDebugUrl = new javax.swing.JTextField();

        lblPath.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        org.openide.awt.Mnemonics.setLocalizedText(lblPath, org.openide.util.NbBundle.getMessage(ElectronPanel.class, "ElectronPanel.lblPath.text")); // NOI18N

        txtPath.setText(org.openide.util.NbBundle.getMessage(ElectronPanel.class, "ElectronPanel.txtPath.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(btnBrowse, org.openide.util.NbBundle.getMessage(ElectronPanel.class, "ElectronPanel.btnBrowse.text")); // NOI18N
        btnBrowse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBrowseActionPerformed(evt);
            }
        });

        errLblPath.setForeground(new java.awt.Color(255, 0, 0));
        org.openide.awt.Mnemonics.setLocalizedText(errLblPath, org.openide.util.NbBundle.getMessage(ElectronPanel.class, "ElectronPanel.errLblPath.text")); // NOI18N

        lblCmd.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        org.openide.awt.Mnemonics.setLocalizedText(lblCmd, org.openide.util.NbBundle.getMessage(ElectronPanel.class, "ElectronPanel.lblCmd.text")); // NOI18N

        txtRunCmd.setEditable(false);
        txtRunCmd.setText(org.openide.util.NbBundle.getMessage(ElectronPanel.class, "ElectronPanel.txtRunCmd.text")); // NOI18N

        lblDebugPort.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        org.openide.awt.Mnemonics.setLocalizedText(lblDebugPort, org.openide.util.NbBundle.getMessage(ElectronPanel.class, "ElectronPanel.lblDebugPort.text")); // NOI18N

        txtDebugPort.setText(org.openide.util.NbBundle.getMessage(ElectronPanel.class, "ElectronPanel.txtDebugPort.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(chkPause, org.openide.util.NbBundle.getMessage(ElectronPanel.class, "ElectronPanel.chkPause.text")); // NOI18N
        chkPause.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkPauseActionPerformed(evt);
            }
        });

        org.openide.awt.Mnemonics.setLocalizedText(lblReq, org.openide.util.NbBundle.getMessage(ElectronPanel.class, "ElectronPanel.lblReq.text")); // NOI18N

        lblNodeInspec.setForeground(new java.awt.Color(0, 0, 204));
        org.openide.awt.Mnemonics.setLocalizedText(lblNodeInspec, org.openide.util.NbBundle.getMessage(ElectronPanel.class, "ElectronPanel.lblNodeInspec.text")); // NOI18N
        lblNodeInspec.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblNodeInspec.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblNodeInspecMouseClicked(evt);
            }
        });

        org.openide.awt.Mnemonics.setLocalizedText(lblDebugUrl, org.openide.util.NbBundle.getMessage(ElectronPanel.class, "ElectronPanel.lblDebugUrl.text")); // NOI18N

        txtDebugUrl.setText(org.openide.util.NbBundle.getMessage(ElectronPanel.class, "ElectronPanel.txtDebugUrl.text")); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(lblReq)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblNodeInspec, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator1)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(lblDebugUrl)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(lblPath, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(lblDebugPort, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(lblCmd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(chkPause)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(txtDebugUrl, javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(errLblPath, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(txtPath, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 193, Short.MAX_VALUE)
                                            .addComponent(txtRunCmd, javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtDebugPort, javax.swing.GroupLayout.Alignment.LEADING))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnBrowse)))))
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCmd)
                    .addComponent(txtRunCmd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPath)
                    .addComponent(txtPath, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBrowse))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(errLblPath, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblReq)
                    .addComponent(lblNodeInspec, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDebugUrl)
                    .addComponent(txtDebugUrl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDebugPort)
                    .addComponent(txtDebugPort, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(chkPause)
                .addContainerGap(13, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnBrowseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBrowseActionPerformed
        JFileChooser fileChooser = new JFileChooser();
        int retVal = fileChooser.showOpenDialog(this);
        if (retVal == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            txtPath.setText(file.getAbsolutePath());
        }
    }//GEN-LAST:event_btnBrowseActionPerformed

    private void chkPauseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkPauseActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_chkPauseActionPerformed

    private void lblNodeInspecMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblNodeInspecMouseClicked
        try {
            URL url = new URL("https://github.com/node-inspector/node-inspector#quick-start");
            URLDisplayer.getDefault().showURL(url);
        } catch (IOException e) {
            Exceptions.printStackTrace(e);
        }
    }//GEN-LAST:event_lblNodeInspecMouseClicked

    void load() {
        txtRunCmd.setText(buildCommandText());
        txtPath.setText(prefs.getExecutable());
        txtDebugUrl.setText(prefs.getDebugUrl());
        txtDebugPort.setText(prefs.getDebugPort());
        chkPause.setSelected(prefs.isBreakOnFirstLine());
    }

    private String buildCommandText() {
        StringBuilder builder = new StringBuilder();
        Command cmd = createCommand(new CommandType() {

            @Override
            public Type getType() {
                return Type.ELECTRON_RUN;
            }

            @Override
            public Preferences getPreferences() {
                return null;
            }
        });
        builder.append(cmd.getExecutable()).append(" ");
        cmd.getArguments().forEach(s -> builder.append(s).append(" "));
        return builder.toString().trim();
    }

    void store() {
        prefs.setExecutable(txtPath.getText());
        prefs.setBreakOnFirstLine(chkPause.isSelected());
        prefs.setDebugUrl(txtDebugUrl.getText());
        prefs.setDebugPort(txtDebugPort.getText());
    }

    boolean valid() {
        File f = new File(txtPath.getText());
        return f.exists() && f.canRead();
    }

    private void updateErrors() {
        SwingUtilities.invokeLater(() -> {
            if (!valid()) {
                errLblPath.setText(invalidPathMessage);
            } else {
                errLblPath.setText("");
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBrowse;
    private javax.swing.JCheckBox chkPause;
    private javax.swing.JLabel errLblPath;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lblCmd;
    private javax.swing.JLabel lblDebugPort;
    private javax.swing.JLabel lblDebugUrl;
    private javax.swing.JLabel lblNodeInspec;
    private javax.swing.JLabel lblPath;
    private javax.swing.JLabel lblReq;
    private javax.swing.JTextField txtDebugPort;
    private javax.swing.JTextField txtDebugUrl;
    private javax.swing.JTextField txtPath;
    private javax.swing.JTextField txtRunCmd;
    // End of variables declaration//GEN-END:variables

    private class DocListener implements DocumentListener {

        @Override
        public void insertUpdate(DocumentEvent e) {
            changedUpdate(e);
        }

        @Override
        public void removeUpdate(DocumentEvent e) {
            changedUpdate(e);
        }

        @Override
        public void changedUpdate(DocumentEvent e) {
            updateErrors();
            controller.changed();
        }
    }
}