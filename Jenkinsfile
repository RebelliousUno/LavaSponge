pipeline {
    agent any
    triggers {
        cron 'H * * * *'
    }

    stages {

        stage('clean') {
            steps {
                echo 'cleaning'
                withGradle {
                    bat 'gradlew.bat clean'
                }
            }
        }
        stage('build') {
            steps {
                echo 'building'
                withGradle {
                    bat 'gradlew.bat build'
                }
            }
        }
        stage ('deploy') {
            steps {
                echo 'deploying'
            }
        }
    }
}