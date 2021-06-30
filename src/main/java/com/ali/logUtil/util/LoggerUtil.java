package com.ali.logUtil.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class LoggerUtil {
    private static final Logger logger = LoggerFactory.getLogger(LoggerUtil.class);
    private ObjectMapper mapper = new ObjectMapper();

    @Async("defaultExecutor")
    public void log(Object object, String type, String methodName, String description) {
        try {
            String ObjToStr = mapper.writeValueAsString(object);
            if (type.equals("request")||type.equals("response")){
                logger.info("__called url: {},type: {},body: {},  description: {} ", methodName, type, ObjToStr, description);

            }else{

                logger.info("__methodName: {},type: {},body: {},  description: {} ", methodName, type, ObjToStr, description);
            }

        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }



    @Async("defaultExecutor")
    public void logHttpRequest(Object object, String url, String description) {
        log(object, "request", url, description);
    }

    @Async("defaultExecutor")
    public void logHttpResponse(Object object, String url, String description) {
        log(object, "response", url, description);
    }



    @Async("defaultExecutor")
    public void logInput(Object object, String methodName, String description) {
        log(object, "input", methodName, description);
    }

    @Async("defaultExecutor")
    public void logOutput(Object object, String methodName, String description) {
        log(object, "output", methodName, description);
    }

    @Async("defaultExecutor")
    public void logHeaders(Object object, String methodName, String description) {
        log(object, "input", methodName, description);
    }

    @Async("defaultExecutor")
    public void logWithError(String message, String type, String serviceName) {
        logger.error("service: {}, type: {}, body: {}", serviceName, type, message);
    }
}
