package View;
import javax.crypto.*;
import javax.crypto.spec.*;
 
public class ViewCriptografia {
    public String Descriptografa(String linha){
    	String retorno = "";
    	try {
        	
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            byte[] mensagem = linha.getBytes();
 
            // Usando chave de 128-bits (16 bytes)
            byte[] chave = "chave de 16bytes".getBytes();
            
            // Decriptando...
            cipher.init(Cipher.DECRYPT_MODE, new SecretKeySpec(chave, "AES"));
            byte[] decrypted = cipher.doFinal(mensagem);
            retorno = (new String(decrypted));
            
        } catch (Exception e) {
           e.printStackTrace();
        }
	
		return retorno;
    
    
    }
    
}

