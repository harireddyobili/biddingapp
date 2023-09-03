package admaru.controllersandservices;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import org.bson.Document;
import org.springframework.http.HttpStatus;

@RestController
@RequestMapping("/dsp2")
public class DSP2Server {

	@Autowired
	private ReactiveMongoTemplate reactiveMongoTemplate;

	@GetMapping("/bidResponses")
	public ResponseEntity<Flux<Document>> getBidResponses() {
	    try {
	        Flux<Document> bidResponses = reactiveMongoTemplate.findAll(Document.class, "bidResponses2");
	        return ResponseEntity.ok(bidResponses);
	    } catch (Exception e) {
	        // Handle the exception or log the error
	        e.printStackTrace();
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
	    }
	}

}
