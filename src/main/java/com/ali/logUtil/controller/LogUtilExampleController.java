package com.ali.logUtil.controller;

import com.ali.logUtil.controller.model.LogRequest;
import com.ali.logUtil.controller.model.LogResponse;
import com.ali.logUtil.service.LogUtilExampleService;
import com.ali.logUtil.util.LoggerUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LogUtilExampleController {

    final LogUtilExampleService logUtilExampleService;
    final LoggerUtil loggerUtil;

    @Autowired
    public LogUtilExampleController(LogUtilExampleService logUtilExampleService, LoggerUtil loggerUtil) {
        this.logUtilExampleService = logUtilExampleService;
        this.loggerUtil = loggerUtil;
    }

    @PostMapping("/log")
    ResponseEntity<LogResponse> logUtilExamplePostMethod(@RequestBody LogRequest logRequest) {
        loggerUtil.logHttpRequest(logRequest,"/log","this is description for request");
        LogResponse logResponse = logUtilExampleService.logUtilServiceLayerMethod(logRequest);
        loggerUtil.logHttpResponse(logResponse,"/log","this is description for response");
        return ResponseEntity.ok(logResponse);

    }

}
