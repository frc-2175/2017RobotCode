repoURL = 'https://github.com/frc-2175/2017RobotCode'
jdk = 'jdk1.8.0_111'
slackChannel = '#code'

void setBuildStatus(String message, String state) {
  step([
      $class: 'GitHubCommitStatusSetter',
      reposSource: [$class: 'ManuallyEnteredRepositorySource', url: repoURL],
      errorHandlers: [[$class: 'ChangingBuildStatusErrorHandler', result: 'UNSTABLE']],
      statusResultSource: [ $class: 'ConditionalStatusResultSource', results: [[$class: 'AnyBuildResult', message: message, state: state]] ]
  ]);
}

node {
  env.PATH = "${tool 'ant'}\\bin;${env.PATH}"
  withEnv(["JAVA_HOME=C:\\Program Files\\Java\\${jdk}"]) {
    int testCount = 0
    int failureCount = 0
    int skippedCount = 0
    boolean deploySuccess = true

    setBuildStatus("Build #${env.BUILD_NUMBER} in progress", 'PENDING')

    stage ('Checkout') {
      checkout scm
    }
    stage ('Build and Test') {
      try {
        bat 'ant clean-jar'
      } catch (Exception e) {} 
      step([$class: 'JUnitResultArchiver', testResults: 'buildtest/results/*.xml', allowEmptyResults: true])
      def xmlFiles = findFiles(glob: 'buildtest/results/*.xml')
      for (int i = 0; i < xmlFiles.length; i++) {
        def file = xmlFiles[i]
        def contents = readFile file.getPath()
        
        def testsMatcher = contents =~ 'tests="([^"]+)"'
        def tests = testsMatcher ? testsMatcher[0][1] : null
        if (tests != null) {
          testCount += tests.toInteger()
        }
        
        def failureMatcher = contents =~ 'failures="([^"]+)"'
        def failures = failureMatcher ? failureMatcher[0][1] : null
        if (failures != null) {
          failureCount += failures.toInteger()
        }
        
        def skippedMatcher = contents =~ 'skipped="([^"]+)"'
        def skipped = skippedMatcher ? skippedMatcher[0][1] : null
        if (skipped != null) {
          skippedCount += skipped.toInteger()
        }
      }
    }
    stage ('Deploy') {
      try {
        bat 'ant deploy'
      } catch (Exception e) {
        currentBuild.result = 'ERROR'
        deploySuccess = false
      }
    }
    stage ('Update GitHub Status & Notify') {
      boolean overallSuccess = (failureCount == 0 && deploySuccess)
      
      def githubStatusMessage = "Build #${env.BUILD_NUMBER} ${overallSuccess ? 'succeeded' : 'failed'}."
      githubStatusMessage = " ${testCount - failureCount}/${testCount} tests passed, deploy ${deploySuccess ? 'succeeded' : 'failed'}."
      
      setBuildStatus(githubStatusMessage, overallSuccess ? 'SUCCESS' : 'FAILURE')
      
      if (env.BRANCH_NAME == 'master') {
        def slackMessage = "Build #${env.BUILD_NUMBER} ${overallSuccess ? 'Success' : 'Failure'}"
        slackMessage += "\nTest Status:\n    Passed: ${testCount - failureCount}, Failed: ${failureCount}, Skipped: ${skippedCount}"
        slackMessage += "\nDeploy Result:\n    ${deploySuccess ? 'Success' : 'Failure'}"
        
        slackSend channel: slackChannel, color: (overallSuccess ? 'good' : 'danger'), message: slackMessage
      }
    }
  }
}
