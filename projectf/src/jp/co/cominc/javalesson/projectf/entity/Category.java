package jp.co.cominc.javalesson.projectf.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the CATEGORY database table.
 * 
 */
@Entity
@NamedQuery(name="Category.findAll", query="SELECT c FROM Category c")
public class Category implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private String name;

	//bi-directional many-to-one association to Mainmessage
	@OneToMany(mappedBy="category")
	private List<Mainmessage> mainmessages;

	public Category() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Mainmessage> getMainmessages() {
		return this.mainmessages;
	}

	public void setMainmessages(List<Mainmessage> mainmessages) {
		this.mainmessages = mainmessages;
	}

	public Mainmessage addMainmessage(Mainmessage mainmessage) {
		getMainmessages().add(mainmessage);
		mainmessage.setCategory(this);

		return mainmessage;
	}

	public Mainmessage removeMainmessage(Mainmessage mainmessage) {
		getMainmessages().remove(mainmessage);
		mainmessage.setCategory(null);

		return mainmessage;
	}

}