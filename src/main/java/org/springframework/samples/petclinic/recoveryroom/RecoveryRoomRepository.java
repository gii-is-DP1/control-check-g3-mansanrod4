package org.springframework.samples.petclinic.recoveryroom;

import java.util.List;
import java.util.Optional;

import org.springframework.dao.DataAccessException;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface RecoveryRoomRepository extends CrudRepository<RecoveryRoom, Integer>{
    List<RecoveryRoom> findAll();
    
	@Query("SELECT rrType FROM RecoveryRoomType rrType ORDER BY rrType.name")
    List<RecoveryRoomType> findAllRecoveryRoomTypes() throws DataAccessException;

    Optional<RecoveryRoom> findById(int id);
    RecoveryRoom save(RecoveryRoom p);
    //RecoveryRoomType getRecoveryRoomType(String name);
    //List<RecoveryRoom> findBySizeMoreThan(double size);
}
