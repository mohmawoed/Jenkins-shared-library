#!/usr/bin/env groovy

def call() {
    echo "Building images."
    withCredentials([usernamePassword(credentialsId: 'docker-hub-repo', passwordVariable: 'PASS', usernameVariable: 'USER')]) {
        sh 'docker build -t  mohmawoed/demo-app:jma2.0 .'
        sh "echo $PASS | docker login -u $USER --password-stdin"
        sh 'docker push mohmawoed/demo-app:jma2.0'
    }
}