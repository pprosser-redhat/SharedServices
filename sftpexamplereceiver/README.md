
---- Example for test2 sftp file consumer

java -Dcustomer.user=test2 -Dcustomer.file.directory=/Users/pprosser/files/test2/received -Dcustomer.password='r"dh4t1!' -Dcustomer.privateKeyFileName=file:/Users/pprosser/files/test2/privtoken/test2privatekey.key -Dcustomer.keyUserid=test2 -Dcustomer.keypassword=welcome1 -jar target/quarkus-app/quarkus-run.jar

--- Examp[le for phil sftp file consumer 

java -Dcustomer.user=phil -Dcustomer.file.directory=/Users/pprosser/files/customer1/received -Dcustomer.password=welcome1 -Dcustomer.privateKeyFileName=file:/Users/pprosser/files/customer1/privtoken/secret.asc -Dcustomer.keyUserid=pprosser@redhat.com -Dcustomer.keypassword=secret -jar target/quarkus-app/quarkus-run.jar

--- Examp[le for test1 sftp file consumer on demolab

java -Dsftphost=sftpdemo.pprosser.demolab.local -Dcustomer.user=test1 -Dcustomer.file.directory=/Users/pprosser/files/test1/received -Dcustomer.password=redhat123 -Dcustomer.privateKeyFileName=file:/Users/pprosser/files/test1/privkey/privatekey.key -Dcustomer.keyUserid=test1 -Dcustomer.keypassword=redhat123 -jar target/quarkus-app/quarkus-run.jar