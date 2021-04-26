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
            buildStatus =  buildStatus ?: 'SUCCESSFUL'
          def colorName = 'RED'
          def colorCode = '#FF0000'
          def subject = "${buildStatus}: Job '${env.JOB_NAME} [${env.BUILD_NUMBER}]'"
          def summary = "${subject} (${env.BUILD_URL})"
            steps {
                echo 'testing the app...'
                sh 'mvn test'
            }
            post {
                always{
                        def colorName = 'RED'
                        def colorCode = '#FF0000'
                        def subject = "Job '${env.JOB_NAME} [${env.BUILD_NUMBER}]'"
                        def summary = "${subject} (${env.BUILD_URL})"

                        slackSend (color: colorCode, message: summary)
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
