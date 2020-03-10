package ru.vsamarin.easy_ee_application.rest.client;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.IOUtils;

import javax.ws.rs.client.ClientRequestContext;
import javax.ws.rs.client.ClientRequestFilter;
import javax.ws.rs.client.ClientResponseContext;
import javax.ws.rs.client.ClientResponseFilter;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Objects;

@Slf4j(topic = "rest.client")
public class LoggingFilter implements ClientRequestFilter, ClientResponseFilter {

    @Override
    public void filter(ClientRequestContext clientRequestContext) {
        log.info("*************************************** REQUEST START ****************************************");
        log.info(clientRequestContext.getMethod().concat(" ").concat(Objects.toString(clientRequestContext.getUri().toString())));
        log.info("media_type=" + Objects.toString(clientRequestContext.getMediaType()));
        log.info("*************************************** REQUEST END ******************************************");
    }

    @Override
    public void filter(ClientRequestContext clientRequestContext, ClientResponseContext clientResponseContext) {
        log.info("*************************************** RESPONSE START ***************************************");
        log.info(clientRequestContext.getMethod().concat(" ").concat(Objects.toString(clientRequestContext.getUri())));
        log.info("media_type=" + Objects.toString(clientResponseContext.getMediaType()));
        log.info("status=" + Objects.toString(clientResponseContext.getStatus()));
        if (clientResponseContext.hasEntity()) {
            try {
                byte[] bodyBytes = IOUtils.toByteArray(clientResponseContext.getEntityStream());
                clientResponseContext.setEntityStream(new ByteArrayInputStream(bodyBytes));
                log.info("response_body=" + new String(bodyBytes, StandardCharsets.UTF_8));
            } catch (IOException e) {
                log.error(e.getMessage(), e);
            }
        }
        log.info("*************************************** RESPONSE END *****************************************");
    }

}
