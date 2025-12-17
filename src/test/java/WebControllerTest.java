
import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.WebTarget;
import jakarta.ws.rs.core.Response;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.mephi.WebController;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WebControllerTest {

    private Client client;
    private WebTarget target;
    private String GETResponse;

    @BeforeEach
    public void setUp() {
        this.client = ClientBuilder.newClient();
        this.target = client.target("http://localhost:8080/webapp");
        WebController controller = new WebController();
        this.GETResponse = controller.test();
    }

    @AfterEach
    public void clientClose() {
        if (client != null) {
            client.close();
        }
    }

    @Test
    public void testEndpointHasGetMethod() {
        Response response = target.path("/do/test")
                .request()
                .get();
        assertEquals(200, response.getStatus());
        assertEquals(GETResponse, response.readEntity(String.class));
    }
}
