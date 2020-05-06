package pe.edu.upc.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Categoria")
public class CategoryProduct implements Serializable {


	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idCategory;
	@Column(name = "descriptionCategory", nullable = false, length = 45)
	private String descriptionCategory;

	public CategoryProduct() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CategoryProduct(int idCategory, String descriptionCategory) {
		super();
		this.idCategory = idCategory;
		this.descriptionCategory = descriptionCategory;
	}

	public int getIdCategory() {
		return idCategory;
	}

	public void setIdCategory(int idCategory) {
		this.idCategory = idCategory;
	}

	public String getDescriptionCategory() {
		return descriptionCategory;
	}

	public void setDescriptionCategory(String descriptionCategory) {
		this.descriptionCategory = descriptionCategory;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((descriptionCategory == null) ? 0 : descriptionCategory.hashCode());
		result = prime * result + idCategory;
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
		CategoryProduct other = (CategoryProduct) obj;
		if (descriptionCategory == null) {
			if (other.descriptionCategory != null)
				return false;
		} else if (!descriptionCategory.equals(other.descriptionCategory))
			return false;
		if (idCategory != other.idCategory)
			return false;
		return true;
	}

}