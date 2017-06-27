package jp.co.comnic.javalesson.projectf.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the ACCOUNT database table.
 * 
 */
@Entity
@NamedQuery(name="Account.findAll", query="SELECT a FROM Account a")
public class Account implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String email;

	private String password;

	private String username;

	//bi-directional many-to-one association to Mainmessage
	@OneToMany(mappedBy="account")
	private List<Mainmessage> mainmessages;

	public Account() {
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public List<Mainmessage> getMainmessages() {
		return this.mainmessages;
	}

	public void setMainmessages(List<Mainmessage> mainmessages) {
		this.mainmessages = mainmessages;
	}

	public Mainmessage addMainmessage(Mainmessage mainmessage) {
		getMainmessages().add(mainmessage);
		mainmessage.setAccount(this);

		return mainmessage;
	}

	public Mainmessage removeMainmessage(Mainmessage mainmessage) {
		getMainmessages().remove(mainmessage);
		mainmessage.setAccount(null);

		return mainmessage;
	}

}