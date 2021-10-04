package com.github.ernysent.yggdrasil.data;

import com.github.ernysent.yggdrasil.domain.Shifts;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShiftsRepository extends CrudRepository<Shifts, Long>{

}
