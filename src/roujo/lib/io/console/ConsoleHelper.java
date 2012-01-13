package roujo.lib.io.console;

import roujo.lib.StringHelper;

public abstract class ConsoleHelper {
	public static int showMenu(String header, String[] choices) {
		return showMenu(header, choices, "*");
	}

	public static int showMenu(String header, String[] choices, String border) {
		int headerWidth = header.length() + 8;
		int longestIndex = StringHelper.findLongestElement(choices);
		int choicesWidth = choices[longestIndex].length()
				+ Integer.toString(choices.length).length() + 2 + 4;
		int width;
		boolean titleAligned = headerWidth > choicesWidth;
		if (titleAligned) {
			width = headerWidth;
		} else {
			width = choicesWidth;
		}

		String full = StringHelper.repeat(border, width);
		
		System.out.println(full);
		System.out.println("*" + StringHelper.center(header, width - 2) + "*");
		System.out.println(full);
		
		for(int i = 0; i < choices.length; ++i){
			StringBuilder builder = new StringBuilder();
			builder.append("* " + (i + 1) + ") " + choices[i]);
			builder.append(StringHelper.repeat(" ", width - builder.length() - 1) + "*");
			System.out.println(builder.toString());
		}
		System.out.println(full);
		return 0;
	}

	public static int askQuestion(String question, int[] answers) {
		System.out.print(question);
		return 0;
	}
}
