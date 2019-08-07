package model;

public class EDI214IEA extends EDI214RecordType {
	
	private String NumberofIncludedFunctionalGroups;
	private String InterchangeControlNumber;
	
	public String getNumberofIncludedFunctionalGroups() {
		return NumberofIncludedFunctionalGroups;
	}
	public void setNumberofIncludedFunctionalGroups(String numberofIncludedFunctionalGroups) {
		NumberofIncludedFunctionalGroups = numberofIncludedFunctionalGroups;
	}
	public String getInterchangeControlNumber() {
		return InterchangeControlNumber;
	}
	public void setInterchangeControlNumber(String interchangeControlNumber) {
		InterchangeControlNumber = interchangeControlNumber;
	}
	@Override
	public String toString() {
		return "EDI214IEA [NumberofIncludedFunctionalGroups=" + NumberofIncludedFunctionalGroups
				+ ", InterchangeControlNumber=" + InterchangeControlNumber + ", getRecordType()=" + getRecordType()
				+ "]";
	}

	
}
