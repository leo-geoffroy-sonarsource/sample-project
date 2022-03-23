package org.sonar.sampleproject.web;

import javax.sql.DataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DatabaseCheckRest {
  private final Logger logger = LoggerFactory.getLogger(DatabaseCheckRest.class);

  private final DataSource dataSource;

  public DatabaseCheckRest(DataSource dataSource) {
    this.dataSource = dataSource;
  }

  @GetMapping(value = "/check-database", produces = { "application/json" })
  @ResponseBody
  public ResponseEntity<ConnectionStatus> check() {
    try {
      dataSource.getConnection();
      return new ResponseEntity<>(new ConnectionStatus(DatabaseStatusEnum.OK, "Sample application is working with database"), HttpStatus.OK);
    } catch (Exception e) {
      logger.error("Error while getting result", e);
      return new ResponseEntity<>(new ConnectionStatus(DatabaseStatusEnum.KO, "Sample application is NOT working with database. Check logs.."), HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  public static class ConnectionStatus {
    DatabaseStatusEnum status;
    String message;

    public ConnectionStatus(DatabaseStatusEnum status, String message) {
      this.status = status;
      this.message = message;
    }

    public DatabaseStatusEnum getStatus() {
      return status;
    }

    public void setStatus(DatabaseStatusEnum status) {
      this.status = status;
    }

    public String getMessage() {
      return message;
    }

    public void setMessage(String message) {
      this.message = message;
    }
  }
}
