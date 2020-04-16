package com.test.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.HttpConstraint;
import javax.servlet.annotation.HttpMethodConstraint;
import javax.servlet.annotation.ServletSecurity;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class FirstServlet
 */

/**
 * @author preetham
 */
@WebServlet("/user")
@ServletSecurity(
		value = @HttpConstraint(
				rolesAllowed = {
						"user"
				}),
		httpMethodConstraints = {
				@HttpMethodConstraint(value = "GET", rolesAllowed = {
						"user"
				})
		})
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().write("Hello user");
	}



}
