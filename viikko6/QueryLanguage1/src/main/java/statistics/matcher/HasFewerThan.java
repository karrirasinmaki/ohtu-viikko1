
package statistics.matcher;

public class HasFewerThan extends Not implements Matcher {

	public HasFewerThan(int value, String category) {
		super(new HasAtLeast(value, category));
	}
    
}
