package com.hyx.pojo.repository;

import com.hyx.pojo.AccessRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface AccessRecordRepository extends JpaRepository<AccessRecord, Long> {

    @Query("SELECT DISTINCT ar.clientIp FROM AccessRecord ar WHERE ar.accessTime >= :oneWeekAgo")
    List<String> findDistinctIpsByVisitTimeAfter(@Param("oneWeekAgo") LocalDateTime oneWeekAgo);
}

