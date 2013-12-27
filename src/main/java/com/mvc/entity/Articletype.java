package com.mvc.entity;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Articletype entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "articletype", catalog = "mvcdb")
public class Articletype implements java.io.Serializable {

	// Fields

	private Integer id;
	private String typename;
	private Set<Article> articles = new HashSet<Article>(0);

	// Constructors

	/** default constructor */
	public Articletype() {
	}

	/** minimal constructor */
	public Articletype(Integer id, String typename) {
		this.id = id;
		this.typename = typename;
	}

	/** full constructor */
	public Articletype(Integer id, String typename, Set<Article> articles) {
		this.id = id;
		this.typename = typename;
		this.articles = articles;
	}

	// Property accessors
	@Id
	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "typename", nullable = false, length = 256)
	public String getTypename() {
		return this.typename;
	}

	public void setTypename(String typename) {
		this.typename = typename;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "articletype")
	public Set<Article> getArticles() {
		return this.articles;
	}

	public void setArticles(Set<Article> articles) {
		this.articles = articles;
	}

}