package com.ali.logUtil.controller;

import com.ali.logUtil.controller.model.LogRequest;
import com.ali.logUtil.controller.model.LogResponse;
import com.ali.logUtil.service.LogUtilTestService;
import com.ali.logUtil.util.LoggerUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LogUtilTestController {

    final LogUtilTestService logUtilTestService;
    final LoggerUtil loggerUtil;

    @Autowired
    public LogUtilTestController(LogUtilTestService logUtilTestService, LoggerUtil loggerUtil) {
        this.logUtilTestService = logUtilTestService;
        this.loggerUtil = loggerUtil;
    }

    @PostMapping("/log")
    ResponseEntity<LogResponse> logUtilTestPostMethod(@RequestBody LogRequest logRequest) {
        loggerUtil.logHttpRequest(logRequest,"/log","this is description for request");
        LogResponse logResponse = logUtilTestService.logUtilServiceLayerMethod(logRequest);
        loggerUtil.logHttpResponse(logResponse,"/log","this is description for response");
        return ResponseEntity.ok(logResponse);

    }

}
