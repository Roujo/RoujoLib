package roujo.lib;

public abstract class StringHelper {
	public static String repeat(String string, int count) {
		StringBuilder build = new StringBuilder();
		for (int i = 0; i < count; ++i) {
			build.append(string);
		}
		return build.toString();
	}

	public static int findLongestElement(String[] strings) {
		int longestLength = strings[0].length();
		int longestIndex = 0;
		for (int i = 1; i < strings.length; ++i) {
			if (strings[i].length() > longestLength) {
				longestIndex = i;
				longestLength = strings[i].length();
			}
		}
		return longestIndex;
	}

	public static String padRight(String string, int length) {
		return padRight(string, length, " ");
	}

	public static String padRight(String string, int length, String pad) {
		return string + repeat(pad, length);
	}

	public static String center(String string, int width) {
		int padLength = width - string.length();
		if (padLength % 2 == 0) {
			String pad = repeat(" ", padLength / 2);
			return pad + string + pad;
		} else {
			String pad = repeat(" ", (padLength - 1) / 2);
			return pad + string + pad + " ";
		}
	}
}
