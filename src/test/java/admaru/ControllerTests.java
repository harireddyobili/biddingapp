package admaru;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.http.codec.json.Jackson2JsonDecoder;
import admaru.controllersandservices.BidResponseData;
import admaru.controllersandservices.DSP1Server;
import admaru.controllersandservices.DSP2Server;
import admaru.controllersandservices.SSPServer;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import org.springframework.http.MediaType;


import org.bson.Document;

@WebFluxTest(controllers = {DSP1Server.class, DSP2Server.class, SSPServer.class})
public class ControllerTests {

    @Autowired
    private WebTestClient webClient;

    @MockBean
    private ReactiveMongoTemplate reactiveMongoTemplate; // Mocking MongoDB interactions

    @MockBean
    private WebClient.Builder webClientBuilder; // Mocking WebClient interactions

    @Test
    public void testGetBidResponsesFromDSP1() {
    	
        System.out.println("Success");
        // Define mock data for DSP1
        Document mockResponse = new Document("key", "value");
        Flux<Document> mockFlux = Flux.just(mockResponse);

        // Mock MongoDB interaction
        Mockito.when(reactiveMongoTemplate.findAll(Document.class, "bidResponses1"))
               .thenReturn(mockFlux);

        // Perform the GET request to /dsp1/bidResponses and assert the response
        webClient.get()
                 .uri("/dsp1/bidResponses")
                 .exchange()
                 .expectStatus().isOk()
                 .expectBodyList(Document.class)
                 .isEqualTo(mockFlux.collectList().block());
        
        
        System.out.println("Success");
    }

    @Test
    public void testGetBidResponsesFromDSP2() {
        // Define mock data for DSP2
        Document mockResponse = new Document("key", "value");
        Flux<Document> mockFlux = Flux.just(mockResponse);

        // Mock MongoDB interaction
        Mockito.when(reactiveMongoTemplate.findAll(Document.class, "bidResponses2"))
               .thenReturn(mockFlux);

        // Perform the GET request to /dsp2/bidResponses and assert the response
        webClient.get()
                 .uri("/dsp2/bidResponses")
                 .exchange()
                 .expectStatus().isOk()
                 .expectBodyList(Document.class)
                 .isEqualTo(mockFlux.collectList().block());
    }
    @Test
    public void testGetHighestBid() {
        // Define a mock BidResponse object
    	   Mockito.when(webClientBuilder.baseUrl(Mockito.anyString())).thenReturn(webClientBuilder);
           Mockito.when(webClientBuilder.build()).thenReturn((WebClient) Mockito.mock(WebClient.Builder.class));

           // Perform the GET request to /ssp/highestBid and assert the response
           webClient.get()
                    .uri("/ssp/highestBid")
                    .accept(MediaType.APPLICATION_JSON)
                    .exchange()
                    .expectStatus().isOk(); 
    }

}
