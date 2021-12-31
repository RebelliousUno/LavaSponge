pipeline {
    agent any
    triggers {
        pollSCM 'H * * * *'
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
        stage('upload to s3') {
            steps {
                s3Upload consoleLogLevel: 'INFO', dontSetBuildResultOnFailure: false, dontWaitForConcurrentBuildCompletion: false, entries: [[bucket: 'lavasponge-artefacts/${BRANCH_NAME}', excludedFile: '', flatten: true, gzipFiles: false, keepForever: false, managedArtifacts: false, noUploadOnFailure: false, selectedRegion: 'us-east-1', showDirectlyInBrowser: false, sourceFile: '**/build/libs/*.jar', storageClass: 'STANDARD', uploadFromSlave: false, useServerSideEncryption: false]], pluginFailureResultConstraint: 'FAILURE', profileName: 'S3TravisAccess', userMetadata: []
            }
        }
    }
    post {
        always{
            archiveArtifacts artifacts: 'build/libs/**/*.jar', fingerprint: true
        }
    }
}
