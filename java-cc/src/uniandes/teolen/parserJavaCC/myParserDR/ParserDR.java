package uniandes.teolen.parserJavaCC.myParserDR;



public class ParserDR extends SimpleLexer {

	public ParserDR () {
	  super (System.in);
	}
	
	
	
	
	public void Lexp() throws ParseException {
		Lterm();
		while (sigToken() == AT) {
			aceptar(AT);
			Lterm();
		}
		
	}
	
	void Lterm() throws ParseException {
		
		while (sigToken() == INT) {
			aceptar(INT);
			aceptar(PP);
		}
		Lf();
	}
	
	
	void Lf() throws ParseException {
		int t = sigToken();
		
		switch (t) {
		case OB:  aceptar(OB);
				  if (sigToken() == INT){
					  aceptar(INT);
				  	  while (sigToken() == COMMA) {
				  		  aceptar(COMMA);
				  		  aceptar(INT);
				  	  }
					}	  
				  	aceptar(CB);
					break;
		case OP:  aceptar(OP); Lexp(); aceptar(CP); break;
		default: throw new ParseException();
		}
		
	}
	
	
}
