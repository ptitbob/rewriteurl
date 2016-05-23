## Réécriture d'URL via un proxy / loadBalancer

execution de docker-compose avec un fichier spécifique

```shell
docker-compose -f docker-compose.ha.yml up
```

appel :

```shell
http -h localhost/web1
```


Suppression de tous les containers:

```shell
docker-compose -f docker-compose.ha.yml rm --all -f
```

lancer le test (penser à mettre la demonstration en partant de la racine du projet)
```shell
gatling.sh -sf src/test/scala/ -s src/test/scala/GetWeb.scala -rf result/ -on web

ou pour laisser le choix : 

gatling.sh -sf src/test/scala/ -rf result/ -on web
```
