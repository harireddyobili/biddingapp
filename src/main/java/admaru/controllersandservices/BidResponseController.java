package admaru.controllersandservices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/bidResponses")
public class BidResponseController {

    @Autowired
    private MongoTemplate mongoTemplate;

    @PostMapping("/save1")
    public String saveBidResponse1(@RequestBody String json) {
        try {
          
            mongoTemplate.save(json, "bidResponses1");
            return "Bid response saved successfully";
        } catch (Exception e) {
            return "Failed to save bid response: " + e.getMessage();
        }
    }
    @PostMapping("/save2")
    public String saveBidResponse2(@RequestBody String json) {
        try {
            mongoTemplate.save(json, "bidResponses2");
            return "Bid response saved successfully";
        } catch (Exception e) {
            return "Failed to save bid response: " + e.getMessage();
        }
    }
}
