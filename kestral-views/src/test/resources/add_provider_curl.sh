#!/bin/bash
curl -iv --raw --header "Content-Type: application/json" --header "Accept: application/json" --request POST -d '{"username":"n.groark", "password":"yumyum", "user":{"userType":"P","firstName":"Niall","secondName":"Groak","contactEmail":"niall@gamil.com","company":{"id":"1"}}}' http://localhost:8093/kestral/logins/add
