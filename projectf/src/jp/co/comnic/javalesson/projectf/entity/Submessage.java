package jp.co.comnic.javalesson.projectf.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the SUBMESSAGE database table.
 * 
 */
@Entity
@NamedQuery(name="Submessage.findAll", query="SELECT s FROM Submessage s")
public class Submessage implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int serialid;

	@Lob
	private String message;

	@Temporal(TemporalType.DATE)
	private Date pdate;

	//bi-directional many-to-one association to Mainmessage
	@ManyToOne
	@JoinColumn(name="mainserialid")
	private Mainmessage mainmessage;

	public Submessage() {
	}

	public int getSerialid() {
		return this.serialid;
	}

	public void setSerialid(int serialid) {
		this.serialid = serialid;
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

	public Mainmessage getMainmessage() {
		return this.mainmessage;
	}

	public void setMainmessage(Mainmessage mainmessage) {
		this.mainmessage = mainmessage;
	}

}