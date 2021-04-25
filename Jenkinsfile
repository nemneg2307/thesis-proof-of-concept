pipeline {
    agent any
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