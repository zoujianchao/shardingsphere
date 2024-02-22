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

package org.apache.shardingsphere.infra.database.opengauss.resultset;

import org.apache.shardingsphere.infra.database.core.resultset.DialectResultSetMapper;
import org.apache.shardingsphere.infra.database.core.spi.DatabaseTypedSPILoader;
import org.apache.shardingsphere.infra.database.core.type.DatabaseType;
import org.apache.shardingsphere.infra.spi.type.typed.TypedSPILoader;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Answers;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
class OpenGaussResultSetMapperTest {
    
    private final DialectResultSetMapper dialectResultSetMapper = DatabaseTypedSPILoader.getService(DialectResultSetMapper.class, TypedSPILoader.getService(DatabaseType.class, "openGauss"));
    
    @Mock(answer = Answers.RETURNS_DEEP_STUBS)
    private ResultSet resultSet;
    
    @Test
    void assertGetSmallintValue() throws SQLException {
        when(resultSet.getShort(1)).thenReturn((short) 0);
        assertThat(dialectResultSetMapper.getSmallintValue(resultSet, 1), is((short) 0));
    }
    
    @Test
    void assertGetDateValue() throws SQLException {
        when(resultSet.getDate(1)).thenReturn(new Date(0L));
        assertThat(dialectResultSetMapper.getDateValue(resultSet, 1), is(new Date(0L)));
    }
}
