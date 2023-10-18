pipeline {
   agent any
   stages {
      stage('Build') {
         steps {
            // Get some code from a GitHub repository
            checkout scmGit(branches: [[name: '*/main']], extensions: [], userRemoteConfigs: [[credentialsId: 'developer_github', url: 'https://github.com/jessicagumbe/jenkins']])
            sh 'mvn -Dmaven.test.failure.ignore=true clean compile'
         }
         }
      stage("Test") {
          steps {
           // git 'https://github.com/jglick/simple-maven-project-with-tests.git'
            sh "mvn -Dmaven.test.failure.ignore=true clean test"

          }

      }
      stage("Deploy") {
          steps {
           // git 'https://github.com/jglick/simple-maven-project-with-tests.git'
            sh "mvn -Dmaven.test.failure.ignore=true clean install"

          }
          post {
              success {
                  archiveArtifacts 'target/*.jar'
              }

          }


      }

      }
   }
