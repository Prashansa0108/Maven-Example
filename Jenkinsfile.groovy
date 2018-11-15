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
                    archiveArtifacts artifacts: 'C:\Program Files\Jenkins\workspace\PackageForPipelineJob\webapp\src\main\webapp\target\*.war'
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