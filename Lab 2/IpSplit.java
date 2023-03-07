 /* Q-3 Split a string represent an IP address */
 
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class IpSplit{
	public static void main(String args[])
	{
		if (args.length>0){
			for(int i=0 ; i<args.length ;i++)
			{
				String str = args[i]; 
				String value = "(\\d{1,2}|(0|1)\\d{2}|2[0-4]\\d|25[0-5])";
				Pattern pattern = Pattern.compile(value + "\\." + value + "\\." + value + "\\." + value);
				Matcher matcher = pattern.matcher(str.trim());
				if (matcher.matches()){
					String ip_splited[] = str.trim().split("\\.");
					for (String x : ip_splited)
						System.out.println(x);
				}else{
					System.out.println("Enter a Valid IP");
				}
			}
		}
		else
			System.out.println("You Must Enter at least one IP");
	}
}