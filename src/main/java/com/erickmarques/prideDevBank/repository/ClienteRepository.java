package com.erickmarques.prideDevBank.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.erickmarques.prideDevBank.entity.*;

@Repository
public interface ClienteRepository extends CrudRepository<ClienteEntity, Integer>{	

}
