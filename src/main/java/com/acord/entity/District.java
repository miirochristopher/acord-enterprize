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
@Table(name = "district")
public class District implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "district_id", nullable = false)
	private Long id;

	@Column(name = "district_name")
	private String name;

	@OneToMany(cascade={MERGE, REMOVE, REFRESH, DETACH},
			fetch = FetchType.EAGER, mappedBy = "district")
	private Set<SubCounty> subcounties = new HashSet<>();

	public void setSubcounties(Set<SubCounty> subcounties) {
		this.subcounties = subcounties;
		subcounties.forEach(subcounty -> subcounty.setDistrict(this));
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
	}
}
