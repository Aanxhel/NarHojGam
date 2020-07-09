package veprincipalcomponentintern.estructuradedato;

import ve.CompenentContionals;

public class TreeAVL implements CompenentContionals {
		
   private NodeAVL _Root;
   private int _eyes;
		 
	public TreeAVL() {
				
	   _eyes=0;
	   _Root=null;
	}
	private int VerifyHeight(NodeAVL Root) {
             
	    return IsEmpty(Root) ? -1 
				    	      :Root.GetterHeight();
	}
	public boolean IsEmpty(NodeAVL Root){

		return (Root == null);
	}
	public void AddElement(int id) {
				
		_Root = AddElement(id,_Root);
	}
	public void Eliminate(int id) {
	
		_Root = Eliminate(_Root, id);
	}
	private boolean IsElementOfRootLess(NodeAVL Root,int id){
		       
		return IsElementLess(id,Root.GetterId());	
	}
	private int ComputeDiferentHeight(int height1,int height2){

	    return height1-height2;	
	}
	private boolean IsBalancing(int height1,int height2){

	    return ComputeDiferentHeight(height1,height2)==2;	
	}
	private NodeAVL BalancingSimpleDouble(NodeAVL Root,int id){
	
		return (IsElementOfRootLess(Root,id)) ? 	ChangeLeft(Root)
			                                      : ChangeRightLeft(Root);
	}
	private NodeAVL BalancingDoubleSimple(NodeAVL Root , int id){
				
				return (IsElementOfRootLess(Root,id))?  ChangeLeftRight(Root):
				                                         ChangeRight(Root);
	}
	private void VerifyElementOlderAndRoot(NodeAVL Root,int id){
    
        if (IsBalancing(VerifyHeight(Root.GetterLeft()),
					    VerifyHeight(Root.GetterRight()))) {
			
			if (IsElementOlder(Root.GetterId(),id)){   
							
				BalancingSimpleDouble(Root,id);
						    
			}	
	    }
	   
    }
    private void VerifyElementLessAndRoot(NodeAVL Root, int id){
        
        if (IsBalancing(VerifyHeight(Root.GetterLeft()),
  		                VerifyHeight(Root.GetterRight()))){
					 
			if (IsElementOfRootLess(Root,id)){
						   
				BalancingDoubleSimple(Root,id);
		    }

		}   
    }
    private NodeAVL Eliminate(NodeAVL Root, int id) {
		
		if (IsEmpty(Root)){
					
		    return Root;
		} else {
				
			if (IsElementOfRootLess(Root,id)) {
			 		
			    Root.SetterLeft(Eliminate(Root.GetterLeft(),id));
				 VerifyElementLessAndRoot(Root,id);	
	
		     } else if (IsElementOlder(Root.GetterId(),id)){
				 
				 Root.SetterRight(Eliminate(Root.GetterRight(), id));
                 VerifyElementOlderAndRoot(Root,id);	    
	         
	         } else{
			      
			    if (IsEmpty(Root.GetterRight())) {
	     						 
	     			return Root.GetterLeft();
	            
	            } else if (IsEmpty(Root.GetterLeft())){
	     						  
	     	        return Root.GetterRight();
	     	    }   
				
				NodeAVL AuxiliaryRoot=Root;
				Root = LeastValue(AuxiliaryRoot.GetterRight());
				Root.SetterRight(AuxiliaryRoot);
				Root.SetterLeft((EliminateMinimun(AuxiliaryRoot.GetterRight())));
			}
				
			Root.SetterHeight(ComputeMaximun(VerifyHeight(Root.GetterLeft()),
						                     VerifyHeight(Root.GetterRight())));
            return Root;
		}
	}
	private NodeAVL AddElement(int id, NodeAVL Root1) {
				// TODO Auto-generated method stub
		if (IsEmpty(Root1)){
			Root1 = new NodeAVL(id);
			_eyes++; 

		} else {
		  
		    if (IsElementOfRootLess(Root1,id)) {
							 
		        Root1.SetterLeft( AddElement(id, Root1.GetterLeft()));
				VerifyElementLessAndRoot(Root1,id);	

			} else if (!IsElementOfRootLess(Root1,id)) {
						     
			    Root1.SetterRight(AddElement(id,Root1.GetterRight()));
				VerifyElementOlderAndRoot(Root1,id);
			}
	    }
				    
		Root1.SetterHeight(ComputeMaximun(VerifyHeight(Root1.GetterLeft()),
							              VerifyHeight(Root1.GetterRight())));
		return Root1;
	}
	private NodeAVL EliminateMinimun(NodeAVL Root1) {
				// TODO Auto-generated method stub
		
		if (IsEmpty(Root1.GetterLeft())) return Root1.GetterRight();
		Root1.SetterLeft(EliminateMinimun(Root1.GetterLeft()));
		return Root1;
			
				
	}
	public NodeAVL LeastValue(NodeAVL AuxiliaryRoot) {
		
		if(!IsEmpty(AuxiliaryRoot.GetterLeft())){
				  
		    AuxiliaryRoot=LeastValue(AuxiliaryRoot.GetterLeft());
		
		}
        return  AuxiliaryRoot ;
			
	}
	private NodeAVL ChangeRight(NodeAVL Pivot) {
			
	    NodeAVL NewPivot;
		NewPivot =Pivot.GetterLeft();
		Pivot.SetterLeft(NewPivot.GetterRight());
		NewPivot.SetterRight(Pivot);
		Pivot.SetterHeight(ComputeMaximun(VerifyHeight(Pivot.GetterLeft()), 
					                      VerifyHeight(Pivot.GetterRight())));	
		NewPivot.SetterHeight(ComputeMaximun(VerifyHeight(Pivot.GetterLeft()),
					                         VerifyHeight(Pivot.GetterRight())));
		 return NewPivot;
	}
	private int ComputeMaximun(int height1,int height2){

	    return Math.max(height1,height2)+1; 
	}
	private NodeAVL ChangeLeft(NodeAVL Pivot) {
				
		NodeAVL NewPivot = Pivot.GetterRight();
		Pivot.SetterRight(NewPivot.GetterLeft());	
		NewPivot.SetterLeft(Pivot);
		Pivot.SetterHeight(ComputeMaximun(VerifyHeight(Pivot.GetterLeft()),
					                      VerifyHeight(Pivot.GetterRight())));
		NewPivot.SetterHeight(ComputeMaximun(VerifyHeight(NewPivot.GetterLeft()),
				                             VerifyHeight(Pivot.GetterRight())));	  
		return NewPivot;
	}
    private NodeAVL ChangeRightLeft(NodeAVL Pivot){
		      
		Pivot.SetterRight(ChangeRight(Pivot.GetterRight()));
		return ChangeLeft(Pivot);
	}
	private NodeAVL ChangeLeftRight(NodeAVL Pivot) 	{
			   
	    Pivot.SetterLeft(ChangeLeft(Pivot.GetterLeft()));
		return ChangeRight(Pivot);
	}
	public int Find(int id)
	{	
		return Find(id,_Root);
		       
	}
	private int Find(int id, NodeAVL Root)
	{
		    	
		if(IsEmpty(Root)||IsELementEqual(Root.GetterId(),id)){
		 
			 return Root.GetterId();
		} else {
			
		      if (IsElementOfRootLess(Root,id)) {
		    	 
		                     return Find(id,Root.GetterLeft());
		        } else {
		        	  
		                  return Find(id,Root.GetterRight());
		        
		        }
		}
	}
	public void inorden(){
			   
		inorden(_Root);	
	}
    public int GetterEyes() { 

    	return _eyes;
    }
	private void inorden(NodeAVL Root) {
			       
		if(!IsEmpty(Root)){
		  
		    inorden(Root.GetterLeft());
		    System.out.println(Root.GetterId());
			inorden(Root.GetterRight());
		}
	}
	public NodeAVL GetterRoot(){
		
	 return _Root;	
	}
    public boolean IsElementOlder(int number1,int number2) {
				
		return number1>number2;
	}
	public boolean IsElementLess(int number1,int number2) {
				// TODO Auto-generated method stub
				return number1<number2;
	}
	public boolean IsELementEqual(int number1,int number2) {
				// TODO Auto-generated method stub
				return number1==number2;
	}
	public static void main(String ar[]){
	
		TreeAVL Tree=new TreeAVL();
		Tree.AddElement(3);
		Tree.AddElement(6);
		Tree.AddElement(2);
		Tree.AddElement(7);
		Tree.AddElement(8);
		Tree.AddElement(9);
		Tree.AddElement(10);
		Tree.AddElement(4);
		Tree.inorden();	
		System.out.println();
		//System.out.println(Tree.LeastValue(Tree.GetterRoot()).GetterId());
		Tree.Eliminate(11);
		Tree.inorden();
		
		///System.out.println(Tree.Find(3));
		//System.out.println();
		
	}
}		