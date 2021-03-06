package com.github.ernysent.yggdrasil.data;

import com.github.ernysent.yggdrasil.domain.Worker;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkerRepository extends CrudRepository<Worker, Long> {
    public Worker findByLastName(String lastName);

    public Worker findByLastNameAndFirstName(String lastName, String firstName);
}
