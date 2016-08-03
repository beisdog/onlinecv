package com.beisert.onlinecv.util;

import java.io.StringReader;
import java.io.StringWriter;
import java.util.Collection;

import javax.xml.transform.OutputKeys;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

/**
 * A collection of usefull string manipulation methods.
 * 
 * @author David Beisert
 * 
 */
public abstract class StringHelper {

	/**
	 * This method is usually used to remove leading zero's that are returned
	 * from SAP.
	 * <p>
	 * Example:<code>truncateLeadingChar("00000001234",'0') -> "1234"</code>
	 * <p>
	 * 
	 * @param str
	 *            to be modified
	 * @param leadingchar
	 * @author: emdadecos15 EMDAD Anup Kumar Bharti
	 * @since 01.12.2011
	 */
	public static String truncateLeadingChar(java.lang.String str, char leadingchar) {
		String fin = null;
		if (str != null && str != "") {
			str = str.trim();
			fin = str;
			for (int i = 0; i < str.length(); i++) {
				if (str.charAt(i) == leadingchar) {
					fin = str.substring(i + 1, str.length());
				} else {
					break;
				}
			}
		}
		return fin;
	}

	/**
	 * Makes a string a certain length and adds the leading character to add up
	 * the space.
	 * <p>
	 * This method is usually used to add 0 to the front of a number to pass it
	 * to an ABAP BAPI that sometimes expect numbers in that format.
	 * <p>
	 * Example: fillupStringToCertainLength("1234",10,'0') -> "0000001234"
	 * 
	 * @param sourceString
	 * @param size
	 * @param fillupchar
	 * @return string with the correct size filledup with specified char
	 */
	public static String fillupStringToCertainLength(final String sourceString, int size, char fillupchar) {
		StringBuilder result = new StringBuilder(size);
		String string = sourceString;
		if (string == null)
			string = "";
		StringBuilder fillup = new StringBuilder();
		for (int i = 0; i < size - string.length(); i++) {
			fillup.append(fillupchar);
		}
		result.append(fillup).append(string);
		return result.toString();

	}

	public static void main(String[] args) {
		System.out.println(fillupStringToCertainLength("87654321", 20, 'X'));
		System.out.println(truncateLeadingChar("00000000000000123", '0'));
	}

	/**
	 * Joins an array to concatenated string with a specified delimer.
	 * <p>
	 * Example:
	 * 
	 * <pre>
	 *  String[] ar = {&quot;Pears&quot;,&quot;Apples&quot;,&quot;Strawberries&quot;};
	 *  join(ar,&quot; AND &quot;);-&gt; &quot;Pears AND Apples AND Strawberries&quot;;
	 * </pre>
	 * 
	 * <p>
	 * 
	 * @param array
	 * @param delimeter
	 * @return joined string.
	 */
	public static String join(Object[] array, String delimeter) {
		StringBuilder result = new StringBuilder();

		for (int i = 0; i < array.length; i++) {
			result.append(array[i]);
			if (i < array.length - 1)
				result.append(delimeter);
		}

		return result.toString();
	}

	/**
	 * Joins a collection to concatenated string with a specified delimer.
	 * <p>
	 * Example:
	 * 
	 * <pre>
	 *  String[] ar = {&quot;Pears&quot;,&quot;Apples&quot;,&quot;Strawberries&quot;};
	 *  join(Arrays.asList(ar),&quot; AND &quot;);-&gt; &quot;Pears AND Apples AND Strawberries&quot;;
	 * </pre>
	 * 
	 * <p>
	 * 
	 * @param array
	 * @param delimeter
	 * @return joined string.
	 */
	public static String join(Collection<? extends Object> collection, String delimeter) {
		StringBuilder result = new StringBuilder();
		for (java.util.Iterator<? extends Object> iter = collection.iterator(); iter.hasNext();) {
			result.append(iter.next());
			if (iter.hasNext())
				result.append(delimeter);
		}

		return result.toString();
	}

	public static boolean isEmpty(String string) {
		return string == null || string.trim().length() == 0;
	}
	
	public static boolean isNotEmpty(String string) {
		return string != null && string.trim().length() > 0;
	}

	public static boolean arrayContains(String string, String[] arrayString) {
		for (int i = 0; i < arrayString.length; i++) {
			if (arrayString[i].equals(string))
				return true;
		}
		return false;
	}

	public static String formatXml(String xml, int indent) {
		try {
			Source xmlInput = new StreamSource(new StringReader(xml));
			StringWriter stringWriter = new StringWriter();
			StreamResult xmlOutput = new StreamResult(stringWriter);
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			transformerFactory.setAttribute("indent-number", indent);
			Transformer transformer = transformerFactory.newTransformer();
			transformer.setOutputProperty(OutputKeys.INDENT, "yes");
			transformer.transform(xmlInput, xmlOutput);
			return xmlOutput.getWriter().toString();
		} catch (Exception e) {
			throw new RuntimeException(e); // simple exception handling, please
											// review it
		}

	}

	public static String shortenFromLastindex(String string, int size) {
		if (string == null)
			return null;
		if (string.length() > size)
			return string.substring(string.length() - size - 1);
		return string;
	}

	public static String trim(String stringOrNull) {
		if (stringOrNull == null)
			return null;
		return stringOrNull.trim();
	}

	public static String subString(String stringOrNull, int beginIndex, int endIndex) {
		if (stringOrNull == null)
			return null;
		return (stringOrNull.length() >= endIndex) ? stringOrNull.substring(beginIndex, endIndex) : null;
	}
	
	public static String appendIfNotEmpty(String toCheck, String toAppend){
		if(StringHelper.isEmpty(toCheck))return "";
		return toAppend;
	}

	/**
	 * Simple method to do something like join.
	 * Example:
	 * <p>
	 * StringBuilder builder = new StringBuilder();
	 * StringHelper.append(builder,"David"," and ");
	 * // builder.toString() == "David"
	 * StringHelper.append(builder,"Sebastian"," and ");
	 * StringHelper.append(builder,"Tim"," and ");
	 * StringHelper.append(builder,"Tim"," and ");
	 * // builder.toString() == "David and Sebastian and Tim and Tim"
	 * </p>
	 * @param builder
	 * @param text
	 * @param delimeter
	 */
	public static void appendWithDelim(StringBuilder builder, String text, String delimeter){
		if(builder.length() > 0){
			builder.append(delimeter);
		}
		builder.append(text);
	}
	
	public static String removeCurlyBrace(String parameter) {
		if(isEmpty(parameter) || parameter.length() < 2) {
			return parameter;
		}
		return parameter.substring( 1, parameter.length() - 1 );
	}
	

}
