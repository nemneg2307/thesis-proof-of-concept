pipeline {
    agent any
    tools {
        maven 'Maven'
    }
    environment {
            ASDF = '<a href="http://dev-jenkins.duckdns.org:8081/job/${env.JOB_NAME}/${env.BUILD_NUMBER}/">Link</a>'
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

                        slackSend (color: '#FF0000', message: "Job '${env.JOB_NAME}, Build nr. [${env.BUILD_NUMBER}]', Result: FAILED -> (http://dev-jenkins.duckdns.org:8081/job/${env.JOB_NAME}/${env.BUILD_NUMBER}/)")
                    }
                success{
                    slackSend (color: '#008000', message: "Job '${env.JOB_NAME}, Build nr. [${env.BUILD_NUMBER}]', \n Result: SUCCEEDED -> ${env.ASDF}")
                }
                unstable{
                    slackSend (color: '#FFFF00', message: "Job '${env.JOB_NAME}, Build nr. [${env.BUILD_NUMBER}]', Result: UNSTABLE -> (http://dev-jenkins.duckdns.org:8081/job/${env.JOB_NAME}/${env.BUILD_NUMBER}/)")
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
