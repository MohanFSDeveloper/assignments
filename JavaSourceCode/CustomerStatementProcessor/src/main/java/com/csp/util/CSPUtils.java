package com.csp.util;
import java.util.ArrayList;
import java.util.List;

/*import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.jsoup.Jsoup;
import org.jsoup.safety.Whitelist;

import com.tcs.ibbis.dl.ingestion.common.exception.CoreException;*/

public class CSPUtils{


	public static final String BLANK = "";
	public static final Integer DEFAULT_INTEGER = -1;
	

	public static <T> boolean isNullOrEmptyOrDefault(Object value) {
		boolean isNullOrEmptyOrDefault = false;
		if (value == null) {
			isNullOrEmptyOrDefault = true;
		} else if (value != null && value == DEFAULT_INTEGER) {
			isNullOrEmptyOrDefault = true;
		} else if (value instanceof String) {
			String sValue = (String) value;
			isNullOrEmptyOrDefault = isBlankOrNull(sValue);
		} else if (value instanceof List) {
			List<T> sValue = (ArrayList<T>) value;
			isNullOrEmptyOrDefault = isBlankOrNull(sValue);
		}
		return isNullOrEmptyOrDefault;
	}

	public static boolean isBlankOrNull(String s) {
		if (s == null)
			return true;
		if (s.trim().equals(String.valueOf((Object) null)))
			return true;
		return (s.trim().length() == 0);
	}

	public static <T> boolean isBlankOrNull(List<T> list) {
		if (list == null)
			return true;
		return (list.size() == 0);
	}
	
	public static boolean isAlphaNumericWithSpace(String text) {
		if (text == null || text.length() == 0) {
			return false;
		}

		String rg = "^[a-zA-Z0-9 ]+$";
		if (!text.matches(rg))
			return false;
		else
			return true;
	}

	public static boolean isAlphaNumeric(String text) {

		if (text == null || text.length() == 0) {
			return false;
		}

		String rg = "^[a-zA-Z0-9]+$";
		if (!text.matches(rg))
			return false;
		else
			return true;
	}

	public static boolean isNumber(String text) {

		if (text == null || text.length() == 0) {
			return false;
		}

		String rg = "[0-9]";
		if (!text.matches(rg))
			return false;
		else
			return true;
	}

	public static boolean isNumericWithComma(String text) {

		if (text == null || text.length() == 0) {
			return false;
		}

		String rg = "^([1-9]\\d*|0)(\\,\\d)?$";
		if (!text.matches(rg))
			return false;
		else
			return true;
	}


/*	public static boolean checkCellValue(Cell cell) {
		if (null != cell && (cell.getCellType() != Cell.CELL_TYPE_BLANK))
			return true;
		return false;
	}

	public static boolean isEmpty(Row row) {
		for (int i = 0; i < row.getPhysicalNumberOfCells(); i++) {
			if (null != row.getCell(i)) {
				if (row.getCell(i).getCellType() != Cell.CELL_TYPE_BLANK) {
					return true;
				}
			}
		}
		return false;
	}*/

	public static boolean isEmpty(Object aParam){
		if(null == aParam )
			return false;
		return true;
	}


}
