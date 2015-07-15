#!/bin/bash

#curl -iv --raw --header "Content-Type: application/json" --header "Accept: application/json" --request POST -d '{"username":"bodancassidy", "password":"Simpsons123", "user":{"userType":"C","firstName":"Bodie","secondName":"Cassidy","contactTelephone":"07946095164","contactEmail":"bodancassidyd@gamil.com","company":{"id":"1"}}}' http://localhost:8093/kestral/logins/add
curl -iv --raw --header "Content-Type: application/json" --header "Accept: application/json" --request POST -d '{"username":"jamie.dborin", "password":"harisons1", "user":{"userType":"C","firstName":"Jamie","secondName":"Dborin","contactTelephone":"07946095333","contactEmail":"jamdborin@gamil.com","company":{"id":"1"}}}' http://localhost:8093/kestral/logins/add
