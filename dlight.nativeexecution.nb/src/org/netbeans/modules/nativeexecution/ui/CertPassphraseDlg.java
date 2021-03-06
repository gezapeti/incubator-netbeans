/**
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

/*
 * CertPassphraseDlg.java
 *
 * Created on 02.04.2010, 18:22:00
 */
package org.netbeans.modules.nativeexecution.ui;

import java.awt.Dialog;
import org.netbeans.modules.nativeexecution.api.ExecutionEnvironment;
import org.netbeans.modules.nativeexecution.spi.support.PasswordProvider;
import org.openide.DialogDescriptor;
import org.openide.DialogDisplayer;
import org.openide.awt.Mnemonics;
import org.openide.util.NbBundle;

/**
 *
 * @author ak119685
 */
public class CertPassphraseDlg extends javax.swing.JPanel implements PromptPasswordDialog, PasswordProvider {

    /** Creates new form CertPassphraseDlg */
    public CertPassphraseDlg() {
        initComponents();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tfHost = new javax.swing.JTextField();
        promptLabel = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel0 = new javax.swing.JLabel();
        tfPassword = new javax.swing.JPasswordField();
        tfUser = new javax.swing.JTextField();

        tfHost.setBackground(javax.swing.UIManager.getDefaults().getColor("Panel.background") /*NOI18N*/);
        tfHost.setEditable(false);
        tfHost.setText(null);
        tfHost.setFocusable(false);

        promptLabel.setLabelFor(tfPassword);
        org.openide.awt.Mnemonics.setLocalizedText(promptLabel, org.openide.util.NbBundle.getMessage(CertPassphraseDlg.class, "CertPassphraseDlg.promptLabel.text")); // NOI18N
        promptLabel.setFocusable(false);

        jLabel1.setLabelFor(tfHost);
        jLabel1.setText(org.openide.util.NbBundle.getMessage(CertPassphraseDlg.class, "CertPassphraseDlg.jLabel1.text")); // NOI18N
        jLabel1.setFocusable(false);

        jLabel0.setLabelFor(tfUser);
        jLabel0.setText(org.openide.util.NbBundle.getMessage(CertPassphraseDlg.class, "CertPassphraseDlg.jLabel0.text")); // NOI18N
        jLabel0.setFocusable(false);

        tfPassword.setText(null);
        tfPassword.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                tfPasswordonPwdFocus(evt);
            }
        });

        tfUser.setBackground(javax.swing.UIManager.getDefaults().getColor("Panel.background") /*NOI18N*/);
        tfUser.setEditable(false);
        tfUser.setText(null);
        tfUser.setFocusable(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel0, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(tfHost, javax.swing.GroupLayout.DEFAULT_SIZE, 317, Short.MAX_VALUE)
                            .addComponent(tfUser, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 317, Short.MAX_VALUE)))
                    .addComponent(promptLabel)
                    .addComponent(tfPassword, javax.swing.GroupLayout.DEFAULT_SIZE, 372, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE, false)
                    .addComponent(jLabel0)
                    .addComponent(tfUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(tfHost, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(promptLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void tfPasswordonPwdFocus(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tfPasswordonPwdFocus
        tfPassword.selectAll();
}//GEN-LAST:event_tfPasswordonPwdFocus

    @Override
    public boolean askPassword(ExecutionEnvironment execEnv, String key) {
        Mnemonics.setLocalizedText(promptLabel, NbBundle.getMessage(CertPassphraseDlg.class, "CertPassphraseDlg.promptLabel.text", key)); // NOI18N

        tfUser.setText(execEnv.getUser());

        String hostName = execEnv.getHost();
        if (execEnv.getSSHPort() != 22) {
            hostName += ":" + execEnv.getSSHPort(); //NOI18N
        }
        tfHost.setText(hostName); // NOI18N

        DialogDescriptor dd = new DialogDescriptor(this,
                NbBundle.getMessage(CertPassphraseDlg.class, "CertPassphraseDlg.title.text"), // NOI18N
                true, // NOI18N
                new Object[]{
                    DialogDescriptor.OK_OPTION,
                    DialogDescriptor.CANCEL_OPTION},
                DialogDescriptor.OK_OPTION,
                DialogDescriptor.DEFAULT_ALIGN, null, null);

        Dialog dialog = DialogDisplayer.getDefault().createDialog(dd);
        dialog.setResizable(false);

        try {
            dialog.setVisible(true);
        } catch (Throwable th) {
            if (!(th.getCause() instanceof InterruptedException)) {
                throw new RuntimeException(th);
            }
            dd.setValue(DialogDescriptor.CANCEL_OPTION);
        } finally {
            dialog.dispose();
        }

        return dd.getValue() == DialogDescriptor.OK_OPTION;
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel0;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel promptLabel;
    private javax.swing.JTextField tfHost;
    private javax.swing.JPasswordField tfPassword;
    private javax.swing.JTextField tfUser;
    // End of variables declaration//GEN-END:variables

    @Override
    public char[] getPassword() {
        return tfPassword.getPassword();
    }

    @Override
    public void clearPassword() {
        tfPassword.setText(null);
    }

    @Override
    public boolean isRememberPassword() {
        return false;
    }
}
