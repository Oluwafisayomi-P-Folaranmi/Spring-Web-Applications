package com.example.study.repository;

import com.example.study.model.TacoOrder;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TacoOrderRepository extends CrudRepository<TacoOrder, Long> {

}
