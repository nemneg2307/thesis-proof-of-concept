pipeline {
    agent any
    tools {
        maven 'Maven'
    }
    environment
    stages {
        stage("build"){
            steps {
                echo 'building the app...'
                sh 'mvn -B -DskipTests clean package'
            }
        }

        stage("test"){
            when {
                expression{
                    BRANCH_NAME == 'develop'
                }
            }
            steps {
                echo 'testing the app...'
                //sh 'mvn -B -DskipTests clean package'
            }
        }

        stage("deploy"){
            steps {
                echo 'deploying the app...'
                //sh 'mvn -B -DskipTests clean package'
            }
        }
    }
    post{
        always{
            //will be executed always
        }
        success{
            //only if succeeded
        }
        failure {
            //only if failed
        }
    }
}