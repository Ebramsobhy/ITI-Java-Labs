import java.util.function.Function;

class temperature{
	public static void main(String []args){
		Function<Integer,Float> Fahrenheit= celsius -> ( (celsius*9)/5) + 32.0f;
		System.out.println(Fahrenheit.apply(35));
	}
}

