package com.acord.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import static javax.persistence.CascadeType.DETACH;
import static javax.persistence.CascadeType.MERGE;
import static javax.persistence.CascadeType.REFRESH;
import static javax.persistence.CascadeType.REMOVE;

@Getter
@Setter
@Entity
@RequiredArgsConstructor
@Table(name = "subcounty")
public class SubCounty implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "subcounty_id", nullable = false)
	private Long id;

	@Column(name = "subcounty_name")
	private String name;

	@ManyToOne
	@JoinColumn(name = "district_id")
	private District district;

	@OneToMany(cascade={MERGE, REMOVE, REFRESH, DETACH},
			fetch = FetchType.EAGER, mappedBy = "subcounty")
	private Set<Parish> parishes = new HashSet<>();

	public void setParishes(Set<Parish> parishes) {
		this.parishes = parishes;
		parishes.forEach(parish -> parish.setSubcounty(this));
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
	}
}