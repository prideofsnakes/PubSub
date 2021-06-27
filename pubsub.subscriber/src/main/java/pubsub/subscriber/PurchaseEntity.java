package pubsub.subscriber;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "purchase")
public class PurchaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
 
    private long msisdn;
    private Timestamp ts;
    
    public void setMsisdn(long l) {
    	this.msisdn = l;
    }
    
    public void setTs(long tsLong) {
    	this.ts = new Timestamp(tsLong);
    }
}
