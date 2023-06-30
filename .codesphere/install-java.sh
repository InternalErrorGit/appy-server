cd /home/user
if ! [ -d jdk-19.0.2 ]; then
wget https://download.oracle.com/java/17/latest/jdk-17_linux-x64_bin.tar.gz
tar -xvf openjdk-19.0.2_linux-x64_bin.tar.gz
rm openjdk-19.0.2_linux-x64_bin.tar.gz
fi