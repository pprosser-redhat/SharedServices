package model;

public class EDI214GE extends EDI214RecordType {
	
	private String NumberofTransactionSetsIncluded;
	private String GroupControlNumber;
	
	public String getNumberofTransactionSetsIncluded() {
		return NumberofTransactionSetsIncluded;
	}
	public void setNumberofTransactionSetsIncluded(String numberofTransactionSetsIncluded) {
		NumberofTransactionSetsIncluded = numberofTransactionSetsIncluded;
	}
	public String getGroupControlNumber() {
		return GroupControlNumber;
	}
	public void setGroupControlNumber(String groupControlNumber) {
		GroupControlNumber = groupControlNumber;
	}
	
	@Override
	public String toString() {
		return "EDI214GE [NumberofTransactionSetsIncluded=" + NumberofTransactionSetsIncluded + ", GroupControlNumber="
				+ GroupControlNumber + ", getRecordType()=" + getRecordType() + "]";
	}
	

	
	
}
