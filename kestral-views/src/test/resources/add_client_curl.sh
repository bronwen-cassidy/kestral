#!/bin/bash

curl -iv --raw --header "Content-Type: application/json" --header "Accept: application/json" --request POST -d '{"firstName":"Lloyd", "secondName":"Fitzgibbon", "company": {"id":"1"} }' http://localhost:8093/kestral/providers/provider/add
