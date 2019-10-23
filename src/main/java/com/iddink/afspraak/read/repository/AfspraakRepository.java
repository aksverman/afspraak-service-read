package com.iddink.afspraak.read.repository;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.iddink.afspraak.read.entity.Afspraak;

@Repository
public interface AfspraakRepository extends CrudRepository<Afspraak, String>{

}
