package com.syllogos.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;

@Entity(name = "members")
@Table(name = "members")
@NamedQueries({
		@NamedQuery(name = Member.GET_MEMBER_BY_ID, query = "SELECT m from members as m WHERE m.id = :memberId")
})
public class Member {

	public static final String GET_MEMBER_BY_ID = "getMemberById";

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String firstName;

	private String lastName;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate dateOfBirth;

	private String className;

	@ManyToOne
	private RodoClass rodoClass;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public RodoClass getRodoClass() {
		return rodoClass;
	}

	public void setRodoClass(RodoClass rodoClass) {
		this.rodoClass = rodoClass;
	}
}
