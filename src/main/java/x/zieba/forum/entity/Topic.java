package x.zieba.forum.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Size;

@Entity
public class Topic {
		
	@Id
	@GeneratedValue
	private Integer id;
	
	@Size(min=3, message = "Nazwa tematu musi mieæ minimum 3 znaki!")
	private String name;
	
	@OneToMany(mappedBy = "topic", cascade=CascadeType.REMOVE)
	private List<Post> posts;

	
	public List<Post> getPosts() {
		return posts;
	}

	public void setPosts(List<Post> posts) {
		this.posts = posts;
	}

	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
