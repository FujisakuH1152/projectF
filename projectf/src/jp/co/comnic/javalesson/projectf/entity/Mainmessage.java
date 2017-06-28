package jp.co.comnic.javalesson.projectf.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the MAINMESSAGE database table.
 * 
 */
@Entity
@NamedQuery(name="Mainmessage.findAll", query="SELECT m FROM Mainmessage m")

public class Mainmessage implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id

	private int serialid;

	private String message;

	@Temporal(TemporalType.DATE)
	private Date pdate;

	private String subject;

	//bi-directional many-to-one association to Account
	@ManyToOne
	@JoinColumn(name="email")
	private Account account;

	//bi-directional many-to-one association to Category
	@ManyToOne
	@JoinColumn(name="categoryid")
	private Category category;

	//bi-directional many-to-one association to Submessage
	@OneToMany(mappedBy="mainmessage")
	private List<Submessage> submessages;

	public Mainmessage() {
	}
	
	public Mainmessage(int serialid, String message, Date pdate, String subject, Category category, Account account) {
		this.serialid = serialid;
		this.message = message;
		this.pdate = pdate;
		this.subject = subject;
		this.category = category;
		this.account = account;
				
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

	public String getSubject() {
		return this.subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public Account getAccount() {
		return this.account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public Category getCategory() {
		return this.category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public List<Submessage> getSubmessages() {
		return this.submessages;
	}

	public void setSubmessages(List<Submessage> submessages) {
		this.submessages = submessages;
	}

	public Submessage addSubmessage(Submessage submessage) {
		getSubmessages().add(submessage);
		submessage.setMainmessage(this);

		return submessage;
	}

	public Submessage removeSubmessage(Submessage submessage) {
		getSubmessages().remove(submessage);
		submessage.setMainmessage(null);

		return submessage;
	}

}