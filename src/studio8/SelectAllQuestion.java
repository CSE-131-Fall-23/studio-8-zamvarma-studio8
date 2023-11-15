package studio8;

public class SelectAllQuestion extends MultipleChoiceQuestion {

	public SelectAllQuestion(String prompt, String answer, String[] choices) {
		//Hint: 1 point per choice
		super(prompt, answer, choices.length, choices);
		//FIXME
	}
	
	public int checkAnswer(String givenAnswer) {
		int cP = super.getPoints();
		
		char[] answers = givenAnswer.toCharArray();
		
		for (int i =0; i< answers.length; i++) {
			int count = 0;
			for (int k = 0; k< super.getAnswer().length(); k++) {
				if (answers[i] != super.getAnswer().charAt(k)) {
					count ++;
				}
			}
			
			if (count == super.getAnswer().length()) {
				cP--;
			}
			
		}
		
		for (int i =0; i< super.getAnswer().length(); i++) {
			int count = 0;
			for (int k = 0; k< answers.length; k++) {
				if (super.getAnswer().charAt(i) != answers[k]) {
					count ++;
				}
			}
			
			if (count == answers.length) {
				cP--;
			}
			
		}
		
		return cP;
	}
	
	public static void main(String[] args) {
		String[] choices = {"instance variables", "git", "methods", "eclipse"};
		Question selectAll = new SelectAllQuestion("Select all of the following that can be found within a class:", "13", choices);
		selectAll.displayPrompt();
		System.out.println(selectAll.checkAnswer("hi")); //no credit
		System.out.println(selectAll.checkAnswer("13")); //full credit
		System.out.println(selectAll.checkAnswer("31")); //full credit
		System.out.println(selectAll.checkAnswer("1")); //3 points
		System.out.println(selectAll.checkAnswer("3")); //3 points
		System.out.println(selectAll.checkAnswer("23")); //2 points
		System.out.println(selectAll.checkAnswer("34")); //2 points
		System.out.println(selectAll.checkAnswer("4")); //1 point
		System.out.println(selectAll.checkAnswer("124")); //1 point
		System.out.println(selectAll.checkAnswer("24")); //0 points
		
	}
}
