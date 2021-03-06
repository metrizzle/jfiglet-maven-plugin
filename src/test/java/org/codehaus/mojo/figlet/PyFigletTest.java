package org.codehaus.mojo.figlet;

import static org.codehaus.mojo.figlet.Figletizzr.print;

import org.codehaus.mojo.figlet.FigletOptionsRequest;
import org.codehaus.mojo.figlet.PyFigletDriver;
import org.junit.Test;
import org.junit.experimental.theories.DataPoints;
import org.junit.experimental.theories.FromDataPoints;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.runner.RunWith;
import org.python.core.PyException;
import org.python.core.PyInteger;
import org.python.core.PyObject;
import org.python.util.PythonInterpreter;

@RunWith(Theories.class)
public class PyFigletTest {

    @DataPoints("text") 
    public static String[] messages = new String[] { "foobar", "swagg", "jfiglet", "pyfiglet" };

    @DataPoints("fonts")
    public static String[] fonts = new String[] { "banner4", "bubble", "graffiti",  "kban"};

	PyFigletDriver figlet = new PyFigletDriver();
    
	@Theory
	public void renderAFew(@FromDataPoints("text") String message,
			@FromDataPoints("fonts") String font) {
		
		try {
			print(figlet, new FigletOptionsRequest().text(font).font(font));
			print(figlet, new FigletOptionsRequest().text(message).font(font));
		} catch(Exception e) {
			System.out.println("rendering failed; error message:" + e.getMessage() + " font:" + font + " text:" + message);
		}

		System.out.println("text: " + message + " font:" + font);
//	    assumeThat(m, not(0));
//	    assertThat(new Dollar(amount).times(m).divideBy(m).getAmount(), is(amount));
	}
	
	
//	@Test
//	public void noargs() throws Exception {
//		print(figlet, null);
//	}
	
	
	@Test
	public void pyfigletDefaultFont() throws Exception {
		print(figlet, "continous delivery");
	}
	
	@Test
	public void pyfiglet() throws Exception {
		
//		String font ="standard";
		
		print(figlet, new FigletOptionsRequest().text("NX3>>"));
		
//		print(figlet, b -> {
//			b.font("banner.flf")
//		});
		
//		.font("banner.flf")
//		.text("text");
        
	}
	
	
	/**
	 * @param args
	 *            the command line arguments
	 */
	// @Test
	public static void main(String[] args) throws PyException {

		// Create an instance of the PythonInterpreter
		PythonInterpreter interp = new PythonInterpreter();

		// The exec() method executes strings of code
		interp.exec("import sys");
		interp.exec("print sys");

		// Set variable values within the PythonInterpreter instance
		interp.set("a", new PyInteger(42));
		interp.exec("print a");
		interp.exec("x = 2+2");

		// Obtain the value of an object from the PythonInterpreter and store it
		// into a PyObject.
		PyObject x = interp.get("x");
		System.out.println("x: " + x);
	}	

	
}
