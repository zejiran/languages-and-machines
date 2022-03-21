package uniandes.teolen.parserJavaCC.mundoParser;

import java.util.*;

import uniandes.teolen.parserJavaCC.myParser.ParserCAML;
import uniandes.teolen.parserJavaCC.myParserDR.ParserDR;
import uniandes.teolen.parserJavaCC.newParser.NuevoParser;
import uniandes.teolen.parserJavaCC.parserBinaryTree.ParserBinaryTree;
import uniandes.teolen.parserJavaCC.parserCAML.ParserCAMLco;
import uniandes.teolen.parserJavaCC.parserProlog.ParserProlog;
import uniandes.teolen.parserJavaCC.parserGrammars.ParserG;



public class MundoParsers {
	
	// Nombres de los Parsers
	private  ArrayList  <String> parsers  = new ArrayList <String> (); 
	
	// Parser que se est� usando
	private int currentParser;
	
	
	public  MundoParsers () {
  	
		// Agreguen al final de esta lista los nombres del nuevo parser
		
	    parsers.add("ParserDR");
	    parsers.add("CAML -  interpreter");
	    parsers.add("CAML");
	    parsers.add("Nuevo Parser");
	    parsers.add("Parser Prolog");
	    parsers.add("Parser G");
	    parsers.add("Binary Tree Parser");
	    
	    currentParser =  0;

	}
	
	public ParserProlog getParserProlog(){
		return new ParserProlog(System.in);
	}
	
	public ParserCAML getParserCAML(){
		return new ParserCAML(System.in);
	}
	
	public ParserCAMLco getParserCAMLco(){
		return new ParserCAMLco(System.in);
	}
	
	public ParserDR getParserDR(){
		return new ParserDR();
	}
	
	public NuevoParser getNuevoParser(){
		return new NuevoParser(System.in);
	}
	
	public ParserBinaryTree getParserBinaryTree(){
		return new ParserBinaryTree(System.in);
	}
	
	public ParserG getGParser(){
		return new ParserG(System.in);
	}
	
	public String getStringCurrentParser(){
		return parsers.get(currentParser);
	}
	
	public int getCurrentParser() {
		return currentParser;
	}
	
	public void setCurrentParser(int p) {
		currentParser = p;
	}
	
	public String getParser(int i) {
		return parsers.get(i);
	}
	
	public int sizeParsers() {
		return parsers.size();
	}
	
	public String  procesarCadena(String texto) {
		String resp = "";
		
		if(parsers.get(currentParser).equals("ParserDR")){
			ParserDR parserDR = getParserDR();
			parserDR.ReInit(new java.io.StringReader(texto));
			try {
		    	parserDR.Lexp(); 
		    	resp = new String("OK    \n");
		    }catch (Exception e) {
		        resp = new String ("Error de Sintaxis: "+e.getMessage());
		     } catch (Error e) {
		    	 resp = new String ("Error Lexico: "+e.getMessage());
		}
		}
		else if(parsers.get(currentParser).equals("CAML -  interpreter")){
			ParserCAML parserCAML = getParserCAML();
			parserCAML.ReInit(new java.io.StringReader(texto));
			ArrayList <Integer>  myList = new ArrayList <Integer> ();
			try {
		    	myList = parserCAML.camlList(); 
		    	resp = new String("OK    "+ myList + "\n");
		    	 
		    	
			}catch (Exception e) {
		        	resp = new String ("Error de Sintaxis: "+e.getMessage());
		    } catch (Error e) {
		    	 resp = new String ("Error Lexico: "+e.getMessage());
		    }
		}
		else if(parsers.get(currentParser).equals("CAML")){
			ParserCAML parserCAML = getParserCAML();
			parserCAML.ReInit(new java.io.StringReader(texto));
			ArrayList <Integer>  myList = new ArrayList <Integer> ();
			try {
		    	 parserCAML.camlList(); 
		    	resp = new String("OK    \n");
		    	 
		    	
			}catch (Exception e) {
		        	resp = new String ("Error de Sintaxis: "+e.getMessage());
		    } catch (Error e) {
		    	 resp = new String ("Error Lexico: "+e.getMessage());
		    }
		}
		else if(parsers.get(currentParser).equals("Nuevo Parser")){
			NuevoParser nuevoParser = getNuevoParser();
			nuevoParser.ReInit(new java.io.StringReader(texto));
			try {
		    	int v = nuevoParser.one_line(); 
		    	resp = new String("OK   "+v+ "\n");
		    }catch (Exception e) {
		        resp = new String ("Error de Sintaxis: "+e.getMessage());
		     } catch (Error e) {
		    	 resp = new String ("Error Lexico: "+e.getMessage());
		     }
		}
		else if(parsers.get(currentParser).equals("Parser Prolog")){
			ParserProlog nuevoParser = getParserProlog();
			nuevoParser.ReInit(new java.io.StringReader(texto));
			try {
		    	nuevoParser.hr(); 
		    	resp = new String("OK    \n");
		    }catch (Exception e) {
		        resp = new String ("Error de Sintaxis: "+e.getMessage());
		     } catch (Error e) {
		    	 resp = new String ("Error Lexico: "+e.getMessage());
		     }
		}
		else if(parsers.get(currentParser).equals("Parser G")){
			ParserG nuevoParser = getGParser();
			nuevoParser.ReInit(new java.io.StringReader(texto));
			try {
		    	nuevoParser.prod(); 
		    	resp = new String("OK    \n");
		    }catch (Exception e) {
		        resp = new String ("Error de Sintaxis: "+e.getMessage());
		     } catch (Error e) {
		    	 resp = new String ("Error Lexico: "+e.getMessage());
		     }
		}
		else if(parsers.get(currentParser).equals("Binary Tree Parser")){
			ParserBinaryTree nuevoParser = getParserBinaryTree();
			nuevoParser.ReInit(new java.io.StringReader(texto));
			try {
		    	nuevoParser.input(); 
		    	resp = new String("OK    \n");
		    }catch (Exception e) {
		        resp = new String ("Error de Sintaxis: "+e.getMessage());
		     } catch (Error e) {
		    	 resp = new String ("Error Lexico: "+e.getMessage());
		     }
		}

		return "\n SISTEMA " + parsers.get(currentParser) + ": " + resp + "\n";
	}

}
