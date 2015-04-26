package statistics.matcher;

import java.util.LinkedList;

public class MatcherBuilder {

	private LinkedList<Matcher> matchers;
	
	public MatcherBuilder() {
		matchers = new LinkedList<Matcher>();
	}
	
	public Matcher build() {
		return new And(matchers.toArray(new Matcher[0]));
	}

	public MatcherBuilder and(Matcher... matchers) {
		this.matchers.push(new And(matchers));
		return this;
	}
	
	public MatcherBuilder or(Matcher... matchers) {
		this.matchers.push(new Or(matchers));
		return this;
	}
	
	public MatcherBuilder not(Matcher matcher) {
		this.matchers.push(new Not(matcher));
		return this;
	}
	
	public MatcherBuilder playsIn(String team) {
		this.matchers.push(new PlaysIn(team));
		return this;
	}
	
	public MatcherBuilder hasAtLeast(int value, String category) {
		this.matchers.push(new HasAtLeast(value, category));
		return this;
	}
	
	public MatcherBuilder hasFewerThan(int value, String category) {
		this.matchers.push(new HasFewerThan(value, category));
		return this;
	}
	
}
