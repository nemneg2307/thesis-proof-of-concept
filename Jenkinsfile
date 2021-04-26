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
            post {

                failure{

                    slackSend (color: '#FF0000', message: "Build ${env.JOB_NAME}[${env.BUILD_NUMBER}] FAILED \n(http://dev-jenkins.duckdns.org:8081/job/${env.JOB_NAME}/${env.BUILD_NUMBER}/)")
                }
                success{
                    slackSend (color: '#008000', message: "Build ${env.JOB_NAME}[${env.BUILD_NUMBER}] SUCCEEDED \n(http://dev-jenkins.duckdns.org:8081/job/${env.JOB_NAME}/${env.BUILD_NUMBER}/)")
                }
                unstable{
                    slackSend (color: '#FFFF00', message: "Build ${env.JOB_NAME}[${env.BUILD_NUMBER}] UNSTABLE \n(http://dev-jenkins.duckdns.org:8081/job/${env.JOB_NAME}/${env.BUILD_NUMBER}/)")
                }
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

                    slackSend (color: '#FF0000', message: "Test ${env.JOB_NAME}[${env.BUILD_NUMBER}] FAILED \n(http://dev-jenkins.duckdns.org:8081/job/${env.JOB_NAME}/${env.BUILD_NUMBER}/)")
                }
                success{
                    slackSend (color: '#008000', message: "Test ${env.JOB_NAME}[${env.BUILD_NUMBER}] SUCCEEDED \n(http://dev-jenkins.duckdns.org:8081/job/${env.JOB_NAME}/${env.BUILD_NUMBER}/)")
                }
                unstable{
                    slackSend (color: '#FFFF00', message: "Test ${env.JOB_NAME}[${env.BUILD_NUMBER}] UNSTABLE \n(http://dev-jenkins.duckdns.org:8081/job/${env.JOB_NAME}/${env.BUILD_NUMBER}/)")
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
