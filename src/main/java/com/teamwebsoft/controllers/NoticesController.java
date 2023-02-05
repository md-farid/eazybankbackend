package com.teamwebsoft.controllers;

import com.teamwebsoft.models.Notice;
import com.teamwebsoft.repositories.NoticeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class NoticesController {

    @Autowired
    private NoticeRepository noticeRepository;

    @GetMapping("/notices")
    public List<Notice> getNoticesDetails(){
        List<Notice> notices = noticeRepository.findAllActiveNotices();
        if(notices != null){
            return notices;
        }
        else{
            return null;
        }
    }

}
