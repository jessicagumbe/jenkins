pipeline
{
    agent any
  tools{
        maven '3.9.2'
    }

    environment {
        registry = "lorenajessica/spring-jenkins"
        registryCredential = 'lorenajessica_docker_hub'
        dockerImage = ''
    }
    stages
    {
        stages{
               stage('Build Maven'){
                   steps{
                       checkout scmGit(branches: [[name: '*/main']], extensions: [], userRemoteConfigs: [[credentialsId: 'jessicagumbe', url: 'https://github.com/jessicagumbe/jenkins']])
                       sh 'mvn clean install -DskipTests'
                   }
               }


         stage('Build image'){
                  steps{
                      script{
                          dockerImage = docker.build registry + ":$BUILD_NUMBER"
                      }
                  }
         }

      stage('Build conteiner'){
          steps{
               sh "docker run --name spring-jenkins -p 8081:8081   -d --restart unless-stopped lorenajessica/spring-jenkins:"+"$BUILD_NUMBER"


          }
      }


     stage('Push image'){
         steps{
             script{
                   docker.withRegistry( '', registryCredential ) {
                     dockerImage.push()
                   }
             }
        }
            }
post {
        always {
              bat 'docker logout'
        }
    }

}