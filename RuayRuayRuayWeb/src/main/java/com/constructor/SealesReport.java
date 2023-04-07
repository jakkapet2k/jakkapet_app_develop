package com.constructor;

public class SealesReport {
	int row;
	public String year;
	public String month;
	public String sumsale;

	public SealesReport(String year, String month, String sumsale,int row) {
		this.year = year;
		this.month = month;
		this.sumsale = sumsale;
		this.row=row;
	}

	public String getyerr() {
		return year;
	}

	public String getmonth() {
		return month;
	}

	public String getsumsales() {
		return sumsale;
	}

	public int getfor() {
		int count = 0;
		for (int i = 0; i <= row; i++) {
			count = i;
		}
		return count;
	}

}