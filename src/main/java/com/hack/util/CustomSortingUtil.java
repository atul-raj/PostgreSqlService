package com.hack.util;

import java.util.Comparator;

import com.hack.repositories.entities.ChartData;

public class CustomSortingUtil {
	
	public static Comparator<ChartData> siteByAscending = new Comparator<ChartData>() {
		public int compare(ChartData s1, ChartData s2) {
			return s1.getSiteName().compareTo(s2.getSiteName());
		}
	};
	
	public static Comparator<ChartData> siteByDescinding = new Comparator<ChartData>() {
		public int compare(ChartData s1, ChartData s2) {
			return s2.getSiteName().compareTo(s1.getSiteName());
		}
	};

}
