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
                always {
                    junit 'target/surefire-reports/*.xml' 
                }
                failure{

                        slackSend (color: '#FF0000', message: "Job '${env.JOB_NAME}, Build nr. [${env.BUILD_NUMBER}]', Result: FAILED -> (http://dev-jenkins.duckdns.org:8081/job/${env.JOB_NAME}/${env.BUILD_NUMBER}/)")
                }
                success{
                    slackSend (color: '#008000', message: "Job '${env.JOB_NAME}, Build nr. [${env.BUILD_NUMBER}]', \n Result: SUCCEEDED -> (http://dev-jenkins.duckdns.org:8081/job/${env.JOB_NAME}/${env.BUILD_NUMBER}/)")
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
