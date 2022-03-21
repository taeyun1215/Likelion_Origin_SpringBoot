package LikeLion7.weeks2.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.util.ContentCachingRequestWrapper;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.UUID;

public class TransactionLogFilter implements Filter {
    private static final Logger logger = LoggerFactory.getLogger(TransactionLogFilter.class);

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        String requestUUID = UUID.randomUUID().toString().split("-")[0];
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        logger.debug("[{}] start request: {} {}", requestUUID, httpServletRequest.getMethod(), httpServletRequest.getRequestURI());
        logger.info(" * response status code: {}", ((HttpServletResponse) response).getStatus());

        ContentCachingRequestWrapper requestWrapper = new ContentCachingRequestWrapper(httpServletRequest);
        chain.doFilter(requestWrapper, response);


        HttpServletResponse httpServletResponse = (HttpServletResponse) response;
        logger.info(" * response status code: {}", ((HttpServletResponse) response).getStatus());
        logger.debug("[{}] send response: {}", requestUUID, httpServletResponse.getStatus());
    }
}
