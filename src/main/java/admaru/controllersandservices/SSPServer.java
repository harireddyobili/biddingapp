package admaru.controllersandservices;


import java.util.List;
import org.springframework.http.codec.json.Jackson2JsonDecoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;


import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/ssp")
public class SSPServer {

    @Autowired
	public WebClient.Builder webClientBuilder;

    @GetMapping("/highestBid")
    public Mono<Object> getHighestBid() {
        // Configure the WebClient to handle JSON responses
        WebClient webClient = webClientBuilder.baseUrl("http://localhost:8080").build();
        webClient = webClient.mutate().codecs(configurer -> configurer.defaultCodecs().jackson2JsonDecoder(new Jackson2JsonDecoder())).build();

        // Call the DSP1 service endpoint to get bid responses
        Flux<BidResponseData> bidResponsesFromDSP1 = webClient
                .get()
                .uri("/dsp1/bidResponses")
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToFlux(BidResponseData.class);

        // Call the DSP2 service endpoint to get bid responses
        Flux<BidResponseData> bidResponsesFromDSP2 = webClient
                .get()
                .uri("/dsp2/bidResponses")
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToFlux(BidResponseData.class);

        // Merge the bid responses from both DSPs
        Flux<BidResponseData> mergedBidResponses = Flux.concat(bidResponsesFromDSP1, bidResponsesFromDSP2);

        // Find the highest bid response (you can replace this logic with your own)
        return mergedBidResponses
                .flatMap(bidResponse -> Flux.fromIterable(bidResponse.getSeatbid()))
                .flatMap(seatBid -> Flux.fromIterable(seatBid.getBid()))
                .reduce((maxBid, currentBid) -> {
                    if (currentBid.getPrice() > maxBid.getPrice()) {
                        return currentBid;
                    } else {
                        return maxBid;
                    }
                })
                .map(ResponseEntity::ok);
    }
}
