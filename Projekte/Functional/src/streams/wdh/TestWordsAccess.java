package streams.wdh;

import java.util.List;

import words.Words;

public class TestWordsAccess {

	public static void main(String[] args) {
		
		List<String> passwords = Words.passwords();
		System.out.println("Passwörter geladen: " + passwords.size());

	}

}
