package com.swingtech.common.core.util;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class StringUtil {
	public static String getPadString(int padNumber, String padCharacters) {
		StringBuffer padStringBuf = new StringBuffer();
		
		if (padNumber <= 0) {
			return "";
		}

		for (int i = 0; i <  padNumber; i++) {
			padStringBuf.append(padCharacters);
		}

		return padStringBuf.toString();
	}
	
	public static String padStringPre(String stringToPad, int padNumber, String padCharacters) {
		return StringUtil.padString(stringToPad, padNumber, padCharacters, true);
	}

	public static String padStringPre(String stringToPad, int padNumber, String padCharacters, boolean padToLength) {
		return StringUtil.padString(stringToPad, padNumber, padCharacters, true, padToLength, padNumber);
	}
	
	public static String padStringPost(String stringToPad, int padNumber, String padCharacters) {
		return StringUtil.padString(stringToPad, padNumber, padCharacters, false);
	}

	public static String padStringPost(String stringToPad, int padNumber, String padCharacters, boolean padToLength) {
		return StringUtil.padString(stringToPad, padNumber, padCharacters, false, padToLength, padNumber);
	}
	
	public static String padString(String stringToPad, int padNumber, String padCharacters, boolean prePend) {
		return StringUtil.padString(stringToPad, padNumber, padCharacters, prePend, false, null);
	}
	
	private static String padString(String stringToPad, int padNumber, String padCharacters, boolean prePend, boolean padToLength, Integer LengthToPadTo) 
	{
		if (padToLength) {
			padNumber = getPadLength(stringToPad, padNumber, padToLength, padNumber);
		}
		String padString = getPadString(padNumber, padCharacters);
		
		if (prePend) {
			return padString + stringToPad;
		} else {
			return stringToPad + padString;
		}
	}
	
	private static Integer getPadLength(String stringToPad, int padNumber, boolean padToLength, Integer LengthToPadTo) {
		if (!padToLength || LengthToPadTo == null || LengthToPadTo <=0) {
			return padNumber;
		}
		
		int stringLength = stringToPad.length();
		
		if (stringLength > LengthToPadTo) {
			return 1;
		} else {
			return LengthToPadTo - stringLength;
		}
	}

	public static Integer getLengthOFLongestStringInList(List<Object> testList, boolean getForKey) {
		return StringUtil.getLengthOFLongestStringInList(testList, getForKey, null);
	}

	public static Integer getLengthOFLongestStringInList(List<Object> testList, boolean getForKey, Integer maxLength) {
		String longestString = null;
		
		longestString = StringUtil.getStringWithLongestLengthInList(testList, getForKey, maxLength);
		
		return longestString.length();
	}
	
	public String getStringWithLongestLengthInList(List<Object> testList, boolean getForKey) {
		return StringUtil.getStringWithLongestLengthInList(testList, getForKey, null);
	}

	public static String getStringWithLongestLengthInList(List<Object> testList, boolean getForKey, Integer maxLength) {
		int longestStringLenth = 0;
		int currentStringLength = 0;
		String longestString = "";
		String currentString = "";
		String returnString = null;
		
		for (Object object : testList) {
			if (object == null) {
				continue;
			}
			
			if (object instanceof String) {
				currentString = (String)object;
			} else {
				currentString = object.toString();
			}

			if (maxLength != null && currentString.length() > maxLength) {
				return currentString;
			}
			
			returnString = StringUtil.getStringWithLogestLength(longestString, longestString, maxLength);
			
			if (returnString != null) {
				longestString = returnString;
			}
		}
		
		return longestString;
	}
	
	public static <X, T> Integer getLengthOFLongestStringInMap(Map<X, T> testMap, boolean getForKey) {
		return StringUtil.getLengthOFLongestStringInMap(testMap, getForKey, null);
	}

	public static <X, T> Integer getLengthOFLongestStringInMap(Map<X, T> testMap, boolean getForKey, Integer maxLength) {
		String longestString = null;
		
		longestString = StringUtil.getStringWithLongestLengthInMap(testMap, getForKey, maxLength);
		
		return longestString.length();
	}
	
	public static <X, T> String getStringWithLongestLengthInMap(Map<X, T> testMap, boolean getForKey) {
		return StringUtil.getStringWithLongestLengthInMap(testMap, getForKey, null);
	}

	public static <X, T> String getStringWithLongestLengthInMap(Map<X, T> testMap, boolean getForKey, Integer maxLength) {
		int longestStringLenth = 0;
		int currentStringLength = 0;
		String longestString = null;
		String currentString = null;
		String returnString = null;
		Object object = null;
		
		for (Entry<X, T> entry : testMap.entrySet()) {
			if (getForKey) { 
				object = entry.getKey();
			} else { 
				object = entry.getValue();
			}

			if (object == null)
			{
				continue;
			}
			
			if (object instanceof String) {
				currentString = (String)object;
			} else {
				currentString = object.toString();
			}

			if (maxLength != null && currentString.length() > maxLength) {
				return currentString;
			}
			
			if (longestString == null) {
				longestString = currentString;
			}
			
			longestString = StringUtil.getStringWithLogestLength(object, longestString, maxLength);
			
			if (returnString != null) {
				longestString = returnString;
			}
		}
		
		return longestString;
	}
	
	private static String getStringWithLogestLength(Object object, String longestString, Integer maxLength) {
		int longestStringLenth = 0;
		int currentStringLength = 0;
		String currentString = null;

		if (object == null) {
			return null;
		}
		
		if (object instanceof String) {
			currentString = (String)object;
		} else {
			currentString = object.toString();
		}

		if (maxLength != null && currentString.length() > maxLength) {
			return null;
		}
		
		currentStringLength = currentString.length();
		longestStringLenth = longestString.length();
		
		if (currentStringLength > longestStringLenth) {
			return currentString;
		} else {
			return longestString;
		}
	}

}
