package org.demo;

import org.apache.camel.builder.RouteBuilder;

public class TestReceiveAndDecrypt extends RouteBuilder {

    @Override
    public void configure() throws Exception {
        
        from("sftp:{{sftphost}}:22/files/process?username={{customer.user}}&password={{customer.password}}&move=done&moveFailed=failed")

        .log("decrypting message")
        .unmarshal().pgp("{{customer.privateKeyFileName}}", "{{customer.keyUserid}}", "{{customer.keypassword}}")
        .log("writing file out")
        .to("file:{{customer.file.directory}}?fileName=${date:now:yyyyMMdd'_'}${file:name}")
        ;

    }
    
}
