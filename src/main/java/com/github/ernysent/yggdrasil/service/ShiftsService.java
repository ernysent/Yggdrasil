package com.github.ernysent.yggdrasil.service;

import com.github.ernysent.yggdrasil.data.ShiftsRepository;
import com.github.ernysent.yggdrasil.data.WorkerRepository;
import com.github.ernysent.yggdrasil.domain.Shifts;
import com.github.ernysent.yggdrasil.domain.Worker;
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

//  public List<Worker> findActive(){
//    List<Worker> workers = new ArrayList<>();
//    workerRepository.
//    return ;
//  }

  public void save(Shifts bigBang) {
    shiftsRepository.save(bigBang);
  }


}
