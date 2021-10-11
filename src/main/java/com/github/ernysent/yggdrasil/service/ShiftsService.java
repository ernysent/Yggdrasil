package com.github.ernysent.yggdrasil.service;

import com.github.ernysent.yggdrasil.data.ShiftsRepository;
import com.github.ernysent.yggdrasil.data.WorkerRepository;
import com.github.ernysent.yggdrasil.domain.Shifts;
import com.github.ernysent.yggdrasil.domain.Worker;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShiftsService {

  @Autowired
  ShiftsRepository shiftsRepository;

  public List<Shifts> findAll(){
    List<Shifts> shifts = new ArrayList<>();
    shiftsRepository.findAll().forEach(shifts::add);
    return shifts;
  }

  public void delete(Shifts shifts){
    shiftsRepository.delete(shifts);
  }


//  public List<Worker> findActive(){
//    List<Worker> workers = new ArrayList<>();
//    workerRepository.
//    return ;
//  }

  public boolean save(Shifts shift) {
    Shifts shiftsInRepo = findByDate(shift.getData());
    System.out.println("shiftsInRepo: " + shiftsInRepo);
    if (shiftsInRepo == null){
      shiftsRepository.save(shift);
      System.out.println("Saved");
      return true;
    } else {
      System.out.println("None");
      return false;
    }
  }

  public Shifts findByDate(LocalDate date){
    return shiftsRepository.findByDate(date);
  }


}
