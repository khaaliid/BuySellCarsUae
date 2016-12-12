package com.buySellCar.test.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.buySellCar.test.baos.TestBao;
import com.buySellCar.test.dtos.TestDto;

/**
 * Servlet implementation class TestDBConnectivity
 */
@WebServlet("/testDBConnectivity")
public class TestDBConnectivity extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TestDBConnectivity() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		TestBao tb = new TestBao();
		TestDto tdto = tb.getTestData();
		
		PrintWriter writer = response.getWriter();
		writer.println("DB connected and these are the values : ");
		writer.println(tdto.getColId());
		writer.println(tdto.getValue());
		writer.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		TestBao tb = new TestBao();
		TestDto tdto = tb.getTestData();
		
		PrintWriter writer = response.getWriter();
		writer.println("DB connected and these are the values : ");
		writer.println(tdto.getColId());
		writer.println(tdto.getValue());
		writer.close();
	}

}
