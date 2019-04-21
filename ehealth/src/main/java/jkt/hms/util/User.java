
package jkt.hms.util;
import static jkt.hms.util.RequestConstants.logins;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;

public class User implements HttpSessionBindingListener   {
	

    // All logins.
 //   private static Map<User, HttpSession> logins = new HashMap<User, HttpSession>();

    public User(String userName) {
		this.username = userName;
	}

	public User() {
		// TODO Auto-generated constructor stub
	}

	// Normal properties.
    protected void initialize () {}
    private Long id;
    private String username;
    
    private int intData;

    

    public void setUser(String data) {

      this.username = data;
      initialize();

    }
    
    public java.lang.String getUser () {
		return username;
	}
    // Etc.. Of course with public getters+setters.

   

	@Override
    public boolean equals(Object other) {
        return (other instanceof User) && (username != null) ? username.equals(((User) other).username) : (other == this);
    }

    @Override
    public int hashCode() {
        return (username != null) ? (this.getClass().hashCode() + username.hashCode()) : super.hashCode();
    }

    @Override
    public void valueBound(HttpSessionBindingEvent event) {
    	//System.out.println("sessiojn build="+logins.size());
    	System.out.println("Name="+this.username);
    	 HttpSession session = logins.remove(this.username);
         System.out.println("session in bound="+session );
        if (session != null) {
            session.invalidate();
        }
        logins.put(this.username, event.getSession());
    }

    @Override
    public void valueUnbound(HttpSessionBindingEvent event) {
    	//System.out.println("sessiojn remove");
    	
    	//String UserName = (String)session.getAttribute("userName");
    	HttpSession session = logins.remove(this.username);
       
    }
    
   


}
