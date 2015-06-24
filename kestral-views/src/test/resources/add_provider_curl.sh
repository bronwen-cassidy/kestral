#!/bin/bash

curl -iv --raw --header "Content-Type: application/json" --header "Accept: application/json" --request POST -d '{"user":{"userType":"P","firstName":"Niall","secondName":"Groak","contactEmail":"niall@gamil.com","company":{"id":"1"},"loginInfo":{"username":"niall.groak","password":"nomnom"}}}' http://localhost:8093/kestral/providers/provider/add
