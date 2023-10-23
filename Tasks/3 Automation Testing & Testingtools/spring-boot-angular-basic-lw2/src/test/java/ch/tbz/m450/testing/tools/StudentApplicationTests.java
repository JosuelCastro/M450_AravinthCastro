package ch.tbz.m450.testing.tools;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class StudentApplicationTests {

	@LocalServerPort
        private int port;

        @Value("${server.servlet.context-path}")
        private String contextPath;

        @Before
        public void setUp() {
            RestAssured.port = port;
            RestAssured.basePath = contextPath;
        }

        @Test
        public void whenGetStudents_thenVerifySuccess() {
            given()
                    .when()
                    .get("/students")
                    .then()
                    .statusCode(HttpStatus.OK.value())
                    .body("", hasSize(greaterThanOrEqualTo(5)));
        }

        @Test
        public void whenAddStudent_thenVerifySuccess() {
            Student student = new Student("Test Student", "test@student.com");

            given()
                    .contentType(ContentType.JSON)
                    .body(student)
                    .when()
                    .post("/students")
                    .then()
                    .statusCode(HttpStatus.OK.value());
        }
}
