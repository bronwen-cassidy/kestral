#!/bin/bash


curl -iv --raw --header "Content-Type: application/json" --header "Accept: application/json" --request POST -d '{"name":"TalentScope"}' http://localhost:8093/kestral/companies/company/add 


