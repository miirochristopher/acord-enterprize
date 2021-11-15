package com.acord;

import com.acord.entity.District;
import com.acord.entity.Parish;
import com.acord.entity.SubCounty;
import com.acord.entity.Village;
import com.acord.repositories.DistrictRepository;
import com.acord.repositories.ParishRepository;
import com.acord.repositories.SubCountyRepository;
import com.acord.repositories.VillageRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;

import java.util.HashSet;
import java.util.Set;

@SpringBootApplication(scanBasePackages = "com.acord")
public class AcordUgandaApplication extends SpringBootServletInitializer {
	private static final Logger log = LoggerFactory.getLogger(AcordUgandaApplication.class);
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(AcordUgandaApplication.class);
	}
	public static void main(String[] args) {
		SpringApplication.run(AcordUgandaApplication.class, args);
	}

	@Bean
	public CommandLineRunner init(
			DistrictRepository districtRepository,
			SubCountyRepository subCountyRepository,
			ParishRepository parishRepository,
			VillageRepository villageRepository) {
		return (args) -> {
			Village v1 = new Village();
			v1.setId(1L);
			v1.setName("Masonde");
			villageRepository.save(v1);
			log.info("Saved" + v1);

			Village v2 = new Village();
			v2.setId(2L);
			v2.setName("Nkondo");
			villageRepository.save(v2);

			Village v3 = new Village();
			v3.setId(3L);
			v3.setName("Kasambya");
			villageRepository.save(v3);

			Village v4 = new Village();
			v4.setId(4L);
			v4.setName("Kasimbi");
			villageRepository.save(v4);

			Village v5 = new Village();
			v5.setId(5L);
			v5.setName("Karama");
			villageRepository.save(v5);

			Parish p1 = new Parish();
			p1.setId(1L);
			p1.setName("Nkondo");
			Set<Village> p1villages = new HashSet<>();
			p1villages.add(v2);
			p1.setVillages(p1villages);
			parishRepository.save(p1);

			Parish p2 = new Parish();
			p2.setId(2L);
			p2.setName("Kisengwe");
			Set<Village> p2villages = new HashSet<>();
			p2villages.add(v1);
			p2villages.add(v3);
			p2.setVillages(p2villages);
			parishRepository.save(p2);

			Parish p3 = new Parish();
			p3.setId(3L);
			p3.setName("Buyanja");
			Set<Village> p3villages = new HashSet<>();
			p3villages.add(v4);
			p3villages.add(v5);
			p3.setVillages(p3villages);
			parishRepository.save(p3);

			SubCounty s1 = new SubCounty();
			s1.setId(1L);
			s1.setName("Bwanswa");
			Set<Parish> s1parishes = new HashSet<>();
			s1parishes.add(p1);
			s1.setParishes(s1parishes );
			subCountyRepository.save(s1);

			SubCounty s2 = new SubCounty();
			s2.setId(2L);
			s2.setName("Kisengwe");
			Set<Parish> s2parishes  = new HashSet<>();
			s2parishes.add(p2);
			s2.setParishes(s2parishes );
			subCountyRepository.save(s2);

			SubCounty s3 = new SubCounty();
			s3.setId(3L);
			s3.setName("Buyanja");
			Set<Parish> s3parishes  = new HashSet<>();
			s3parishes.add(p3);
			s3.setParishes(s3parishes);
			subCountyRepository.save(s3);

			District d1 = new District();
			d1.setId(1L);
			d1.setName("Kakumiro");
			Set<SubCounty> d1subcounties = new HashSet<>();
			d1subcounties.add(s1);
			d1subcounties.add(s2);
			d1.setSubcounties(d1subcounties);
			districtRepository.save(d1);

			District d2 = new District();
			d2.setId(2L);
			d2.setName("Kibaale");
			Set<SubCounty> d2subcounties = new HashSet<>();
			d2subcounties.add(s3);
			d2.setSubcounties(d2subcounties);
			districtRepository.save(d2);
		};
	}
}
