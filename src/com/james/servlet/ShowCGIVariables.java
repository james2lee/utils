package com.james.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ShowCGIVariables
 */
public class ShowCGIVariables extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		
		request.setAttribute("AUTH_TYPE", request.getAuthType());
		request.setAttribute("CONTENT_LENGTH", String.valueOf(request.getContentLength()));
		request.setAttribute("CONTENT_TYPE", request.getContentType());
		request.setAttribute("PATH_INFO", request.getPathInfo());
		request.setAttribute("PATH_TRANSLATED", request.getPathTranslated());
		request.setAttribute("REMOTE_USER", request.getRemoteUser());
		request.setAttribute("REMOTE_ADDR", request.getRemoteAddr());
		request.setAttribute("REMOTE_HOST", request.getRemoteHost());
		request.setAttribute("QUERY_STRING", request.getQueryString());
		request.setAttribute("REQUEST_METHOD", request.getMethod());
		request.setAttribute("SERVLET_PATH", request.getServletPath());
		request.setAttribute("SERVER_NAME", request.getServerName());
		request.setAttribute("SERVER_PORT", request.getServerPort()+"");
		request.setAttribute("SERVER_PROTOCOL", request.getProtocol());
		
		request.setAttribute("REAL_PATH", getServletContext().getRealPath("/"));//真实路径
		request.setAttribute("SERVER_INFO", getServletContext().getServerInfo());
		request.setAttribute("CONTEXT_PATH", getServletContext().getContextPath());
		request.setAttribute("MAJOR_VERSION", getServletContext().getMajorVersion()+"");
		request.setAttribute("MINOR_VERSION", getServletContext().getMinorVersion()+"");
		request.setAttribute("EFFECTIVE_MAJOR_VERSION", getServletContext().getMajorVersion()+"");
		request.setAttribute("EFFECTIVE_MINOR_VERSION", getServletContext().getMajorVersion()+"");
		
		request.getRequestDispatcher("show.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
