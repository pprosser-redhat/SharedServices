package processor;

import java.util.ArrayList;
import java.util.Iterator;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import model.*;

public class ParseResult implements Processor{

	@SuppressWarnings("rawtypes")
	@Override
	public void process(Exchange exchange) throws Exception {
		
		ArrayList al = (ArrayList) exchange.getIn().getBody();
		
		System.out.println("Hello");
		
		
		EDI214 edi214 = (EDI214) al.get(0);
		
		System.out.println (edi214.getISA());
		System.out.println (edi214.getGS());
		System.out.println (edi214.getST());
		System.out.println (edi214.getB10());
		
	    for (EDI214LXLoop edi214LXLoop : edi214.getLXLoop()) {	
	    	
	    	System.out.println (edi214LXLoop.getAssingedNumber());
	    	
	    	for (EDI214AT7 edi214AT7 : edi214LXLoop.getAT7Loop())
	    		System.out.println(edi214AT7);
	    	
	    	if (edi214LXLoop.getMS2Loop() != null) {
	    		for (EDI214MS2 edi214MS2 : edi214LXLoop.getMS2Loop())
	    			System.out.println(edi214MS2);
	    	}
	    	
	    	System.out.println(edi214LXLoop.getL11());
	    }
	    
	    System.out.println (edi214.getSE());
	    System.out.println (edi214.getGE());
	    System.out.println (edi214.getIEA());
	    
	    /* Change body from an ArrayList object to the EDI214 format for marshalling to XML */

	    exchange.getIn().setBody(edi214);
	}

}
