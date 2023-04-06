package com.constructor;


public class Purchase {
		public int cid;
	    public String gid;
	    public String qty;
	    
	    
	    public Purchase(int cid,String gid,String qty) {
	    	this.cid = cid;
	    	this.gid = gid;
	    	this.qty = qty;
	    }
	    

		public void setCID(int cid) {
			this.cid = cid;
			
		}

		public void setGID(String gid) {
			this.gid = gid;
			
		}
		
		public void setQTY(String qty) {
			
			this.qty = qty;
		}
		
		public int getCID() {
			
			return cid;
		}

		public String getGID() {
			
			return gid;
		}
		
		public String getQTY() {
			
			return qty;
		}




}
