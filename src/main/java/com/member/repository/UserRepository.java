package com.member.repository;

import com.member.bean.users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<users, Integer> {
    // 可以在這裡添加自定義查詢方法
}
