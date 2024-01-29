package com.lbg.library.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lbg.library.domains.Item;

public interface ItemRepo extends JpaRepository<Item, Integer> {

}
