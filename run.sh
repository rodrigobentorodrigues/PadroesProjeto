cd postgres
sh run.sh
cd ../
sudo docker build -t padroes/web .
sudo docker run -p 8081:8080 -d --name web_padroes --link banco_padroes:banco_padroes padroes/web