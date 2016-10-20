package icici_v2;

class CustomException extends Exception{
	
}

public class VUClip {

	public static boolean checkArgs (String[] args) throws Exception{
		if (args.length!=2){
			throw new CustomException();
		}
		return true;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
try{
	VUClip.checkArgs(args);
}catch(CustomException c){
	System.out.println("c");
}catch (Exception e){
	System.out.println("e");
}
	}

}
