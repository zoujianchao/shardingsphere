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

package org.apache.shardingsphere.encrypt.distsql.statement;

import lombok.Getter;
import org.apache.shardingsphere.distsql.statement.rdl.rule.type.CreateRuleStatement;
import org.apache.shardingsphere.encrypt.distsql.segment.EncryptRuleSegment;

import java.util.Collection;

/**
 * Create encrypt rule statement.
 */
@Getter
public final class CreateEncryptRuleStatement extends CreateRuleStatement {
    
    private final Collection<EncryptRuleSegment> rules;
    
    public CreateEncryptRuleStatement(final boolean ifNotExists, final Collection<EncryptRuleSegment> rules) {
        super(ifNotExists);
        this.rules = rules;
    }
}