
package kata6.Modelo;
public class Mail {
    private final String mail;

    public Mail(String mail) {
        this.mail = mail;
    }

    public String getMail() {
        return mail;
    }
    public String getDomain(){
        String email[] = this.mail.split("@");
        return email[1];
    }
}
