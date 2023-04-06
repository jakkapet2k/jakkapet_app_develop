package com.constructor;


public class UserLogin {
		public int id;
	    public String user;
	    public String pass;
	    
	    
	    public UserLogin(String user,String pass) {
	    	this.user = user;
	    	this.pass = pass;
	    }
	    

		public void setUsername(String user) {
			this.user = user;
			
		}

		public void setId(int id) {
			this.id = id;
			
		}
		
		public void setPassword(String pass) {
			
			this.pass = pass;
		}
		
		public int getId() {
			
			return id;
		}

		public String getUsername() {
			
			return user;
		}
		
		public String getPassword() {
			
			return pass;
		}




}
