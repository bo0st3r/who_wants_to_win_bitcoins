package modele;

import java.util.ArrayList;
import java.util.List;

import exceptions.NotAllAnswersException;
import exceptions.QuestionAlreadyPresentException;

public class Deck {
	private static final long serialVersionUID = 6638000761501455L;
	private List<Question> questions;

	public Deck() {
		questions = new ArrayList<>();
	}

	/*
	 * This method adds a question to the deck if it's not yet in.
	 * 
	 * @param question A Question object
	 * 
	 * @throws QuestionAlreadyPresentException Occurs if the question is already in
	 * the deck.
	 * 
	 * @throws NotAllAnswersException Occurs if the question has less than 4
	 * possible answers.
	 */
	public boolean addQuestion(Question question) throws QuestionAlreadyPresentException, NotAllAnswersException {
		if (questions.contains(question))
			throw new QuestionAlreadyPresentException(question.getStatement());

		if (question.getNbAnswers() < 4)
			throw new NotAllAnswersException(question.getStatement());

		return questions.add(question.clone());
	}

	public String toString() {
		String result = "Here's the questions of this deck :\n";

		for (Question q : questions) {
			result += q.toString() + "\n";
		}

		return result;
	}

	public int getDeckSize() {
		return questions.size();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((questions == null) ? 0 : questions.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Deck other = (Deck) obj;
		if (questions == null) {
			if (other.questions != null)
				return false;
		} else if (!questions.equals(other.questions))
			return false;
		return true;
	}

}