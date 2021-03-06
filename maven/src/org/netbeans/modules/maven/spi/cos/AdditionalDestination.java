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

package org.netbeans.modules.maven.spi.cos;

import org.openide.filesystems.FileObject;

/**
 * a callback intended for maven.j2ee module that intercepts the copy on save behaviour
 * and allows copying of resources into the expanded web application.
 * maven.j2ee icludes the implementation class in the lookup of maven web projects.
 * @author mkleint
 */
public interface AdditionalDestination {

    public void copy(FileObject fo, String path);

    public void delete(FileObject fo, String path);

}
