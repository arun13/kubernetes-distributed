#!/usr/bin/env bash
 kubectl apply -f ./k8s/kubernetes-distributed-deployment.tpl.yml
 kubectl apply -f ./k8s/kubernetes-distributed-service.tpl.yml