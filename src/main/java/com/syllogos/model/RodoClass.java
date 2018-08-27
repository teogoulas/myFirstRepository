package com.syllogos.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity(name = "rodoclasses")
@Table(name = "rodoclasses")
@javax.persistence.NamedQueries({
		@NamedQuery(name = RodoClass.GET_ALL_RODOCLASSES, query = "SELECT c FROM rodoclasses c"),
		@NamedQuery(name = RodoClass.GET_RODOCLASS_BY_NAME, query = "SELECT c FROM rodoclasses c WHERE c.className = :className"),
		@NamedQuery(name = RodoClass.GET_RODOCLASS_VIEW_BY_NAME, query = "SELECT new com.syllogos.model.RodoClassView(rc.className, rc.day, rc.time, rc.tutorName, rc.additionalInfo, rc.duration) " +
				"from rodoclasses as rc WHERE rc.className = :className"),
		@NamedQuery(name = RodoClass.GET_RODOCLASS_MEMBERS_VIEW, query = "SELECT new com.syllogos.model.MemberView(m.id, m.firstName, m.lastName, m.dateOfBirth) FROM rodoclasses AS rc, members as m " +
				"WHERE m.rodoClass.id = rc.id and rc.className = :className")
})
public class RodoClass {

	public static final String GET_ALL_RODOCLASSES = "getAllRodoClasses";

	public static final String GET_RODOCLASS_BY_NAME = "getRodoClassByName";

	public static final String GET_RODOCLASS_VIEW_BY_NAME = "getRodoClassViewByName";

	public static final String GET_RODOCLASS_MEMBERS_VIEW = "getRodoClassMembersView";

	@Id
	@GeneratedValue
	private Long id;

	private String className;

	private String day;

	private String time;

	private String tutorName;

	private String additionalInfo;

	private Integer memberCount;

	private Integer duration;

	@OneToMany(mappedBy = "rodoClass", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Member> Members = new ArrayList<Member>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public String getDay() {
		return day;
	}

	public void setDay(String day) {
		this.day = day;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getTutorName() {
		return tutorName;
	}

	public void setTutorName(String tutorName) {
		this.tutorName = tutorName;
	}

	public String getAdditionalInfo() {
		return additionalInfo;
	}

	public void setAdditionalInfo(String additionalInfo) {
		this.additionalInfo = additionalInfo;
	}

	public Integer getMemberCount() {
		return memberCount;
	}

	public void setMemberCount(Integer memberCount) {
		this.memberCount = memberCount;
	}

	public Integer getDuration() {
		return duration;
	}

	public void setDuration(Integer duration) {
		this.duration = duration;
	}

	public List<Member> getMembers() {
		return Members;
	}

	public void setMembers(List<Member> members) {
		Members = members;
	}
}
