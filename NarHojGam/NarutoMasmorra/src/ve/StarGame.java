package ve;
//fecha:05 /06/2020
//Class StarGame 
//Se encarga de llamar y ejecutar el objeto principal 
public class StarGame implements Cloneable{
 private PrincipalGame _executer; 
 private static StarGame _star;
 public StarGame()
 {
	this._executer=new PrincipalGame(); 
 }
 public static StarGame getStarGame()
 {
	boolean iscreated;
	
	iscreated=_star==null;
	
    return (iscreated) ? _star=new StarGame()
    	                
                        :_star;
    
 }
 public PrincipalGame getexecuter()
 {
	return  (PrincipalGame) this._executer.clone();
 }
 
 

}
