package model;

public class EDI214SE extends EDI214RecordType {
	
	String NumberofIncludedSegments;
	String TransactionSetControlNumber;
	
	public String getNumberofIncludedSegments() {
		return NumberofIncludedSegments;
	}
	public void setNumberofIncludedSegments(String numberofIncludedSegments) {
		NumberofIncludedSegments = numberofIncludedSegments;
	}
	public String getTransactionSetControlNumber() {
		return TransactionSetControlNumber;
	}
	public void setTransactionSetControlNumber(String transactionSetControlNumber) {
		TransactionSetControlNumber = transactionSetControlNumber;
	}
	@Override
	public String toString() {
		return "EDI214SE [NumberofIncludedSegments=" + NumberofIncludedSegments + ", TransactionSetControlNumber="
				+ TransactionSetControlNumber + ", getRecordType()=" + getRecordType() + "]";
	}
	

}
