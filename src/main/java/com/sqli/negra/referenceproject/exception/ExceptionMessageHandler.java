package com.sqli.negra.referenceproject.exception;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@Getter @Setter
public class ExceptionMessageHandler {

    @Value("${data.store.exception}")
    private String dataStoreExceptionMessage;

    @Value("${data.not-found.exception}")
    private String dataNotFoundExceptionMessage;

}
