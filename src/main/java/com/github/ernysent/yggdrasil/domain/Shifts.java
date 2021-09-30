package com.github.ernysent.yggdrasil.domain;

import com.github.ernysent.yggdrasil.data.WorkerRepository;
import java.time.LocalDate;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

// JPA / Hibernate

@Entity
public class Shifts {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  private LocalDate data;

  @ManyToMany
  private List<Worker> worker;

  public Shifts(){}

  public Shifts(LocalDate date, List<Worker> worker){
    super();
    this.data = date;
    this.worker = worker;
  }

  public LocalDate getData(){return data;}
  public void setData(LocalDate date){this.data = date;}
  public List<Worker> getWorker(){return worker;}
  public void setWorker(List<Worker> worker){this.worker = worker;}

}
