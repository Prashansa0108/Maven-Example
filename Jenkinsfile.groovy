pipeline{
    agent any
    stages{
        stage('Initialize'){
            steps{
                echo 'Initialize'
            }
            
        }
        stage('Build'){
            steps{
                echo 'Hello World'
            }
        }
    }
}
