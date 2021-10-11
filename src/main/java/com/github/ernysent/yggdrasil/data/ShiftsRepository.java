package com.github.ernysent.yggdrasil.data;

import com.github.ernysent.yggdrasil.domain.Shifts;
import com.github.ernysent.yggdrasil.domain.Worker;
import java.time.LocalDate;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShiftsRepository extends CrudRepository<Shifts, Long>{
  public Shifts findByDate(LocalDate date);

}
