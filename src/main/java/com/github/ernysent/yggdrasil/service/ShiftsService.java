package com.github.ernysent.yggdrasil.service;

import com.github.ernysent.yggdrasil.data.ShiftsRepository;
import com.github.ernysent.yggdrasil.domain.Shifts;
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

  public void save(Shifts bigBang) {
    shiftsRepository.save(bigBang);
  }


}
