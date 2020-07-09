package ve;
//fecha:05 /06/2020
//Class PrincipalGame 
//Se encarga de implemtar los metodos principales del juego
public class PrincipalGame implements ModesOfTheGame, Cloneable {

	public void DefaulSelectingLevel() {
		// TODO Auto-generated method stub
		
	}

	public void DefaulCrossingDungeon() {
		// TODO Auto-generated method stub
		
	}

	public void DefaulOpeningCoffer() {
		// TODO Auto-generated method stub
		
	}
	public void ExecutingModes()
	{
		
	}
	public  Object clone(){
		
		Object obj;
		obj=null;
		try{
		 obj=super.clone();
		}catch(CloneNotSupportedException ex){
		 System.out.println(" no se puede duplicar");
		}
		return (PrincipalGame)obj;
	 }
	public void DefaulFighting() {
		// TODO Auto-generated method stub
		
	}

}
