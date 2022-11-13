package com.mbadady.EazyBank.controller;

import com.mbadady.EazyBank.entity.Notices;
import com.mbadady.EazyBank.service.NoticesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.CacheControl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.concurrent.TimeUnit;

@RestController
public class NoticesController {

    @Autowired
    private NoticesService noticesService;

    @GetMapping("/notices")
    public ResponseEntity<List<Notices>> getNotices(){
        return ResponseEntity.ok().
                cacheControl(CacheControl.maxAge(60, TimeUnit.NANOSECONDS)).
                body(noticesService.getNotices());
    }
}
