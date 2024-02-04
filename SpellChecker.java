
public class SpellChecker {


	public static void main(String[] args) {
		String word = args[0];
		////
		//String word2 = args[1];
		////
		int threshold = Integer.parseInt(args[1]);
		String[] dictionary = readDictionary("dictionary.txt");
		/////
		//System.out.println(levenshtein(word, word2));
		//////

		String correction = spellChecker(word, threshold, dictionary);
		System.out.println(correction);
	}

	public static String tail(String str) {
		String noHead = str.substring(1);
		return noHead;
	}

	public static int levenshtein(String word1, String word2) {
		// Your code goes here
		word1 = word1.toLowerCase();
		word2 = word2.toLowerCase();
		if (word1.length() == 0)
		{
			return word2.length();
		}
		if (word2.length() == 0)
		{
			return word1.length();
		}

		 if (word1.charAt(0) == word2.charAt(0)) {
			 return levenshtein((tail(word1)),tail (word2));
		 }
		else {
			return (1 + Math.min ((Math.min(levenshtein(tail(word1), word2), levenshtein(word1, tail(word2)))), levenshtein((tail(word1)), (tail(word2)))));
		}

	}

	public static String[] readDictionary(String fileName) {
		String[] dictionary = new String[3000];

		In in = new In(fileName);
		for (int i = 0; i < dictionary.length; i ++)
		{
			dictionary[i] = in.readLine();
		}
		return dictionary;
	}

	public static String spellChecker(String word, int threshold, String[] dictionary) {
		String similar = "0";
		int lev = 0;
		for (int i = 0; i < dictionary.length; i ++)
		{
			lev = levenshtein(word, dictionary[i]);
			if (lev <= threshold)
			{
				// in order to find the most closet word and not the first one
				if (levenshtein(word, similar) > threshold)
				{
					similar = dictionary [i];
				}

			}
		}
		if (similar.charAt(0) == '0')
		{
			return word;
		}
		else return similar;
		}
	}
	



