pipeline {
    agent any
    tools {
        maven 'Maven 3.6.3'
        jdk 'openjdk-11'
    }
    stages {
        stage('verify') {
            steps {
                sh 'mvn -v'
            }
        }
        stage('compile') {
            steps {
                sh 'mvn clean package'
            }
        }
    }
}