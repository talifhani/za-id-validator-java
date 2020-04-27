package talifhani.zaidvalidator;

/**
 * @author Tali Luvhengo <tali@semicolon.co.za>
 */
public class Luhn
{
	/**
	 * @param string $number
	 * @return int
	 */

	/**
	 *
	 * @param number
	 * @return int
	 */
	public static int generate(String number)
	{
		// if ( ! ctype_digit($number))
		// 	throw new Exception("Number can only have digits");

		int length = number.length();
		int sum    = 0;
        int weight = 2;
        char[] numberArray = number.toCharArray();

		for (int i = length - 1; i >= 0; i--)
		{
			int digit = weight * (numberArray[i] - '0');
			sum += Math.floor(digit / 10) + digit % 10;
			weight = weight % 2 + 1;
		}

		return (10 - sum % 10) % 10;
	}
}