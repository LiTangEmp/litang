package com.hyx.controller;

import com.hyx.pojo.repository.AccessRecordRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/ip")
public class IpController {

    @Autowired
    private AccessRecordRepository accessRecordRepository;

    @GetMapping("/visits")
    public ResponseEntity<List<String>> getVisits() {
        try {
            LocalDateTime oneWeekAgo = LocalDateTime.now().minusDays(7);
            List<String> ips = accessRecordRepository.findDistinctIpsByVisitTimeAfter(oneWeekAgo);
            log.info("成功获取过去一周访问记录");
            return ResponseEntity.ok(ips);
        } catch (Exception e) {
//            e.printStackTrace();
            log.error("获取访问记录失败", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
