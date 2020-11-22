package TokenSystem;

public class Token {
	private int token;
	private static class SingletonHelper{
		private static final Token instance = new Token();
	}
	private Token()
	{
		token = 0;
	}
	private void increment()
	{
		token += 1;
	}
	public static Token getInstance()
	{
		return SingletonHelper.instance;
	}
	public int getToken()
	{
		increment();
		return token;
	}
}
