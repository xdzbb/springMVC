package com.mvc.entity;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Tuser entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "tuser")
public class Tuser implements java.io.Serializable {

	// Fields

	private Integer id;
	private String nickname;
	private String username;
	private String password;
	private String email;
	private Integer sex;
	private String tel;
	private String image;
	private Integer createtime;
	private Integer jointime;
	private Integer status;

	// Constructors

	/** default constructor */
	public Tuser() {
	}

	/** minimal constructor */
	public Tuser(Integer id, String nickname, String password) {
		this.id = id;
		this.nickname = nickname;
		this.password = password;
	}

	/** full constructor */
	public Tuser(Integer id, String nickname, String username, String password,
			String email, Integer sex, String tel, String image,
			Integer createtime, Integer jointime, Integer status) {
		this.id = id;
		this.nickname = nickname;
		this.username = username;
		this.password = password;
		this.email = email;
		this.sex = sex;
		this.tel = tel;
		this.image = image;
		this.createtime = createtime;
		this.jointime = jointime;
		this.status = status;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "nickname", nullable = false, length = 64)
	public String getNickname() {
		return this.nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	@Column(name = "username", length = 64)
	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Column(name = "password", nullable = false, length = 20)
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column(name = "email", length = 256)
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "sex")
	public Integer getSex() {
		return this.sex;
	}

	public void setSex(Integer sex) {
		this.sex = sex;
	}

	@Column(name = "tel", length = 20)
	public String getTel() {
		return this.tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	@Column(name = "image", length = 100)
	public String getImage() {
		return this.image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	@Column(name = "createtime")
	public Integer getCreatetime() {
		return this.createtime;
	}

	public void setCreatetime(Integer createtime) {
		this.createtime = createtime;
	}

	@Column(name = "jointime")
	public Integer getJointime() {
		return this.jointime;
	}

	public void setJointime(Integer jointime) {
		this.jointime = jointime;
	}

	@Column(name = "status")
	public Integer getStatus() {
		return this.status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

}