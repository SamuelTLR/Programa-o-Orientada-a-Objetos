/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cifratomazela;

import java.util.List;

/**
 *
 * @author aluno
 */
public class Encryption {
    private static String alfabeto = "abcdefghijklmnopqrstuvwxyz"; 
    
    public static String encrypting(String message, int key) {
        char encryptingLetter;
        String encryptedMessage = "";
        int targetIndex;
        
        for(int i = 0; i < message.length(); i++) {
           encryptingLetter = Character.toLowerCase(message.charAt(i));
           targetIndex = (findLetterIndexInAlphabet(encryptingLetter) + key) % 26;
           encryptedMessage += findLetterInAlphabet(targetIndex);
        }
        return encryptedMessage;
    }
    
    public static String decrypting(String message, int key) {
        char decryptingLetter;
        String decryptedMessage = "";
        int targetIndex;
        
        for(int i = 0; i < message.length(); i++) {
            decryptingLetter = message.charAt(i);
            targetIndex = Math.abs((findLetterIndexInAlphabet(decryptingLetter) - key)) % 26;
            decryptedMessage += findLetterInAlphabet(targetIndex);
        }
        return decryptedMessage;
    }
    
    public static int findLetterIndexInAlphabet(char letter) {
        for(int i = 0; i < Encryption.alfabeto.length(); i++) {
            if(letter == Encryption.alfabeto.charAt(i)) {
                return i;
            }
        }
        return 0;
    }
    
    public static char findLetterInAlphabet(int index) {
        //System.out.println(index);;
        return Encryption.alfabeto.charAt(index);
    }
   
    
}
