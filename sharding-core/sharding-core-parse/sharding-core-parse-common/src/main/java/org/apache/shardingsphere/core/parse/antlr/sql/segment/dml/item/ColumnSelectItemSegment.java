/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.shardingsphere.core.parse.antlr.sql.segment.dml.item;

import com.google.common.base.Optional;
import lombok.Setter;
import org.apache.shardingsphere.core.parse.antlr.sql.AliasAvailable;
import org.apache.shardingsphere.core.parse.antlr.sql.segment.dml.column.ColumnSegment;

/**
 * Column select item segment.
 * 
 * @author zhangliang
 */
@Setter
public final class ColumnSelectItemSegment extends ColumnSegment implements SelectItemSegment, AliasAvailable {
    
    private String alias;
    
    public ColumnSelectItemSegment(final String columnText, final int startIndex, final int stopIndex) {
        super(columnText, startIndex, stopIndex);
    }
    
    @Override
    public Optional<String> getAlias() {
        return Optional.fromNullable(alias);
    }
}
