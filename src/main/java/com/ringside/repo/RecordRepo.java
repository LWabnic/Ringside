package com.ringside.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;



@Repository
public interface RecordRepo extends JpaRepository<Record,Long> {

//	@Query(value="SELECT * FROM person Where winner= ?1",nativeQuery = true)
//	List<Record> findByName(String winner);
	
}
