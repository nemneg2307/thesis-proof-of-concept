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
                  notifyBuild('STARTED')
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
    def notifyBuild(String buildStatus = 'STARTED') {
      // build status of null means successful
      buildStatus =  buildStatus ?: 'SUCCESSFUL'

      // Default values
      def colorName = 'RED'
      def colorCode = '#FF0000'
      def subject = "${buildStatus}: Job '${env.JOB_NAME} [${env.BUILD_NUMBER}]'"
      def summary = "${subject} (${env.BUILD_URL})"


      // Send notifications
      slackSend (color: colorCode, message: summary)
    }
}
