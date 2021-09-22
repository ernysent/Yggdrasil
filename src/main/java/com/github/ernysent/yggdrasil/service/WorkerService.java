package com.github.ernysent.yggdrasil.service;

import com.github.ernysent.yggdrasil.data.WorkerRepository;
import com.github.ernysent.yggdrasil.domain.Worker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WorkerService {

    @Autowired
    WorkerRepository workerRepository;

    public void delete(Worker worker) {
        // Check
        workerRepository.delete(worker);
    }

    public Iterable<Worker> findAll() {
        return  workerRepository.findAll();
    }

    public void save(Worker worker) {
        workerRepository.save(worker);
    }

    public void deleteAll() {
        workerRepository.deleteAll();
    }

    public Worker finByLastName(String lastName) {
        return workerRepository.findByLastName(lastName);
    }

    public Worker findByLastNameAndFirstName(String lastName, String firstName) {
        return workerRepository.findByLastNameAndFirstName(lastName,firstName);
    }
}
