package sharedservices.encryption;

import java.security.Key;
import java.security.KeyStore;

import org.apache.camel.util.jsse.KeyStoreParameters;

public class EncryptionKeys {

    // TODO remove this once keystoreparam support added to crypto dataformat
    public static Key loadKey() throws Exception {
        KeyStoreParameters keystore = new KeyStoreParameters();
        keystore.setPassword("supersecret");
        keystore.setResource("cia_secrets.jceks");
        keystore.setType("JCEKS");
        
        KeyStore store = keystore.createKeyStore();
        return store.getKey("ciasecrets", "secret".toCharArray());
    }
}