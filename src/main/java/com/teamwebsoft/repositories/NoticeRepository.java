package com.teamwebsoft.repositories;

import com.teamwebsoft.models.Notice;
import jdk.jfr.Registered;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

@Registered
public interface NoticeRepository extends JpaRepository<Notice, Long> {
    @Query(value = "from Notice n where CURDATE() BETWEEN noticeBegDt AND noticeEndDt")
    List<Notice> findAllActiveNotices();
}
