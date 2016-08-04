package com.beisert.onlinecv.util;

import java.io.Reader;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;
import java.util.LinkedHashMap;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

/**
 * Can convert a java class that has JAXB annotations
 * to an xml string.
 * 
 * @author EVFQY
 *
 */
public class XML2BeanConverter {
	
	public static String marshal(Object object) throws JAXBException {
		System.out.println(object.getClass());
//		JAXBContext jaxbContext = JAXBContext.newInstance(object.getClass());
		Class<? extends Object> clazz = LinkedHashMap.class;
		JAXBContext jaxbContext = JAXBContext.newInstance(object.getClass(), clazz);
		System.out.println(jaxbContext);
		Marshaller marshaller = jaxbContext.createMarshaller();
		Writer writer = new StringWriter();
		marshaller.marshal(object, writer);
		return writer.toString();
	}

	public static Object unmarshal(Class<?> clazz, String xml) throws JAXBException {
		JAXBContext jaxbContext = JAXBContext.newInstance(clazz.getClass());
		Unmarshaller marshaller = jaxbContext.createUnmarshaller();
		Reader reader = new StringReader(xml);
		Object result = marshaller.unmarshal(reader);
		return result;
	}
}
