package model;

import java.util.List;

public class EDI214 {
	
	private EDI214Header ISA;
	private EDI214GS GS;
	private EDI214ST ST;
	private EDI214B10 B10;
	private List <EDI214LXLoop> LXLoop;
	private EDI214SE SE;
	private EDI214GE GE;
	private EDI214IEA IEA;
	
	public EDI214Header getISA() {
		return ISA;
	}
	public void setISA(EDI214Header iSA) {
		ISA = iSA;
	}
	public EDI214GS getGS() {
		return GS;
	}
	public void setGS(EDI214GS gS) {
		GS = gS;
	}
	public EDI214ST getST() {
		return ST;
	}
	public void setST(EDI214ST sT) {
		ST = sT;
	}
	public EDI214B10 getB10() {
		return B10;
	}
	public void setB10(EDI214B10 b10) {
		B10 = b10;
	}
	
	public List<EDI214LXLoop> getLXLoop() {
		return LXLoop;
	}
	public void setLXLoop(List<EDI214LXLoop> lXLoop) {
		LXLoop = lXLoop;
	}
	
	public EDI214SE getSE() {
		return SE;
	}
	public void setSE(EDI214SE sE) {
		SE = sE;
	}
	
	public EDI214GE getGE() {
		return GE;
	}
	public void setGE(EDI214GE gE) {
		GE = gE;
	}
	
	public EDI214IEA getIEA() {
		return IEA;
	}
	public void setIEA(EDI214IEA iEA) {
		IEA = iEA;
	}
	
	@Override
	public String toString() {
		return "EDI214 [ISA=" + ISA + ", GS=" + GS + ", ST=" + ST + ", B10=" + B10 + ", LXLoop=" + LXLoop + ", SE=" + SE
				+ ", GE=" + GE + ", IEA=" + IEA + "]";
	}
	
	
	
	
}
