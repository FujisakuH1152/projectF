package jp.co.comnic.javalesson.projectf.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the SUBMESSAGE database table.
 * 
 */
@Entity
//@NamedQuery(name="Submessage.findAll", query="SELECT s FROM Submessage s")
public class Submessage implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int serialid;


	//bi-directional many-to-one association to Mainmessage
	@ManyToOne
	@JoinColumn(name="mainserialid")
	private Mainmessage mainmessage;
	
	@Lob
	private String message;

	@Temporal(TemporalType.DATE)
	private Date pdate;


	public Submessage() {
	}
	
	public Submessage(int serialid, Mainmessage mainmessage, String message, Date pdate) {
		this.serialid = serialid;
		this.mainmessage = mainmessage;
		this.message = message;
		this.pdate = pdate;
	}

	public int getSerialid() {
		return this.serialid;
	}

	public void setSerialid(int serialid) {
		this.serialid = serialid;
	}

	public Mainmessage getMainmessage() {
		return this.mainmessage;
	}

	public void setMainmessage(Mainmessage mainmessage) {
		this.mainmessage = mainmessage;
	}
	
	public String getMessage() {
		return this.message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Date getPdate() {
		return this.pdate;
	}

	public void setPdate(Date pdate) {
		this.pdate = pdate;
	}



}