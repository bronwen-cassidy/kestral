#!/bin/bash

curl -iv --raw --header "Content-Type: application/json" --header "Accept: application/json" --request POST -d '{"user": {"userType":"P","firstName":"Lloyd", "secondName":"Fitzgibbon""contactEmail":"lloyd@gamil.com"}, "company": {"id":"1"}}' http://localhost:8093/kestral/providers/provider/add
