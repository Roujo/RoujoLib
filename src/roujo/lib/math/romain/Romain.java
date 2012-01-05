package roujo.lib.math.romain;

public class Romain {
	private String romain;
	private int arabe;
	
	public Romain(){
	}
	
	public Romain(String romain) {
		this.romain = romain;
	}
	
	public void conversion(){
		arabe = toArabe(romain);
	}
	
	public void printRomain(){
		System.out.println(romain);
	}
	
	public void printArabe(){
		System.out.println(arabe);
	}
	
	public static int toArabe(String romain){
		char[] temp = romain.toUpperCase().toCharArray();
		int arabe = 0;
		int minus = 0;
		int niveau = 0;
		for(int i = 0; i < temp.length; ++i)
		{
			try{
				switch(temp[i]){
					case 'M':
						check(0, niveau);
						arabe += 1000 - minus;
						minus = 0;
						break;
					case 'D':
						check(1, niveau);
						niveau = 1;
						arabe += 500 - minus;
						minus = 0;
						break;
					case 'C':
						check(2, niveau);
						niveau = 2;
						arabe += 100 - minus;
						minus = 0;
						break;
					case 'L':
						check(3, niveau);
						niveau = 3;
						arabe += 50 - minus;
						minus = 0;
						break;
					case 'X':
						check(4, niveau);
						niveau = 4;
						arabe += 10 - minus;
						minus = 0;
						break;
					case 'V':
						check(5, niveau);
						niveau = 5;
						arabe += 5 - minus;
						minus = 0;
						break;
					case 'I':
						if(i < temp.length - 1 && temp[i+1] != 'I'){
							minus = 1;
						}
						else
						{
							arabe += 1;
						}
						break;
					default:
						throw new ChiffreRomainInvalide();
				}
			} catch (ExceptionRomaine e){
				System.out.println("Exception: " + e.toString());
			}
		}
		
		return arabe;
	}
		
	private static void check(int test, int niveau) throws FormatRomainInvalide{
		if (test < niveau)
		{
			throw new FormatRomainInvalide();
		}
	}
}
