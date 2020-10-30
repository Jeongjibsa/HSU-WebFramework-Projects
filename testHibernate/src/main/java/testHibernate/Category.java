package testHibernate;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
@Table(name = "category")
public class Category {

	@Id
	@GeneratedValue
	private int id;

	private String name;

	@OneToMany(mappedBy = "category", cascade = CascadeType.ALL, fetch=FetchType.EAGER)
	private Set<Product> products = new HashSet<>();
}
