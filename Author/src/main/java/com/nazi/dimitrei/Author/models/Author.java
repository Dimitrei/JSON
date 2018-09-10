package com.nazi.dimitrei.Author.models;

public class Author {

	private String key;
	private String name;
	private String manaCost;
	private AuthorTypes types;
	private String imageName;	
	
	public Author() {
	}

	public Author(String key, String name, String manaCost,  AuthorTypes types,
			String imageName) {
		super();
		this.key = key;
		this.name = name;
		this.manaCost = manaCost;
		this.types = types;
		this.imageName = imageName;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getManaCost() {
		return manaCost;
	}

	public void setManaCost(String manaCost) {
		this.manaCost = manaCost;
	}

	public AuthorTypes getTypes() {
		return types;
	}

	public void setTypes(AuthorTypes types) {
		this.types = types;
	}

	public String getImageName() {
		return imageName;
	}

	public void setImageName(String imageName) {
		this.imageName = imageName;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((imageName == null) ? 0 : imageName.hashCode());
		result = prime * result + ((key == null) ? 0 : key.hashCode());
		result = prime * result + ((manaCost == null) ? 0 : manaCost.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((types == null) ? 0 : types.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Author other = (Author) obj;
		if (imageName == null) {
			if (other.imageName != null)
				return false;
		} else if (!imageName.equals(other.imageName))
			return false;
		if (key == null) {
			if (other.key != null)
				return false;
		} else if (!key.equals(other.key))
			return false;
		if (manaCost == null) {
			if (other.manaCost != null)
				return false;
		} else if (!manaCost.equals(other.manaCost))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (types == null) {
			if (other.types != null)
				return false;
		} else if (!types.equals(other.types))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Author [key=" + key + ", name=" + name + ", manaCost=" + manaCost + ", types=" + types + ", imageName="
				+ imageName + "]";
	}

	
}
