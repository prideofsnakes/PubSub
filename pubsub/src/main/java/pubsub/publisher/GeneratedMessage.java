package pubsub.publisher;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class GeneratedMessage {
	protected long msisdn;
	protected String action;
	protected long ts;
	private final String[] actions = {"PURCHASE", "SUBSCRIPTION"};
	
	GeneratedMessage(){
		this.ts = System.currentTimeMillis() / 1000;
		this.msisdn = randomizeMsisdn();
		this.action = randomizeAction(this.actions);
	}
	
	private long randomizeMsisdn() {
		
	    String numbers = "0123456789";
	    StringBuilder sb = new StringBuilder();

	    Random random = new Random();

	    int length = 10;

	    for(int i = 0; i < length; i++) {

	      int index = random.nextInt(numbers.length());
	      char randomChar = numbers.charAt(index);

	      sb.append(randomChar);
	    }

	    String randomString = sb.toString();
	    return Long.valueOf(randomString);
	  }
	
	private String randomizeAction(String [] actions) {
	    int rnd = new Random().nextInt(actions.length);
	    return actions[rnd];
	}
	
	public Map<String, Object> getMapValue(){
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("msisdn", this.msisdn);
		result.put("action", this.action);
		result.put("timestamp", this.ts);
		
		return result;
	}
}
