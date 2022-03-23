package org.sonar.sampleproject.web;

import java.sql.SQLException;
import javax.sql.DataSource;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

class DatabaseCheckRestTest {

  @Test
  void testCheckDatabaseEndpointIsOKWhenConnectionIsUp(){
    DataSource mockDataSource = Mockito.mock(DataSource.class);
    DatabaseCheckRest subject = new DatabaseCheckRest(mockDataSource);
    ResponseEntity<String> responseEntity = subject.check();
    Assertions.assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
  }

  @Test
  void testCheckDatabaseEndpointIsNOKWhenConnectionDown() throws SQLException {
    DataSource mockDataSource = Mockito.mock(DataSource.class);
    Mockito.doThrow(new SQLException("Cannot connect")).when(mockDataSource).getConnection();
    DatabaseCheckRest subject = new DatabaseCheckRest(mockDataSource);
    ResponseEntity<String> responseEntity = subject.check();
    Assertions.assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.INTERNAL_SERVER_ERROR);
  }
}
