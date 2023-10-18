pipeline {
     agent any
     tools {
     maven 'maven'
     }
     stages {
        stage('Test') {
            steps {
                git 'https://github.com/jessicagumbe/jenkins.git'
                sh 'mvn test'
                archiveArtifacts artifacts: 'target/surefire-reports/**'
            }
        }
        stage('Build') {
            steps {
                sh 'mvn clean package -DskipTests'
                archiveArtifacts artifacts: 'target/*.jar'
            }
        }
        stage('Deploy') {
            steps {
                sh 'echo Deploy'
            }
        }

     }
}

