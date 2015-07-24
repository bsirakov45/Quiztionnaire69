package main;

public class Question {
	private int id; 
	private String questionText; 
	private String rightAnswerText;
	private String wrongAnswerText1;
	private String wrongAnswerText2;
	
	public Question(int id, String questionText, String rightAnswerText,
			String wrongAnswerText1, String wrongAnswerText2,
			String wrongAnswerText3) {
		
		this.id = id;
		this.questionText = questionText;
		this.rightAnswerText = rightAnswerText;
		this.wrongAnswerText1 = wrongAnswerText1;
		this.wrongAnswerText2 = wrongAnswerText2;
		this.wrongAnswerText3 = wrongAnswerText3;
	}
	
	/**
	 * Get method for user's ID. 
	 * @return id
	 */
	public int getId() {
		return id;
	}
	
	/**
	 * set method for user's ID.
	 * @param id
	 */
	public void setId(int id) {
		this.id = id;
	}
	
	/**
	 * Get method for the question text. 
	 * @return questionText
	 */
	public String getQuestionText() {
		return questionText;
	}
	
	/**
	 * Set method for the question text. 
	 * @param questionText
	 */
	public void setQuestionText(String questionText) {
		this.questionText = questionText;
	}
	
	/**
	 * Get method for the right answer of the question. 
	 * @return rightAnswerText
	 */
	public String getRightAnswerText() {
		return rightAnswerText;
	}
	
	/**
	 * Set method for right answer of the question. 
	 * @param rightAnswerText
	 */
	public void setRightAnswerText(String rightAnswerText) {
		this.rightAnswerText = rightAnswerText;
	}
	
	/**
	 * Set method for a wrong answer. 
	 * @return wrongAnswerText
	 */
	public String getWrongAnswerText1() {
		return wrongAnswerText1;
	}
	
	/**
	 * Set method for a wrong answer. 
	 * @param wrongAnswerText1
	 */
	public void setWrongAnswerText1(String wrongAnswerText1) {
		this.wrongAnswerText1 = wrongAnswerText1;
	}
	
	/**
	 * Get method for the question's wrong answer text. 
	 * @return wrongAnswerText3;
	 */
	public String getWrongAnswerText2() {
		return wrongAnswerText2;
	}
	
	/**
	 * Set method for a wrong answer. 
	 * @return wrongAnswerText
	 */
	public void setWrongAnswerText2(String wrongAnswerText2) {
		this.wrongAnswerText2 = wrongAnswerText2;
	}
	/**
	 * Get method for the question's wrong answer text. 
	 * @return wrongAnswerText3;
	 */
	public String getWrongAnswerText3() {
		return wrongAnswerText3;
	}
	/**
	 * Set method for a wrong answer. 
	 * @return wrongAnswerText
	 */
	public void setWrongAnswerText3(String wrongAnswerText3) {
		this.wrongAnswerText3 = wrongAnswerText3;
	}
	
}
