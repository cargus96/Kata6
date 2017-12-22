
package kata6.Modelo;
public class Mail {
    private final Integer id;
    private final String mail;
    
    public Mail(String mail,Integer id) {
        this.mail = mail;
        this.id=id;
    }
    
    public Integer getId(){
        return id;
    }
    public String getMail() {
        return mail;
    }
}
