## Réécriture d'URL via un proxy / loadBalancer

Petit projet accompagnant le post [Réécriture d'URL via un  proxy](http://www.shipstone.org/2016/05/25/reecriture-durl-via-un-proxy/). Ou comment gérer la rééecriture d'URL dans docker entre le proxy porte d'entrée et les serveurs de destination.

Mais aussi l'occasion de comparer HAProxy et Traefik.

---

Quelques lignes de commande - aide mémoire

execution de docker-compose avec un fichier spécifique

```shell
docker-compose -f docker-compose.ha.yml up
```

Utilisation de HTTPie pour faire un appel en ligne de commande

```shell
http -h localhost/web1
```

Suppression de tous les containers:

```shell
docker-compose -f docker-compose.ha.yml rm --all -f
```

lancer le test (penser à mettre la demonstration en partant de la racine du projet)

```shell
gatling.sh -sf src/test/scala/ -s src/test/scala/Web1Web2_1User_3Times.scala -rf result/ -on web
```

ou pour laisser le choix :

```
gatling.sh -sf src/test/scala/ -rf result/ -on web
```
