
package Blog;

public class User {
    
    private String userName;
    private String password;
    private String name;
    
    public User(String uname, String password, String name){
        this.userName = uname;
        this.password = password;
        this.name = name;
    }
    
    public boolean login(String uname, String pwd){
        return uname.equals(this.userName) && pwd.equals(this.password);
    }
    
    public String getName(){
        return this.name;
    }
    
    public String getUserName(){
        return this.userName;
    }
     
}
