package by.tr.totalizator.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class EncodingFilter implements Filter {
	private final static Logger rootLogger = LogManager.getRootLogger();
	private String encoding;
	private ServletContext servletContext;

    public EncodingFilter() {
    }

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		request.setCharacterEncoding(encoding);
		response.setCharacterEncoding(encoding);
		servletContext.log("Charset was set.");
		rootLogger.info("Filter was done: charset encoding was set.");
		
		chain.doFilter(request, response);
	}

	public void init(FilterConfig fConfig) throws ServletException {
		encoding = fConfig.getInitParameter("characterEncoding");
		servletContext = fConfig.getServletContext();
		rootLogger.info("Filter was initialized.");
	}

}
