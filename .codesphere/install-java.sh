cd /home/user
if ! [ -d jdk-17.0.7 ]; then
wget https://download.oracle.com/java/17/latest/jdk-17_linux-x64_bin.tar.gz
tar -xvf jdk-17_linux-x64_bin.tar.gz
rm jdk-17_linux-x64_bin.tar.gz
fi