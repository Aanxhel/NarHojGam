package veprincipalcomponentintern;

public class Gladiators {
	private int _life;
	private int _maximunlife;
	private int _attack;
	private int _maximunattack;

	private boolean _isturn;
	private int _delayofturn;
	private int _position;

	private int _maximunchakra;
	private int _chakraofreserve;
	private int _limitchakra;

	private String _name;
	private  int _idcharacter;
 
	public Gladiators(int idcharacter,String name){
	 _idcharacter=idcharacter;
	 _name=name;
	}
	
	  public int GetterChakraOfReserve(){
	  	return _chakraofreserve;
	  }
	  public void SetterrChakraOfReserve(){

	  }
	  public int GetterLife(){
	    return _life;
	  }
	  public void SetterLife(int life){
	  	_life=life;
	  }
	  public int GetMaximunChakra(){
		  return _maximunchakra;
	  }
	  public void SetterMaximunChakra(int maximunchakra ){
	  	_maximunchakra=maximunchakra;
	  }
	  public int GetterMaximunLife(){
	  	return _maximunlife;
	  }
	  public void SetterMaximunLife(int maximunlife){
	  	_maximunlife=maximunlife;
	  }
	  public int GetterAttack(){
	  	return _attack;
	  }
	  public void SetterAttack(int attack){
	  	_attack=attack;
	  }
	  public int GetterMaximunAttack(){
	  	return _maximunattack;
	  }
	  public void SetterMaximunAttack(int maximunattack){
	  	_maximunattack=maximunattack;
	  }
	public boolean GetterIsTurn(){
	  return _isturn;
	}
	public void SetterIsTurn(boolean isturn){
	  _isturn=isturn;	
	}
	public int GetterDelayOfTurn(){
	  return _delayofturn;	
	}
	public int GetterPosition(){
		return _position;
	}
	public void SetterPosition(int position){
		_position=position;
	}
	public String GetterName(){
		return _name;
	}
	public int GetterIdCharacter(){
	    return _idcharacter;	 
	}

	public  Object Clone(){
			
			Object obj;
			obj=null;
			try{
			 obj=super.clone();
			}catch(CloneNotSupportedException ex){
			 System.out.println(" no se puede duplicar");
			}
			return obj;
		 }
}