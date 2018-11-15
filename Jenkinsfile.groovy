pipeline {
    agent any
    stages{
        stage ('Build') {
            steps {
                 bat 'mvn clean package'
                       }
            post {
                success {
                    echo 'Now Archiving...'
                    archiveArtifacts artifacts: '**/target/*.war'
                }
            }
        }
	stage ('Deploy to Test Env') {
	    steps {
	         build job : 'JenkinsDeployArtifactToTestEnvironmentJob'
		 }
          }
    }
}