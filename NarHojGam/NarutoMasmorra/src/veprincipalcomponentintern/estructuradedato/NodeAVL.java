package veprincipalcomponentintern.estructuradedato;

public class NodeAVL {
		private NodeAVL _Left;
		private NodeAVL _Right;
	    private int _id;
		private int _height;

		public NodeAVL(int id) {
			_id=id;
		 	_Left = null;
			_Right = null;
		}
		public NodeAVL GetterLeft(){
			return _Left;
		}
		public void SetterLeft(NodeAVL Left){
			_Left=Left;
		}
		public NodeAVL GetterRight(){
			return _Right;
		}
		public void SetterRight(NodeAVL Right){
			_Right=Right;
		}
		public int GetterId(){
	      return _id;		
		}
		public void SetterId(int id){
	     _id=id;		
		}
		public int GetterHeight(){
		 return _height;	
		}
		public void SetterHeight(int height){
		  _height=height;	
		}
	}
