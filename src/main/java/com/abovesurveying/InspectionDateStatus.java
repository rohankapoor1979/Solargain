package com.abovesurveying;

public enum InspectionDateStatus {

	VALID,
	INVALID;

	private static String INVALID_INSPECTION_DATE = "1970-01-01T00:00:00.000Z";
	
	public static InspectionDateStatus statusOf(String inspectionDate) {
		if (INVALID_INSPECTION_DATE.equals(inspectionDate)) {
			return INVALID;
		}
		return VALID;
	}

}
