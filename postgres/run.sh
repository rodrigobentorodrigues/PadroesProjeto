sudo docker build -t padroes/banco .
sudo docker run -p 5434:5432 -d --name banco_padroes padroes/banco