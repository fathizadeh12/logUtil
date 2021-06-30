package com.ali.logUtil.service;

import com.ali.logUtil.controller.model.LogRequest;
import com.ali.logUtil.controller.model.LogResponse;
import com.ali.logUtil.util.LoggerUtil;
import org.springframework.stereotype.Service;

@Service
public class LogUtilTestService {

    final LoggerUtil loggerUtil;

    public LogUtilTestService(LoggerUtil loggerUtil) {
        this.loggerUtil = loggerUtil;
    }

    public LogResponse logUtilServiceLayerMethod(LogRequest logRequest) {
        loggerUtil.logInput(logRequest, "logUtilServiceLayerMethod()", "this method description for input");
        LogResponse logResponse = new LogResponse();
        logRequest.setStr("Ok");
        loggerUtil.logOutput(logResponse, "logUtilServiceLayerMethod()", "this method description for output");
        return logResponse;
    }
}
