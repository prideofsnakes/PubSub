package pubsub.subscriber;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "subscribe")
public class SubscribeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
 
    private String msisdn;
    private Timestamp ts;
    
    public void setMsisdn(String source) {
    	this.msisdn = source;
    }
    
    public void setMsisdn(Timestamp ts) {
    	this.ts = ts;
    }
}
