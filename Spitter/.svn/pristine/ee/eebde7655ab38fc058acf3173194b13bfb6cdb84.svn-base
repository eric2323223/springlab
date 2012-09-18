package com.john.springinaction.persistence;

import java.util.List;

import com.john.springinaction.domain.Spitter;
import com.john.springinaction.domain.Spittle;

public interface SpitterDao {
  void addSpitter(Spitter spitter);

  void saveSpitter(Spitter spitter);

  Spitter getSpitterById(long id);

  List<Spittle> getRecentSpittle();
  
  void saveSpittle(Spittle spittle);
  
  List<Spittle> getSpittlesForSpitter(Spitter spitter);

  Spitter getSpitterByUsername(String username);
  
  void deleteSpittle(long id);
  
  Spittle getSpittleById(long id);
  
  List<Spitter> findAllSpitters();
}
