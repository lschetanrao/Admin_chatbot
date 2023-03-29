package admin;

public class Main_admin {
	String question;
	String answer;
	public String getQuestion() {
		//return InsertTable.insert_qa(question,answer);
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	public void call_qa(){
		 new InsertTable().insert_qa(question,answer);
	}
	
	
	

	

}
