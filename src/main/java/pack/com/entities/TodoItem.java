package pack.com.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class TodoItem {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String category;
	private String name;
	private boolean complete;

	public TodoItem() {
	}

	public TodoItem(String category, String name, boolean complete) {
		super();
		this.category = category;
		this.name = name;
		this.complete = complete;
	}

	@Override
	public String toString() {
		return String.format("TodoItem[id=%d, category='%s', name='%s', complete='%b']", id, category, name, complete);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;

	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;

	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;

	}

	public boolean isComplete() {
		return complete;
	}

	public void setComplete(boolean complete) {
		this.complete = complete;

	}
}
