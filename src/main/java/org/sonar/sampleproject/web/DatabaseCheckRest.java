package org.sonar.sampleproject.web;

import java.sql.SQLException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import javax.sql.DataSource;
@RestController
public class DatabaseCheckRest {

  private final DataSource dataSource;

  public DatabaseCheckRest(DataSource dataSource) {
    this.dataSource = dataSource;
  }

  @GetMapping("/check-database")
  @ResponseBody
  public ResponseEntity<String> check() {
    try {
      dataSource.getConnection();
      return new ResponseEntity<>("Sample application is working", HttpStatus.OK);
    } catch (SQLException e) {
      return new ResponseEntity<>("Sample application is NOT working", HttpStatus.INTERNAL_SERVER_ERROR);
    }

  }

}
