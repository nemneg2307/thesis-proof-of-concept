pipeline {
    agent any
    tools {
        maven 'Maven'
    }
    stages {
        stage("build"){
            steps {
                echo 'building the app...'
                sh 'mvn clean compile'
            }
        }

        stage("test"){
            steps {
                echo 'testing the app...'
                sh 'mvn test'
            }
            post {
                always{
                        slackSend (color: '#FF0000', message: "Job '${env.JOB_NAME} [${env.BUILD_NUMBER}]' (${env.BUILD_URL})")
                    }
            }
        }

        stage("deploy"){
            steps {
                echo 'deploying the app...'
                //sh 'mvn -B -DskipTests clean package'
            }
        }
    }
}
