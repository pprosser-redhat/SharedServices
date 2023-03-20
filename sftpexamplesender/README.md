# sftpexample

Create a directory called ~/files/customer1/send

java -Dcustomer.user=phil -jar target/quarkus-app/quarkus-run.jar

Create Container image

podman build --tag sftpsender:v1 -f src/main/docker/Dockerfile.jvm .

podman run -d --name sftpsender_{{customer}} --volume /whocares/{{customer}}:/opt/{{customer}}:Z \
-e sftphost=rhel8 \
-e customer.file.directory=/opt/{{customer}}/send \
-e customer.public.key=file:/opt/{{customer}}/pubtoken/public.gpg \
-e customer.keyUserid={{customer}} \
-e customer.name={{customer}} \
-e superuser.user=root \
-e superuser.password=welcome1 \
quay.io/philprosser/sftpsender:v1


------ phil example -----
podman run -d --name sftpsender_customer1 --volume /home/phil/files/customer1:/opt/customer1:Z \
-e sftphost=rhel8 \
-e customer.file.directory=/opt/customer1/send \
-e customer.public.key=file:/opt/customer1/pubtoken/public.gpg \
-e customer.keyUserid=pprosser@redhat.com -e customer.name=phil \
-e superuser.user=root \
-e superuser.password=welcome1 \
quay.io/philprosser/sftpsender:v1


----- test2 example -----
podman run --name sftpsender_test2 --volume /home/phil/files/test2:/opt/test2:Z \
-e sftphost=rhel8 \
-e customer.file.directory=/opt/test2/send \
-e customer.public.key=file:/opt/test2/pubtoken/test2pubtoken.key \
-e customer.keyUserid=test2 \
-e customer.name=test2 \
-e superuser.user=root \
-e superuser.password=welcome1 \
quay.io/philprosser/sftpsender:v1


----- test1 example on demolab -----
podman run -d --name sftpsender_test1 --volume /home/pprosser/test1/files/:/opt/test1:Z \
-e sftphost=sftpdemo.pprosser.demolab.local \
-e customer.file.directory=/opt/test1/send \
-e customer.public.key=file:/opt/test1/pubtoken/publickey.key \
-e customer.keyUserid=test1 \
-e customer.name=test1 \
-e superuser.user=test1 \
-e superuser.password=redhat123 \
-e ssh.private.key=/home/pprosser/sshkeypair/integration
-e ssh.private.password=redhat123
quay.io/philprosser/sftpsender:v1

create new pgp keys (did it on RHEL)

gpg –full-generate-key
gpg –export -a keyid > publickeyname.key
gpg –export-secret-key -a keyid > privatekeyname.key


------- 
Create SSH key pairs for to allow the integration server to post files
-------

ssh-keygen 
Generating public/private rsa key pair.
Enter file in which to save the key (/home/apd/.ssh/id_rsa): id_rsa_int
Enter passphrase (empty for no passphrase): 
Enter same passphrase again: 
Your identification has been saved in id_rsa_int.
Your public key has been saved in id_rsa_int.pub.
The key fingerprint is:
SHA256:ZUuHGYtqfYl5vlUAP67eNqZwDMYMFcpsWq6JM/JKTZA apd@wtfben
The key's randomart image is:
+---[RSA 3072]----+
|        o.o      |
|  .  o o . B     |
| E    B . B =    |
|  .  = * * = o   |
|   .. + S = . .  |
|  o. + . * . .   |
|..+.o   . = .    |
|.o o     + ++    |
|...       ++..   |
+----[SHA256]-----+
[apd@wtfben ~]$ ssh-copy-id -i /home/apd/id_rsa_int test1@apd.demolab.local
/usr/bin/ssh-copy-id: INFO: Source of key(s) to be installed: "/home/apd/id_rsa_int.pub"
/usr/bin/ssh-copy-id: INFO: attempting to log in with the new key(s), to filter out any that are already installed
/usr/bin/ssh-copy-id: INFO: 1 key(s) remain to be installed -- if you are prompted now it is to install the new keys
Password: 

Number of key(s) added: 1

Now try logging into the machine, with:   "ssh 'test1@apd.demolab.local'"
and check to make sure that only the key(s) you wanted were added.


Downloaded the integration private key to login to the sftp server

/Users/pprosser/files/privatekey/integration


need to ssh-copy public key to sftp server