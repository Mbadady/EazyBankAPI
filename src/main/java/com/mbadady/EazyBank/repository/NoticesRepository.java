package com.mbadady.EazyBank.repository;

import com.mbadady.EazyBank.entity.Notices;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface NoticesRepository extends JpaRepository<Notices, Long> {
    @Query(value = "from Notices where CURDATE() BETWEEN noticeBegDt AND noticeEndDt")
   List<Notices> findAllActiveNotices();
}
