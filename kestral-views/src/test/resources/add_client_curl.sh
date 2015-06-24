#!/bin/bash

curl -iv --raw --header "Content-Type: application/json" --header "Accept: application/json" --request POST -d '{"user":{"userType":"C","firstName":"Lloyd","secondName":"Fitzgibbon","contactEmail":"lloyd@gamil.com","company":{"id":"1"},"loginInfo":{"username":"lloyd.fitzy","password":"superbanana7"}}}' http://localhost:8093/kestral/clients/client/add
