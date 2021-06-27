package pubsub.subscriber;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
public class Controller {
    @Autowired
    private SubscribeRepository subscribeRepo;
    @Autowired
    private PurchaseRepository purchaseRepo;
       
    @PostMapping(path = "/sendMes")
    public String collectData(@RequestBody String message) throws Exception{
    	System.out.println(message);
    	ObjectMapper objectMapper = new ObjectMapper();
    	Map<String, Object> map 
    	  = objectMapper.readValue(message, new TypeReference<Map<String,Object>>(){});
//    	SubscribeEntity pe = new SubscribeEntity();
//    	pe.setTs(System.currentTimeMillis());
//    	pe.setMsisdn("test");
//    	System.out.println(pe.equals(null));
//    	subscribeRepo.save(pe);
    	return "OK";
    }
}
