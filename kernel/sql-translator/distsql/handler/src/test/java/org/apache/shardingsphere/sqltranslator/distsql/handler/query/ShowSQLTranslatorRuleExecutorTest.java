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

package org.apache.shardingsphere.sqltranslator.distsql.handler.query;

import org.apache.shardingsphere.infra.merge.result.impl.local.LocalDataQueryResultRow;
import org.apache.shardingsphere.mode.manager.ContextManager;
import org.apache.shardingsphere.sqltranslator.api.config.SQLTranslatorRuleConfiguration;
import org.apache.shardingsphere.sqltranslator.distsql.statement.queryable.ShowSQLTranslatorRuleStatement;
import org.apache.shardingsphere.sqltranslator.rule.SQLTranslatorRule;
import org.junit.jupiter.api.Test;

import java.util.Collection;
import java.util.Iterator;
import java.util.Properties;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class ShowSQLTranslatorRuleExecutorTest {
    
    @Test
    void assertExecute() {
        ShowSQLTranslatorRuleExecutor executor = new ShowSQLTranslatorRuleExecutor();
        SQLTranslatorRule rule = mock(SQLTranslatorRule.class);
        when(rule.getConfiguration()).thenReturn(createSQLTranslatorRuleConfiguration());
        executor.setRule(rule);
        Collection<LocalDataQueryResultRow> actual = executor.getRows(mock(ShowSQLTranslatorRuleStatement.class), mock(ContextManager.class));
        assertThat(actual.size(), is(1));
        Iterator<LocalDataQueryResultRow> iterator = actual.iterator();
        LocalDataQueryResultRow row = iterator.next();
        assertThat(row.getCell(1), is("NATIVE"));
        assertThat(row.getCell(2), is(""));
        assertThat(row.getCell(3), is("true"));
    }
    
    private SQLTranslatorRuleConfiguration createSQLTranslatorRuleConfiguration() {
        return new SQLTranslatorRuleConfiguration("NATIVE", new Properties(), true);
    }
}