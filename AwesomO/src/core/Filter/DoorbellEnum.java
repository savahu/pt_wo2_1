package core.Filter;

/**
 *
 * @author sander
 */
 
    public enum DoorbellEnum {
	Closed("C"), Opened("O"), Pending("P");

	private String doorbellCode;

	private DoorbellEnum(String d) {
		doorbellCode = d;
	}

	public String getStatusCode() {
		return doorbellCode;
	}

}
