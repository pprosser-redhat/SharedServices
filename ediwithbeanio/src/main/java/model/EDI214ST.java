package model;

public class EDI214ST extends EDI214RecordType {

	String TransactionSetIdentifierCode;
	String TransactionSetControlNumber;
	
	public String getTransactionSetIdentifierCode() {
		return TransactionSetIdentifierCode;
	}
	public void setTransactionSetIdentifierCode(String transactionSetIdentifierCode) {
		TransactionSetIdentifierCode = transactionSetIdentifierCode;
	}
	public String getTransactionSetControlNumber() {
		return TransactionSetControlNumber;
	}
	public void setTransactionSetControlNumber(String transactionSetControlNumber) {
		TransactionSetControlNumber = transactionSetControlNumber;
	}
	
	@Override
	public String toString() {
		return "EDI214ST [recordType=" + getRecordType() + ", TransactionSetIdentifierCode=" + TransactionSetIdentifierCode
				+ ", TransactionSetControlNumber=" + TransactionSetControlNumber + "]";
	}
	
	
	
}
