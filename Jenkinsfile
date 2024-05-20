pipeline {
    agent any
    stages {
        stage('Jenkins Account') {
            steps {
                echo 'Jenkins Account'
            }
        }
        stage('Build') { 
            steps {
                sh 'mvn clean install'
            }
        }    
        stage('Deploy on k8s') {
            steps {
                withCredentials([ string(credentialsId: 'minikube-credentials', variable: 'api_token') ]) {
                    sh 'kubectl --token $api_token --server https://host.docker.internal:55529  --insecure-skip-tls-verify=true apply -f ./k8s/deployment.yaml '
                    sh 'kubectl --token $api_token --server https://host.docker.internal:55529  --insecure-skip-tls-verify=true apply -f ./k8s/service.yaml '
                }
            }
        }
    } 
}
