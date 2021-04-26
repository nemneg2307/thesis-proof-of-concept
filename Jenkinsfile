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
                failure{
                        slackSend (color: '#FF0000', message: "Job '${env.JOB_NAME}, Build nr. [${env.BUILD_NUMBER}]', Result: FAILED -> (${env.BUILD_URL})")
                    }
                success{
                    slackSend (color: '#008000', message: "Job '${env.JOB_NAME}, Build nr. [${env.BUILD_NUMBER}]', Result: SUCCEEDED -> (${env.BUILD_URL})")
                }
                unstable{
                    slackSend (color: '#FFFF00', message: "Job '${env.JOB_NAME}, Build nr. [${env.BUILD_NUMBER}]', Result: UNSTABLE -> (${env.BUILD_URL})")
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
