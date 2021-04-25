pipeline {
    agent {
        docker {
            image 'maven:3.8.1-adoptopenjdk-11'
            args '-v /root/.m2:/root/.m2'
        }
    }
    stages {
        stage("build"){
            steps {
                echo 'building the app...'
                //sh 'mvn -B -DskipTests clean package'
            }
        }

        stage("test"){
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
}