
package com.eniso.tp3;

/**
 *
 * @author HP
 */
class XORCipher {
     private String key;
   public XORCipher(String key){
       this.key = key;
   } 
   
   
   
   public String encrypt(String plaintext){
       StringBuilder ciphertext = new StringBuilder();
       for(int i=0 ; i<plaintext.length() ; i++){
           char plaintextChar = plaintext.charAt(i);
           char keyChar = key.charAt(i % key.length());
           int XorResult = plaintextChar ^ keyChar;
           ciphertext.append((char) XorResult);
       }
      return ciphertext.toString();
   }
    public String decrypt(String ciphertext) {
        StringBuilder decryptedText = new StringBuilder();
        for (int i = 0; i < ciphertext.length(); i++) {
            char cipherChar = ciphertext.charAt(i);
            char keyChar = key.charAt(i % key.length());
            int xorResult = cipherChar ^ keyChar;
            decryptedText.append((char) xorResult);
        }
        return decryptedText.toString();
    }
}
