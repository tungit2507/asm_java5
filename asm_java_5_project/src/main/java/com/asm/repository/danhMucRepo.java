package com.asm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.asm.model.danhmuc;

@Repository
public interface danhMucRepo extends JpaRepository<danhmuc, String> {

}
