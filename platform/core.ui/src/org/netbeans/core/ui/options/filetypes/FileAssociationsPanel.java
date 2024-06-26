/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.netbeans.core.ui.options.filetypes;

import java.util.ArrayList;
import java.util.prefs.Preferences;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import org.netbeans.api.options.OptionsDisplayer;
import org.netbeans.core.ui.options.filetypes.FileAssociationsModel.MimeItem;
import org.netbeans.spi.options.OptionsPanelController;
import org.openide.DialogDescriptor;
import org.openide.DialogDisplayer;
import org.openide.util.NbBundle;
import org.openide.util.NbPreferences;

/** Options panel with extensions and associated MIME types.
 *
 * @author Jiri Skrivanek
 */
@OptionsPanelController.Keywords(keywords={"#KW_FilesOptions"}, location=OptionsDisplayer.ADVANCED, tabTitle="#AdvancedOption.displayName")
final class FileAssociationsPanel extends javax.swing.JPanel {

    private final FileAssociationsOptionsPanelController controller;
    private final String chooseExtensionItem;
    private NewExtensionPanel newExtensionPanel;
    private FileAssociationsModel model;
    private DocumentListener patternListener;
    // extensions added via the New button
    ArrayList<String> newlyAddedExtensions = new ArrayList<>();
    
    FileAssociationsPanel(FileAssociationsOptionsPanelController controller) {
        this.controller = controller;
        initComponents();
        chooseExtensionItem = NbBundle.getMessage(FileAssociationsPanel.class, "FileAssociationsPanel.cbExtension.choose"); // NOI18N
        patternListener = new PatternDocumentListener();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblExtension = new javax.swing.JLabel();
        cbExtension = new javax.swing.JComboBox();
        btnNew = new javax.swing.JButton();
        btnRemove = new javax.swing.JButton();
        lblType = new javax.swing.JLabel();
        cbType = new javax.swing.JComboBox();
        btnDefault = new javax.swing.JButton();
        lblAssociatedAlso = new javax.swing.JLabel();
        lblAssociatedAlsoExt = new javax.swing.JLabel();
        sepFileAssociations = new javax.swing.JSeparator();
        lblFileAssociations = new javax.swing.JLabel();
        lblFilesIgnored = new javax.swing.JLabel();
        setFilesIgnored = new javax.swing.JSeparator();
        lblPattern = new javax.swing.JLabel();
        btnDefaultIgnored = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtPattern = new javax.swing.JTextArea();
        txtPatternError = new javax.swing.JLabel();
        autoScan = new javax.swing.JCheckBox();
        lblScanning = new javax.swing.JLabel();
        setScanning = new javax.swing.JSeparator();
        ignoreHiddenInHome = new javax.swing.JCheckBox();

        setPreferredSize(new java.awt.Dimension(360, 360));

        lblExtension.setLabelFor(cbExtension);
        org.openide.awt.Mnemonics.setLocalizedText(lblExtension, org.openide.util.NbBundle.getMessage(FileAssociationsPanel.class, "FileAssociationsPanel.lblExtension.text")); // NOI18N

        cbExtension.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbExtensionActionPerformed(evt);
            }
        });

        org.openide.awt.Mnemonics.setLocalizedText(btnNew, org.openide.util.NbBundle.getMessage(FileAssociationsPanel.class, "FileAssociationsPanel.btnNew.text")); // NOI18N
        btnNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewActionPerformed(evt);
            }
        });

        org.openide.awt.Mnemonics.setLocalizedText(btnRemove, org.openide.util.NbBundle.getMessage(FileAssociationsPanel.class, "FileAssociationsPanel.btnRemove.text")); // NOI18N
        btnRemove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoveActionPerformed(evt);
            }
        });

        lblType.setLabelFor(cbType);
        org.openide.awt.Mnemonics.setLocalizedText(lblType, org.openide.util.NbBundle.getMessage(FileAssociationsPanel.class, "FileAssociationsPanel.lblType.text")); // NOI18N

        cbType.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbTypeActionPerformed(evt);
            }
        });

        org.openide.awt.Mnemonics.setLocalizedText(btnDefault, org.openide.util.NbBundle.getMessage(FileAssociationsPanel.class, "FileAssociationsPanel.btnDefault.text")); // NOI18N
        btnDefault.setToolTipText(org.openide.util.NbBundle.getMessage(FileAssociationsPanel.class, "FileAssociationsPanel.btnDefault.tooltip")); // NOI18N
        btnDefault.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDefaultActionPerformed(evt);
            }
        });

        lblAssociatedAlso.setLabelFor(lblAssociatedAlsoExt);
        org.openide.awt.Mnemonics.setLocalizedText(lblAssociatedAlso, org.openide.util.NbBundle.getMessage(FileAssociationsPanel.class, "FileAssociationsPanel.lblAssociatedAlso.text")); // NOI18N
        lblAssociatedAlso.setEnabled(false);

        lblAssociatedAlsoExt.setEnabled(false);
        lblAssociatedAlsoExt.setPreferredSize(new java.awt.Dimension(200, 14));

        org.openide.awt.Mnemonics.setLocalizedText(lblFileAssociations, org.openide.util.NbBundle.getMessage(FileAssociationsPanel.class, "FileAssociationsPanel.lblFileAssociations.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(lblFilesIgnored, org.openide.util.NbBundle.getMessage(FileAssociationsPanel.class, "FileAssociationsPanel.lblFilesIgnored.text")); // NOI18N

        lblPattern.setLabelFor(txtPattern);
        org.openide.awt.Mnemonics.setLocalizedText(lblPattern, org.openide.util.NbBundle.getMessage(FileAssociationsPanel.class, "FileAssociationsPanel.lblPattern.text")); // NOI18N
        lblPattern.setToolTipText(org.openide.util.NbBundle.getMessage(FileAssociationsPanel.class, "FileAssociationsPanel.lblPattern.tooltip")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(btnDefaultIgnored, org.openide.util.NbBundle.getMessage(FileAssociationsPanel.class, "FileAssociationsPanel.btnDefaultIgnored.text")); // NOI18N
        btnDefaultIgnored.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDefaultIgnoredActionPerformed(evt);
            }
        });

        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        txtPattern.setLineWrap(true);
        jScrollPane1.setViewportView(txtPattern);
        txtPattern.getAccessibleContext().setAccessibleParent(this);

        txtPatternError.setForeground(java.awt.Color.red);
        txtPatternError.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        txtPatternError.setFocusable(false);

        org.openide.awt.Mnemonics.setLocalizedText(autoScan, org.openide.util.NbBundle.getMessage(FileAssociationsPanel.class, "FileAssociationsPanel.autoScan.text", new Object[] {})); // NOI18N
        autoScan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                autoScanActionPerformed(evt);
            }
        });

        org.openide.awt.Mnemonics.setLocalizedText(lblScanning, org.openide.util.NbBundle.getMessage(FileAssociationsPanel.class, "FileAssociationsPanel.lblScanning.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(ignoreHiddenInHome, org.openide.util.NbBundle.getMessage(FileAssociationsPanel.class, "FileAssociationsPanel.ignoreHiddenInHome.text")); // NOI18N
        ignoreHiddenInHome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ignoreHiddenInHomeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblFileAssociations)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(sepFileAssociations))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblFilesIgnored)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(setFilesIgnored))
                    .addComponent(txtPatternError, javax.swing.GroupLayout.DEFAULT_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblScanning)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(setScanning))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblExtension)
                                    .addComponent(lblType))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(lblAssociatedAlso)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(lblAssociatedAlsoExt, javax.swing.GroupLayout.DEFAULT_SIZE, 1, Short.MAX_VALUE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(cbExtension, 0, 1, Short.MAX_VALUE)
                                            .addComponent(cbType, 0, 1, Short.MAX_VALUE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(btnNew)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(btnRemove))
                                            .addComponent(btnDefault)))))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblPattern)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnDefaultIgnored))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(ignoreHiddenInHome)
                                    .addComponent(autoScan))
                                .addGap(0, 0, Short.MAX_VALUE))))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(sepFileAssociations, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblFileAssociations))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNew)
                    .addComponent(cbExtension, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRemove)
                    .addComponent(lblExtension))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDefault)
                    .addComponent(lblType))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblAssociatedAlso)
                    .addComponent(lblAssociatedAlsoExt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(setFilesIgnored, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblFilesIgnored))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnDefaultIgnored)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblPattern))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(ignoreHiddenInHome)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(setScanning, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblScanning))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(autoScan)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtPatternError, javax.swing.GroupLayout.DEFAULT_SIZE, 49, Short.MAX_VALUE)
                .addContainerGap())
        );

        lblExtension.getAccessibleContext().setAccessibleName(org.openide.util.NbBundle.getMessage(FileAssociationsPanel.class, "FileAssociationsPanel.lblExtension.AN")); // NOI18N
        lblExtension.getAccessibleContext().setAccessibleDescription(org.openide.util.NbBundle.getMessage(FileAssociationsPanel.class, "FileAssociationsPanel.lblExtension.AD")); // NOI18N
        btnNew.getAccessibleContext().setAccessibleName(org.openide.util.NbBundle.getMessage(FileAssociationsPanel.class, "FileAssociationsPanel.btnNew.AN")); // NOI18N
        btnNew.getAccessibleContext().setAccessibleDescription(org.openide.util.NbBundle.getMessage(FileAssociationsPanel.class, "FileAssociationsPanel.btnNew.AD")); // NOI18N
        btnRemove.getAccessibleContext().setAccessibleName(org.openide.util.NbBundle.getMessage(FileAssociationsPanel.class, "FileAssociationsPanel.btnRemove.AN")); // NOI18N
        btnRemove.getAccessibleContext().setAccessibleDescription(org.openide.util.NbBundle.getMessage(FileAssociationsPanel.class, "FileAssociationsPanel.btnRemove.AD")); // NOI18N
        lblType.getAccessibleContext().setAccessibleName(org.openide.util.NbBundle.getMessage(FileAssociationsPanel.class, "FileAssociationsPanel.lblType.AN")); // NOI18N
        lblType.getAccessibleContext().setAccessibleDescription(org.openide.util.NbBundle.getMessage(FileAssociationsPanel.class, "FileAssociationsPanel.lblType.AD")); // NOI18N
        btnDefault.getAccessibleContext().setAccessibleName(org.openide.util.NbBundle.getMessage(FileAssociationsPanel.class, "FileAssociationsPanel.btnDefault.AN")); // NOI18N
        btnDefault.getAccessibleContext().setAccessibleDescription(org.openide.util.NbBundle.getMessage(FileAssociationsPanel.class, "FileAssociationsPanel.btnDefault.AD")); // NOI18N
        lblAssociatedAlso.getAccessibleContext().setAccessibleName(org.openide.util.NbBundle.getMessage(FileAssociationsPanel.class, "FileAssociationsPanel.lblAssociatedAlso.AN")); // NOI18N
        lblAssociatedAlso.getAccessibleContext().setAccessibleDescription(org.openide.util.NbBundle.getMessage(FileAssociationsPanel.class, "FileAssociationsPanel.lblAssociatedAlso.AD")); // NOI18N
        lblPattern.getAccessibleContext().setAccessibleName(org.openide.util.NbBundle.getMessage(FileAssociationsPanel.class, "FileAssociationsPanel.lblPattern.AN")); // NOI18N
        lblPattern.getAccessibleContext().setAccessibleDescription(org.openide.util.NbBundle.getMessage(FileAssociationsPanel.class, "FileAssociationsPanel.lblPattern.AD")); // NOI18N
        btnDefaultIgnored.getAccessibleContext().setAccessibleName(org.openide.util.NbBundle.getMessage(FileAssociationsPanel.class, "FileAssociationsPanel.btnDefaultIgnored.AN")); // NOI18N
        btnDefaultIgnored.getAccessibleContext().setAccessibleDescription(org.openide.util.NbBundle.getMessage(FileAssociationsPanel.class, "FileAssociationsPanel.btnDefaultIgnored.AD")); // NOI18N
        txtPatternError.getAccessibleContext().setAccessibleName(org.openide.util.NbBundle.getMessage(FileAssociationsPanel.class, "FileAssociationsPanel.txtPatternError.AN")); // NOI18N
        txtPatternError.getAccessibleContext().setAccessibleDescription(org.openide.util.NbBundle.getMessage(FileAssociationsPanel.class, "FileAssociationsPanel.txtPatternError.AD")); // NOI18N
    }// </editor-fold>//GEN-END:initComponents

    private void cbExtensionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbExtensionActionPerformed
        if(cbExtension.getSelectedItem() == null || chooseExtensionItem.equals(cbExtension.getSelectedItem().toString())) {
            return;
        } 
        String newExtension = cbExtension.getSelectedItem().toString();
        if(cbExtension.getItemAt(0).equals(chooseExtensionItem)) {
            // remove initial hint item
            cbExtension.removeItem(chooseExtensionItem);
        }
        // refuse to change xml extension MIME type (#171126)
        cbType.setEnabled(!newExtension.equalsIgnoreCase("xml")); //NOI18N
        cbType.setSelectedItem(model.getMimeItem(newExtension));
        btnRemove.setEnabled(model.canBeRemoved(newExtension));
    }//GEN-LAST:event_cbExtensionActionPerformed

    private void cbTypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbTypeActionPerformed
        if(cbType.getSelectedItem() == null || chooseExtensionItem.equals(cbExtension.getSelectedItem().toString())) {
            return;
        }
        String extension = cbExtension.getSelectedItem().toString();
        String newMimeType = ((MimeItem)cbType.getSelectedItem()).getMimeType();
        if(model.setMimeType(extension, newMimeType)) {
            fireChanged(extension, newMimeType);
        }
        btnDefault.setEnabled(model.canBeRestored(extension));
        lblAssociatedAlsoExt.setText(model.getAssociatedAlso(extension, newMimeType));
    }//GEN-LAST:event_cbTypeActionPerformed

    private void btnDefaultActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDefaultActionPerformed
        String extension = cbExtension.getSelectedItem().toString();
        model.setDefault(extension);
        btnDefault.setEnabled(false);
        cbType.setSelectedItem(model.getMimeItem(extension));
        fireChanged(extension, model.getMimeType(extension));
    }//GEN-LAST:event_btnDefaultActionPerformed

private void btnNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewActionPerformed
    if (newExtensionPanel == null) {
        newExtensionPanel = new NewExtensionPanel();
    }
    newExtensionPanel.setModel(model);
    DialogDescriptor dd = new DialogDescriptor(newExtensionPanel, NbBundle.getMessage(NewExtensionPanel.class, "NewExtensionPanel.title")); // NOI18N
    newExtensionPanel.addExtensionListener(dd); 
    
    DialogDisplayer.getDefault().createDialog(dd).setVisible(true);
    if (DialogDescriptor.OK_OPTION.equals (dd.getValue())) {
        newlyAddedExtensions.add(newExtensionPanel.getExtension());
        fireChanged(null, null);
        // add new extension to combo box and re-create
        ArrayList<String> newItems = new ArrayList<String>();
        for (int i = 0; i < cbExtension.getItemCount(); i++) {
            newItems.add(cbExtension.getItemAt(i).toString());
        }
        if(newItems.remove(chooseExtensionItem)) {
            // initial hint removed, so enable file types combo box
            cbType.setEnabled(true);
        }
        newItems.add(newExtensionPanel.getExtension());
        newItems.sort(String.CASE_INSENSITIVE_ORDER);
        cbExtension.removeAllItems();
        for (String item : newItems) {
            cbExtension.addItem(item);
        }
        cbExtension.setSelectedItem(newExtensionPanel.getExtension());
    }    
}//GEN-LAST:event_btnNewActionPerformed

private void btnRemoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoveActionPerformed
    String extension = cbExtension.getSelectedItem().toString();
    model.remove(extension);
    int selectedIndex = cbExtension.getSelectedIndex();
    cbExtension.removeItem(extension);
    if (cbExtension.getItemCount() > 0) {
        cbExtension.setSelectedIndex(Math.max(0, --selectedIndex));
    }
    newlyAddedExtensions.remove(extension);
    fireChanged(null, null);
}//GEN-LAST:event_btnRemoveActionPerformed

private void btnDefaultIgnoredActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDefaultIgnoredActionPerformed
    txtPattern.setText(IgnoredFilesPreferences.DEFAULT_IGNORED_FILES);
}//GEN-LAST:event_btnDefaultIgnoredActionPerformed

private void autoScanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_autoScanActionPerformed
    fireChanged(null, null);
}//GEN-LAST:event_autoScanActionPerformed

    private void ignoreHiddenInHomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ignoreHiddenInHomeActionPerformed
        fireChanged(null, null);
    }//GEN-LAST:event_ignoreHiddenInHomeActionPerformed

    void load() {
        cbExtension.removeAllItems();
        cbType.removeAllItems();
        cbType.setEnabled(false);
        btnDefault.setEnabled(false);
        btnRemove.setEnabled(false);
        lblAssociatedAlsoExt.setText(null);
        
        model = new FileAssociationsModel();
        // populate extension combo box
        cbExtension.addItem(chooseExtensionItem);
        for (String extension : model.getExtensions()) {
            cbExtension.addItem(extension);
        }
        // pupulate MIME type combo box
        for (MimeItem mimePair : model.getMimeItems()) {
            cbType.addItem(mimePair);
        }

        // load ignored files pattern
        txtPattern.getDocument().removeDocumentListener(patternListener);
        txtPattern.setText(IgnoredFilesPreferences.getIgnoredFiles());
        txtPattern.getDocument().addDocumentListener(patternListener);
        ignoreHiddenInHome.setSelected(IgnoredFilesPreferences.isIgnoreHiddenFilesInUserHome());
        btnDefaultIgnored.setEnabled(!IgnoredFilesPreferences.DEFAULT_IGNORED_FILES.equals(txtPattern.getText()));

        boolean manual = NbPreferences.root().node("org/openide/actions/FileSystemRefreshAction").getBoolean("manual", false); // NOI18N
        autoScan.setSelected(!manual);
    }
    
    void store() {
        newlyAddedExtensions.clear();
        // store file associations
        model.store();
        // store ignored files pattern
        IgnoredFilesPreferences.setIgnoredFiles(txtPattern.getText());
        IgnoredFilesPreferences.setIgnoreHiddenFilesInUserHome(ignoreHiddenInHome.isSelected());

        final Preferences nd = NbPreferences.root().node("org/openide/actions/FileSystemRefreshAction"); // NOI18N
        boolean manual = nd.getBoolean("manual", false);
        if (manual == autoScan.isSelected()) {
            nd.putBoolean("manual", !manual);  // NOI18N
        }
    }

    boolean valid() {
        // Check validity only for ignored files pattern because file associations
        // cannot get into invalid state.
        return IgnoredFilesPreferences.isValid(txtPattern.getText());
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox autoScan;
    private javax.swing.JButton btnDefault;
    private javax.swing.JButton btnDefaultIgnored;
    private javax.swing.JButton btnNew;
    private javax.swing.JButton btnRemove;
    private javax.swing.JComboBox cbExtension;
    private javax.swing.JComboBox cbType;
    private javax.swing.JCheckBox ignoreHiddenInHome;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblAssociatedAlso;
    private javax.swing.JLabel lblAssociatedAlsoExt;
    private javax.swing.JLabel lblExtension;
    private javax.swing.JLabel lblFileAssociations;
    private javax.swing.JLabel lblFilesIgnored;
    private javax.swing.JLabel lblPattern;
    private javax.swing.JLabel lblScanning;
    private javax.swing.JLabel lblType;
    private javax.swing.JSeparator sepFileAssociations;
    private javax.swing.JSeparator setFilesIgnored;
    private javax.swing.JSeparator setScanning;
    private javax.swing.JTextArea txtPattern;
    private javax.swing.JLabel txtPatternError;
    // End of variables declaration//GEN-END:variables


    private class PatternDocumentListener implements DocumentListener {

        public void insertUpdate(DocumentEvent e) {
            patternChanged();
        }

        public void removeUpdate(DocumentEvent e) {
            patternChanged();
        }

        public void changedUpdate(DocumentEvent e) {}

        /** Notify controller that property was changed and update status of components
         * handling ignored files pattern. */
        private void patternChanged() {
            fireChanged(null, null);
            btnDefaultIgnored.setEnabled(!IgnoredFilesPreferences.DEFAULT_IGNORED_FILES.equals(txtPattern.getText()));
            if(IgnoredFilesPreferences.getSyntaxError() != null) {
                txtPatternError.setText("<html><pre>" + IgnoredFilesPreferences.getSyntaxError() + "</pre></html>");  //NOI18N
            } else {
                txtPatternError.setText(null);
            }
        }
    }
    
    private void fireChanged(String extension, String mimeType) {
        boolean isChanged = false;
        if (extension == null) {
            isChanged |= !txtPattern.getText().equals(IgnoredFilesPreferences.getIgnoredFiles());

            isChanged |= ignoreHiddenInHome.isSelected() != IgnoredFilesPreferences.isIgnoreHiddenFilesInUserHome();

            boolean manual = NbPreferences.root().node("org/openide/actions/FileSystemRefreshAction").getBoolean("manual", false); // NOI18N
            isChanged |= autoScan.isSelected() == manual;

            isChanged |= !newlyAddedExtensions.isEmpty();
        } else {
            isChanged |= !model.isInitialExtensionToMimeMapping(extension, mimeType);
        }
        controller.changed(isChanged);
    }
}
