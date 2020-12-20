package com.guoyawe.demo201217.screw;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Demo201217ScrewApplicationTests {
  @Autowired
  DocumentGeneration documentGeneration;

  @Test
  void contextLoads() {

    documentGeneration.generateDatabaseDocument();

  }

}
