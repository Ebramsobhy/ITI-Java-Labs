/* Receives two inputs (as main arguments) a number and a string and prints
   the string on different lines according to the given number.
   */

class task3{
	public static void main(String args[]){
		int x=0;
		if(args.length!=2)
			System.out.println("You Must Enter 2 Arguments Only");
		else{
			try{
				x=Integer.parseInt(args[0]);
			}
			catch(NumberFormatException abs){
				System.out.println("First Number Must be Number");
			}
			if(x>0){
				for(int i=0;i<x;i++){
					System.out.println(args[1]);
				}
			}
			else
				System.out.println("You Must enter at Least 1");
		}
	}
}