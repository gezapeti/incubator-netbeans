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

package org.netbeans.modules.debugger.delegatingview;

import org.netbeans.modules.debugger.support.DebuggerModule;
import org.netbeans.modules.debugger.support.nodes.ExplorerViewSupport;
import org.netbeans.modules.debugger.support.nodes.DebuggerNode;

import javax.swing.ImageIcon;
import java.awt.Image;

public class WatchesView extends ExplorerViewSupport {

    public WatchesView () {
        super (false);
    }

    public String getRootNode () {
        return DebuggerModule.WATCHES_ROOT_NODE;
    }

    public String getName () {
        return DebuggerNode.getLocalizedString ("CTL_Watches_view");
    }

    public Image getIcon () {
        return new ImageIcon (WatchesView.class.getResource (
            "/org/netbeans/core/resources/watches.gif" // NOI18N
        )).getImage ();
    }
}
