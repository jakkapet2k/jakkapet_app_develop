package com.constructor;


public class UserLogin {
	
	    public String user;
	    public String pass;
	    
	    
	    public UserLogin( String user,String pass) {
	    	this.user = user;
	    	this.pass = pass;
	    }
	    

		public void setUsername(String user) {
			this.user = user;
			
		}


		public String getUsername() {
			
			return user;
		}
		
		public String getPassword() {
			
			return pass;
		}


		public void setPassword(String pass) {
			
			this.pass = pass;
		}

}
