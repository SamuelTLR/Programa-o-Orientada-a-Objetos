       /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package agenda;

/**
 *
 * @author aluno
 */
public class Contato {
    private String nome;
    private String endereco;
    private String numero;
    private String email;
    
    public Contato() {
        nome = "";
        endereco = "";
        numero = "";
        email = "";
    }
    public Contato(String nome, String endereco, String numero, String email) {
        this.nome = nome;
        this.endereco = endereco;
        this.numero = numero;
        this.email = email;
    }
    
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getEndereco() {
        return endereco;
    }
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
    public String getNumero() {
        return numero;
    }
    public void setNumero(String numero) {
        this.numero = numero;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    
}
