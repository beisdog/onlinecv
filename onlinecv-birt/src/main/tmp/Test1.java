package com.beisert.onlinecv.birt;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;

import org.eclipse.birt.core.exception.BirtException;
import org.eclipse.birt.core.framework.Platform;
import org.eclipse.birt.report.engine.api.EngineConfig;
import org.eclipse.birt.report.engine.api.EngineConstants;
import org.eclipse.birt.report.engine.api.IReportEngine;
import org.eclipse.birt.report.engine.api.IReportEngineFactory;
import org.eclipse.birt.report.engine.api.IReportRunnable;
import org.eclipse.birt.report.engine.api.IRunAndRenderTask;
import org.eclipse.birt.report.engine.api.PDFRenderOption;
import org.eclipse.core.internal.registry.RegistryProviderFactory;

public class Test1 {

	public static void main(String[] args) {

		String reportDesignFilePath = "./src/main/resources/cv_report.rptdesign";
		// String birtHomeDir = "C:\\AngryBIRT\\birt-engine\\ReportEngine";
		String logDir = "./target/";
		// String configDir = "";
		String resourcesDir = "./src/main/resources";
		String outputDir = "./target/t";

		IReportEngine engine = null;
		EngineConfig config = null;
		FileInputStream fileInputStream = null;

		try {
			// read this in www
			System.setProperty("RUN_UNDER_ECLIPSE", "false");
			config = new EngineConfig();

			// config.setEngineHome(birtHomeDir);
			config.setLogConfig(logDir, Level.ALL);
			// important for BIRT to know resources
			config.setResourcePath(resourcesDir);
			// Render Option
			PDFRenderOption PDF_OPTIONS = new PDFRenderOption();
			// Default Render Option
			config.setDefaultEmitter("pdf", PDF_OPTIONS.getEmitterID());
			// startup this config

			Platform.startup(config);

			// create Report Engine
			final IReportEngineFactory FACTORY = (IReportEngineFactory) Platform
					.createFactoryObject(IReportEngineFactory.EXTENSION_REPORT_ENGINE_FACTORY);
			engine = FACTORY.createReportEngine(config);

			fileInputStream = new FileInputStream(reportDesignFilePath);

			IReportRunnable design = engine.openReportDesign(fileInputStream); // engine.openReportDesign("");

			IRunAndRenderTask task = engine.createRunAndRenderTask(design);
			task.getAppContext().put(EngineConstants.APPCONTEXT_CLASSLOADER_KEY, Test1.class.getClassLoader());
			File reportDesignFile = new File(reportDesignFilePath);
			String outputFilePath = outputDir + "\\" + reportDesignFile.getName().replace(".rptdesign", ".pdf");
			File pdfFile = new File(outputFilePath);
			if (!pdfFile.exists()) {
				pdfFile.getParentFile().mkdirs();
			}
			PDF_OPTIONS.setOutputFileName(outputFilePath);
			PDF_OPTIONS.setOutputFormat("pdf");
			// set the render option
			task.setRenderOption(PDF_OPTIONS);
			// runs the report and generate output.
			task.run();
			// close the report.
			task.close();
			// free engine
			engine.destroy();
			System.out.println("done");
		} catch (BirtException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally {
			// shutdown Platform
			Platform.shutdown();
			// release registries
			RegistryProviderFactory.releaseDefault();
			try {
				if (fileInputStream != null) {
					fileInputStream.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
