package com.ringside.repo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.ringside.domain.Record;

@Repository
public interface RecordRepo extends JpaRepository<Record,Long> {

//		@Query(value="SELECT * FROM person Where winner= ?1",nativeQuery = true)
//		List<Record> findByName(String winner);
		
	}

