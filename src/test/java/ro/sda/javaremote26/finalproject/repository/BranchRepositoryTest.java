package ro.sda.javaremote26.finalproject.repository;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;

import static org.junit.jupiter.api.Assertions.assertNotNull;

//@DataJpaTest
//@ExtendWith(SpringExtension.class)
@SpringBootTest
class BranchRepositoryTest {

    @Autowired
    private DataSource dataSource;

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void injectedComponentsAreNotNull(){
        assertNotNull(dataSource);
    }
}