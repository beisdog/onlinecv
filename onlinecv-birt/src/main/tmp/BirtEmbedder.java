package com.beisert.onlinecv.birt;

import java.util.logging.Level;

import org.eclipse.birt.core.exception.BirtException;
import org.eclipse.birt.core.framework.Platform;
import org.eclipse.birt.report.engine.api.EngineConfig;
import org.eclipse.birt.report.engine.api.EngineConstants;
import org.eclipse.birt.report.engine.api.HTMLRenderOption;
import org.eclipse.birt.report.engine.api.IPDFRenderOption;
import org.eclipse.birt.report.engine.api.IRenderOption;
import org.eclipse.birt.report.engine.api.IReportEngine;
import org.eclipse.birt.report.engine.api.IReportRunnable;
import org.eclipse.birt.report.engine.api.IRunAndRenderTask;
import org.eclipse.birt.report.engine.api.PDFRenderOption;
import org.eclipse.birt.report.engine.api.RenderOption;
import org.eclipse.birt.report.engine.api.ReportEngine;
import org.eclipse.birt.report.engine.api.impl.ReportEngineFactory;

public class BirtEmbedder {
	 
    private IReportEngine engine;
 
    public BirtEmbedder() throws BirtException {
//        final EngineConfig config = new EngineConfig();
//        engine =  new ReportEngine(config);
//        engine.changeLogLevel( Level.WARNING );
        
        System.out.println( "Starting BIRT engine..." );
		EngineConfig config = new EngineConfig();
		config.set
		Platform.startup( config );
		ReportEngineFactory ref = new ReportEngineFactory();
		engine = ref.createReportEngine( config );
		System.out.println( "Done." );
    }
 
    public void render(String reportFile, String type) {
        try{
            //Open the report design
            final IReportRunnable design = engine.openReportDesign(reportFile);
 
            //Create task to run and render the report,
            final IRunAndRenderTask task = engine.createRunAndRenderTask(design);
            //Set parent classloader for engine
            task.getAppContext().put(EngineConstants.APPCONTEXT_CLASSLOADER_KEY, BirtEmbedder.class.getClassLoader());
 
            final IRenderOption options = new RenderOption();
            options.setOutputFormat(type);
            options.setOutputFileName("output/TestReport." + options.getOutputFormat());
            if( options.getOutputFormat().equalsIgnoreCase("html")){
                final HTMLRenderOption htmlOptions = new HTMLRenderOption( options);
                htmlOptions.setImageDirectory("img");
                htmlOptions.setHtmlPagination(false);
                htmlOptions.setHtmlRtLFlag(false);
                htmlOptions.setEmbeddable(false);
                htmlOptions.setSupportedImageFormats("PNG");
 
                //set this if you want your image source url to be altered
                //If using the setBaseImageURL, make sure to set image handler to HTMLServerImageHandler
                //htmlOptions.setBaseImageURL("http://myhost/prependme?image=");
            }else if( options.getOutputFormat().equalsIgnoreCase("pdf")){
                final PDFRenderOption pdfOptions = new PDFRenderOption( options );
                pdfOptions.setOption(IPDFRenderOption.PAGE_OVERFLOW, IPDFRenderOption.FIT_TO_PAGE_SIZE);
                pdfOptions.setOption(IPDFRenderOption.PAGE_OVERFLOW, IPDFRenderOption.OUTPUT_TO_MULTIPLE_PAGES);
            }
 
            task.setRenderOption(options);
            //run and render report
            task.run();
 
            task.close();
        } catch(Exception ex) {
            ex.printStackTrace();
        }
    }
 
    public static void main(String[] args) throws BirtException {
        final BirtEmbedder embeder = new BirtEmbedder();
        embeder.render("/src/main/resources/cv_report.rptdesign","html");
        //embeder.render("pdf");
    }
 
}
