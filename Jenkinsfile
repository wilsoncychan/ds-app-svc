#!groovy

node {
    try {
        env.JAVA_HOME="${tool 'jdk8'}"
        env.PATH="${env.JAVA_HOME}/bin:${env.PATH}"
        sh 'java -version'

        stage('Checkout') {

            // Clean workspace before doing anything
            deleteDir()

            checkout scm
        }

        stage('Build') {
            withMaven(
                maven:"maven3"
            ) {
                sh """
                    mvn clean verify
                """
            }
        }

        currentBuild.result = 'SUCCESS';
    } catch (err) {
        currentBuild.result = 'FAILED';
    } finally {
    }
}
