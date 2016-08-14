package com.beisert.onlinecv.birt;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Logger;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.eclipse.birt.report.engine.api.HTMLRenderOption;
import org.eclipse.birt.report.engine.api.HTMLServerImageHandler;
import org.eclipse.birt.report.engine.api.IReportEngine;
import org.eclipse.birt.report.engine.api.IReportRunnable;
import org.eclipse.birt.report.engine.api.IRunAndRenderTask;


public class WebReport extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Constructor of the object.
	 */
	private IReportEngine birtReportEngine = null;
	protected static Logger logger = Logger.getLogger( "org.eclipse.birt" );
	
	public WebReport() {
		super();
	}

	/**
	 * Destruction of the servlet. 

	 */ 
	public void destroy() { 
		super.destroy(); 
		//BirtEngine.destroyBirtEngine();
	}
 

	/**
	 * The doGet method of the servlet. 

	 *
	 */
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		//get report name and launch the engine
		resp.setContentType("text/html");
		//resp.setContentType( "application/pdf" ); 
		//resp.setHeader ("Content-Disposition","inline; filename=test.pdf");		
		String reportName = req.getParameter("ReportName");
		ServletContext sc = req.getSession().getServletContext();
		//this.birtReportEngine = BirtEngine.getBirtEngine(sc);
		
		
		IReportRunnable design;
		try
		{
			//Open report design
			design = birtReportEngine.openReportDesign( sc.getRealPath("/Reports")+"/"+reportName );
			//create task to run and render report
			IRunAndRenderTask task = birtReportEngine.createRunAndRenderTask( design );		
			//set output options
			HTMLRenderOption options = new HTMLRenderOption();
                       //set the image handler to a HTMLServerImageHandler if you plan on using the base image url.
                       options.setImageHandler(new HTMLServerImageHandler());
			options.setOutputFormat(HTMLRenderOption.OUTPUT_FORMAT_HTML);
			//options.setOutputFormat(HTMLRenderOption.OUTPUT_FORMAT_PDF);
			options.setOutputStream(resp.getOutputStream());
			options.setBaseImageURL(req.getContextPath()+"/images");
			options.setImageDirectory(sc.getRealPath("/images"));
			task.setRenderOption(options);
			
			//run report
			task.run();
			task.close();
		}catch (Exception e){
			
			e.printStackTrace();
			throw new ServletException( e );
		}
	}

	/**
	 * The doPost method of the servlet. 

	 *
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
		out.println("<HTML>");
		out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
		out.println("  <BODY>");
		out.println(" Post Not Supported");
		out.println("  </BODY>");
		out.println("</HTML>");
		out.flush();
		out.close();
	}

	/**
	 * Initialization of the servlet. 

	 *
	 * @throws ServletException if an error occure
	 */
	public void init() throws ServletException {
		//BirtEngine.initBirtConfig();
		
	}

}
