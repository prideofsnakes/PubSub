package pubsub.subscriber;

import java.util.Map;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;


@RestController
public class Controller {
	public static final Logger logger = Logger.getLogger(
			Controller.class.getName());
	
    @Autowired
    private SubscribeRepository subscribeRepo;
    @Autowired
    private PurchaseRepository purchaseRepo;
       
    @PostMapping(path = "/sendMes")
    public String collectData(@RequestBody String message) throws Exception{
    	logger.info("Message received:"+message);
    	ObjectMapper objectMapper = new ObjectMapper();
    	Map<String, Object> map 
    	  = objectMapper.readValue(message, new TypeReference<Map<String,Object>>(){});
    	
    	if (map.get("action").equals("PURCHASE")) {
        	PurchaseEntity pe = new PurchaseEntity();
        	pe.setTs((long)map.get("timestamp"));
        	pe.setMsisdn((long)map.get("msisdn"));
        	purchaseRepo.save(pe);
    	}
    	else {
        	SubscribeEntity se = new SubscribeEntity();
        	se.setTs((long)map.get("timestamp"));
        	se.setMsisdn((long)map.get("msisdn"));
        	subscribeRepo.save(se);
    	}
    	logger.info("Message stored to DB");
    	return "OK";
    }
}
