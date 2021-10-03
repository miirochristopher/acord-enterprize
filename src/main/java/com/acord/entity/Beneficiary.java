package com.acord.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.Hibernate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Objects;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
@Table(name = "beneficiary")
public class Beneficiary {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private Long id;

	@Column(name = "first_name")
	private String firstName;

	@Column(name = "given_name")
	private String givenName;

	@Column(name = "last_name")
	private String lastName;

	@Column(name = "age")
	private int age;

	@Column(name="gender")
	private String gender;

	@Column(name = "email")
	private String email;

	@Column(name = "contact")
	private String contact;

	@Column(name = "phone")
	private String phone;

	// Form
	@Column(name = "district")
	private String district;

	@Column(name = "sub_county")
	private String subCounty;

	@Column(name = "parish")
	private String parish;

	@Column(name = "village")
	private String village;

	@Column(name= "date_of_follow_up")
	private String dateOfFollowUp;

	@Column(name = "member_status")
	private String memberStatus;

	@Column(name = "health_facility")
	private String healthFacility;

	@Column(name = "adherence")
	private String adherence;

	@Column(name = "duration_on_treatment")
	private double durationOnTreatment;

	@Column(name = "regimen")
	private String regimen;

	@Column(name = "regimen_line")
	private String regimenLine;

	@Column(name = "action_to_be_taken")
	private String actionToBeTaken;

	@Column(name = "district_of_current_care")
	private String districtOfCurrentCare;

	@Column(name = "sub_county_of_current_care")
	private String subCountyOfCurrentCare;

	@Column(name = "comments")
	private String comments;

	// Form
	@Column(name = "data_collectors_name")
	private String dataCollectorsName;

	@Column(name = "data_collectors_title")
	private String dataCollectorsTitle;

	@Column(name = "data_collector_phone_number")
	private String dataCollectorsPhoneNumber;

	@Column(name = "data_assessor")
	private String dataAssessor;

	@Column(name = "data_entrant")
	private String dataEntrant;

	// Form
	@Column(name = "icyd_tool")
	private String icydTool;

	@Column(name = "house_hold_code")
	private String houseHoldCode;

	@Column(name = "viral_load_test_done")
	private String viralLoadTestDone;

	@Column(name= "date_of_next_viral_load_test")
	private String dateOfNextViralLoadTest;

	@Column(name = "follow_up_means")
	private String followUpMeans;

	@Column(name = "successfully_contacted")
	private String successfullyContacted;

	@Column(name="weight")
	private double weight;

	@Column(name = "on_art")
	private String onART;

	@Column(name= "date_of_art_initiation")
	private String dateOfARTInitiation;

	@Column(name= "date_of_last_clinic_visit")
	private String dateOfLastClinicVisit;

	@Column(name= "next_art_appointment_date")
	private String dateOfNextARTAppointment;

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o))
			return false;
		Beneficiary that = (Beneficiary) o;
		return Objects.equals(id, that.id);
	}

	@Override
	public int hashCode() {
		return 0;
	}
}