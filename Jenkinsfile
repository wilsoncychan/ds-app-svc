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
                maven:"maven3",
                options: [jacocoPublisher(disabled: true)]
            ) {
                sh """
                    mvn clean verify
                """
            }
        }

        stage('Code Coverage') {
            jacoco(
                classPattern: "target/classes/com/rad/kit/dsappsvc/service",
                execPattern: "target/jacoco.exec",
                inclusionPattern: '**/*.class',
                exclusionPattern: '**/DsAppSvcApplication.class,**/DsAppSvcConfig.class',
                sourceInclusionPattern: '**/*.java',
                sourcePattern: 'src/main/java',
                buildOverBuild: true,
                changeBuildStatus: true,
                deltaBranchCoverage: '100',
                deltaComplexityCoverage: '100',
                deltaInstructionCoverage: '100',
                deltaClassCoverage: '0',
                deltaLineCoverage: '0',
                deltaMethodCoverage: '0',
                maximumClassCoverage: '100',
                maximumLineCoverage: '100',
                maximumMethodCoverage: '100',
                minimumClassCoverage: '100',
                minimumLineCoverage: '100',
                minimumMethodCoverage: '100'
            )
        }

        currentBuild.result = 'SUCCESS';
    } catch (err) {
        currentBuild.result = 'FAILED';
    } finally {
    }
}
