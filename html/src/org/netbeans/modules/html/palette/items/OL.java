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

package org.netbeans.modules.html.palette.items;
import javax.swing.text.BadLocationException;
import javax.swing.text.JTextComponent;
import org.netbeans.modules.html.palette.HtmlPaletteUtilities;
import org.openide.text.ActiveEditorDrop;


/**
 *
 * @author Libor Kotouc
 */
public class OL implements ActiveEditorDrop {

    public static final int ITEM_COUNT_DEFAULT = 2;

    public static final String DEFAULT = "default"; // NOI18N
    public static final String ARABIC_NUMBERS = "1"; // NOI18N
    public static final String LOWER_ALPHA = "a"; // NOI18N
    public static final String UPPER_ALPHA = "A"; // NOI18N
    public static final String LOWER_ROMAN = "i"; // NOI18N
    public static final String UPPER_ROMAN = "I"; // NOI18N
    
    private String type = DEFAULT;
    private int count = ITEM_COUNT_DEFAULT;
    
    public OL() {
    }

    public boolean handleTransfer(JTextComponent targetComponent) {

        OLCustomizer c = new OLCustomizer(this);
        boolean accept = c.showDialog();
        if (accept) {
            String body = createBody();
            try {
                HtmlPaletteUtilities.insert(body, targetComponent);
            } catch (BadLocationException ble) {
                accept = false;
            }
        }
        
        return accept;
    }

    private String createBody() {
        
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < count; i++)
            sb.append("<li></li>\n"); // NOI18N
    
        String strType = "";
        if (!type.equals(DEFAULT))
            strType = " type=\"" + type + "\""; // NOI18N
        
        String oList = "<ol" + strType + ">\n" + sb.toString() + "</ol>\n"; // NOI18N
        
        return oList;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
        
}
