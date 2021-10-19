package com.github.ernysent.yggdrasil.domain;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

// JPA / Hibernate

@Entity
public class Shifts {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  private LocalDate date;

  @ManyToMany(fetch = FetchType.EAGER)
  private List<Worker> workers = new ArrayList<>();

  public Shifts(){}

  public Shifts(LocalDate date, List<Worker> worker){
    super();
    this.date = date;
    this.workers = worker;
  }

  public LocalDate getData(){return date;}
  public void setData(LocalDate date){this.date = date;}
  public List<Worker> getWorkers(){return workers;}
  public void setWorkers(List<Worker> worker){this.workers = worker;}

  public void addWorker(Worker worker) {
    workers.add(worker);
  }

  public void deleteWorker(Worker worker){workers.remove(worker);}

  @Override
  public boolean equals(Object other) {
    if (id == null) {
      return super.equals(other);
    }

    return this == other || other instanceof Shifts && id.equals(((Shifts) other).id);
  }

  @Override
  public int hashCode(){
    StringBuilder builder = new StringBuilder();
    builder.append(id);
    return builder.toString().hashCode();
  }
}
