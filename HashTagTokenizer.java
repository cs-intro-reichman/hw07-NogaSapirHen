

public class HashTagTokenizer {

	public static void main(String[] args) {

		String hashTag = args[0];
		String []dictionary = readDictionary("dictionary.txt");
		breakHashTag(hashTag, dictionary);
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

	public static boolean existInDictionary(String word, String []dictionary) {
		boolean isSame = false;
		for (int i = 0; i < dictionary.length; i ++)
		{
			if (SameWord (word, dictionary[i]))
			{
				isSame = true;
			}
		}
		return isSame;
	}

	public static boolean SameWord (String word, String dicStr)
	{
		/** gets two words and returns if they are equal */
		if (word.length()!= dicStr.length())
		{
			return false;
		}
		for (int i = 0; i < word.length(); i ++)
		{
			if (word.charAt(i) != dicStr.charAt(i))
			{
				return false;
			}
		}
		return true;
	}


	public static void breakHashTag(String hashtag, String[] dictionary) {

		// Base case: do nothing (return) if hashtag is an empty string.
        if (hashtag.isEmpty()) {
            return;
        }
		hashtag = hashtag.toLowerCase();
        int N = hashtag.length();
        for (int i = 1; i <= N; i++) {
		if ( existInDictionary(hashtag.substring(0,i), dictionary)) {
			System.out.println(hashtag.substring(0,i));
			breakHashTag (hashtag.substring(i), dictionary);
			//abstain repeating the same letters
			return;
		}
        }
	}
}