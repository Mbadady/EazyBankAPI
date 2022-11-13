package com.mbadady.EazyBank.service.impl;

import com.mbadady.EazyBank.entity.Notices;
import com.mbadady.EazyBank.repository.NoticesRepository;
import com.mbadady.EazyBank.service.NoticesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoticeServiceImpl implements NoticesService {

    private NoticesRepository noticesRepository;

    @Autowired
    public NoticeServiceImpl(NoticesRepository noticesRepository) {
        this.noticesRepository = noticesRepository;
    }

    @Override
    public List<Notices> getNotices() {
       List<Notices> notices =  noticesRepository.findAllActiveNotices();
       if(notices != null){
           return notices;
       }
        return null;
    }
}
