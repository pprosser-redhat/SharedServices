package model;

import java.util.List;

public class EDI214LXLoop extends EDI214RecordType {
	
	private String AssingedNumber;
	private List<EDI214AT7> AT7Loop;
	private List<EDI214MS2> MS2Loop;
	private EDI214L11 L11;
	
	
	public String getAssingedNumber() {
		return AssingedNumber;
	}
	public void setAssingedNumber(String assingedNumber) {
		AssingedNumber = assingedNumber;
	}
	
	public List<EDI214AT7> getAT7Loop() {
		return AT7Loop;
	}
	public void setAT7Loop(List<EDI214AT7> aT7Loop) {
		AT7Loop = aT7Loop;
	}
	
	public List<EDI214MS2> getMS2Loop() {
		return MS2Loop;
	}
	public void setMS2Loop(List<EDI214MS2> mS2Loop) {
		MS2Loop = mS2Loop;
	}
	
	public EDI214L11 getL11() {
		return L11;
	}
	public void setL11(EDI214L11 l11) {
		L11 = l11;
	}
	@Override
	public String toString() {
		return "EDI214LXLoop [AssingedNumber=" + AssingedNumber + ", AT7Loop=" + AT7Loop + ", MS2Loop=" + MS2Loop
				+ ", edi214L11=" + L11 + ", getRecordType()=" + getRecordType() + "]";
	}

	
}
