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
      --volume /home/pprosser/sshkeypair:/opt/sshkey:Z \
-e sftphost=sftpdemo.pprosser.demolab.local \
-e customer.file.directory=/opt/test1/send \
-e customer.public.key=file:/opt/test1/pubtoken/publickey.key \
-e customer.keyUserid=test1 \
-e customer.name=test1 \
-e ssh.private.key=/opt/sshkey/id_rsa_integration \
-e ssh.private.password=redhat123 \
quay.io/philprosser/sftpsender:v1

----- example SFTP receiver command -----
java -Dsftphost=sftpdemo.pprosser.demolab.local \
-Dcustomer.file.directory=/Users/pprosser/files/customer1/received \
-Dcustomer.user=pat \
-Dcustomer.password=redhat123 \
-Dcustomer.privateKeyFileName=file:/Users/pprosser/files/customer1/pubtoken/privatekey.key \
-Dcustomer.keyUserid=test1 \
-Dcustomer.keypassword=redhat123 \
-jar target/quarkus-app/quarkus-run.jar

-----------------------------------------
Send a big file over

scp /Users/pprosser/Downloads/AMQStreamsDeepDive.pdf pprosser@integration.pprosser.demolab.local:/home/pprosser/john/files/send

-----------------------------------------
Log in to sftp server and get file

cd /Users/pprosser/files/customer1/received
sftp derby@sftpdemo.pprosser.demolab.local

-----------------------------------------

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


----------------------
example pgp public key
----------------------

-----BEGIN PGP PUBLIC KEY BLOCK-----

mQENBGQZgBQBCACvgq8FzkiKa1ncs5GNRub4U5Aey68qxlP0rkWM9Mt34yTJR8jV
93nut61xTUkJoJ0TtRZ6S6GJs/vMRvf6x747QowNFHpcU9+4DhH8QDoXIBExBTSv
moNzOzf/KIxy611i1A3tmMCA12u5LeM7UBnDnk6oG1n6eX6csDdVF8rybXGdatwk
pflCqht9txIbVrmhH6yPNDwVB0ZMshMab4wE9xAwFIB+arBobqO4OmbGo8nJqu8O
XS5M3wn0A8PS0K97LYzEJQoRMXc9MR98z/x3U1/3a4/7m7EOXCCcHyfG1PoZ8GSN
Tyk1+K67uDbyaiqnBKWhnNHwkKv3OMWG6SO5ABEBAAG0IXRlc3QxIChjb21tZW50
KSA8dGVzdDFAdGVzdDEuY29tPokBTgQTAQgAOBYhBDldtOOSuoq34/TfXsEVF4I/
s9ylBQJkGYAUAhsDBQsJCAcCBhUKCQgLAgQWAgMBAh4BAheAAAoJEMEVF4I/s9yl
KaQH/05eQpEob6HsRR0qlWlhj5TmkImle4/NUhkDF2ux59UfvwPsoiuNgxUDjAaC
AKmtSv19K8JrDJyPADI0pGIXfSTSGGls9Ll6MHtyRoCCmKtiWxk7fxNM56+0glBV
+GpF9Jg4x6tP2fwbkNKKKN1VzPwr+5BtBTkVcH68h34ZbrU0vmV+wubEptBYTn8L
GpId3LZI95Q+dNre98cHbakgMMJ8Tqc3W6m6x8JaJiTmrULxSJxEFFPrxFtlBWQh
TDr37CX9tHfCYPxjNsJKQXZ2K2Urj+GLmLSH8uHTZWBExzYihbDPPJ5DVcJU/Nwb
kCnEu4/K7riQT7cb3GitNDjOapG5AQ0EZBmAFAEIAPUkHDFE92FjLEwJEvLX0pB0
5QrtFirMUHsrs5ZR30rYwM7gKf+jUIkEGB2LOm6dk9d/9eJbwm2thUqNXEXxI+zU
J9CVUhJBC/pyw5tiUIihSGFF/uAePrPBkCh2zOxzvBPo/orh8zHad+numl27K9cV
t1Pl2N01sp/7B/Af8UyE2IEn3lOxfqGD+7Ssu9eoZ+iFDwsa9hi+0rLYuJ5iNz43
2RHnIi4l7e1umewNUbI0Ef7fSQfP1KyzDdubtJhGWNb97lFweoa5BChqVaylrB/b
kO3D2USFuMnxzV56wmsl/uX5Dap14WHAwze2o8MOs4jbu10Kg+ccMidXK3EQb20A
EQEAAYkBNgQYAQgAIBYhBDldtOOSuoq34/TfXsEVF4I/s9ylBQJkGYAUAhsMAAoJ
EMEVF4I/s9ylg5AH/iq+DTilq1Unzb1jid4Tptkqlk9MTcFjw5adSKDzvFr/IMJj
owO6es7UO6gr5lmYZqGxEsn8o/GdrRjq6dqb6I6YpcrucX9/2l4YoH4h/MHTcUrj
k5HlvcDrwEk3lYSfTCofAgtyvUBAKogn7DesqkubgvZj+vCi7vdXlbgJn/UREDiW
+ax4x67iOfJr2vwpdYfhrSENycdcZ4zPJkJ+x2peEwzsc2+gaUhYtD3gdzdnt/XR
2NyIMUJMWDjJM5PZTag1usDpQrrOVRH7yoqqKiK9dQVy7RaEDdlVcm9XCUvYZE2h
/PvdVGak5j6scmsTi3o3PG/kqU+EtA2DyzqYRk0=
=RXCW
-----END PGP PUBLIC KEY BLOCK-----


need to ssh-copy public key to sftp server

To be able to read the private key in the container I need to change the permissions - chmod 644 to the private key

example send from my laptop

scp Red Hackfest\ Red\ Hat\ Integration\ -\ Technical\ Overview.pdf pprosser@integration.pprosser.demolab.local:/home/pprosser/test1/files/send



