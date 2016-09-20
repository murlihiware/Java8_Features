/**
 * 
 */
package com.js;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

/**
 * @author Murli
 *
 */
public class JSDemo {

	/**
	 * @param args
	 * @throws ScriptException 
	 */
	public static void main(String[] args) throws ScriptException {
	//The public API to embed Oracle Nashorn is simply javax.script. 
	//When Oracle Nashorn is available, its scripting engine is accessible through the nashorn identifier.
		ScriptEngineManager engineManager = new ScriptEngineManager();
		ScriptEngine engine = engineManager.getEngineByName("nashorn");
		engine.eval("function sum(a, b) { return a + b; }");
		System.out.println(engine.eval("sum(1, 2);"));
	}


}
