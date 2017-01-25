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

int matchInt(String contents, String attributeName) {
  def matcher = contents =~ attributeName + '="([^"]+)"'
  def value = matcher ? matcher[0][1] : null
  if (value != null) {
    return value.toInteger()
  } else {
    return 0
  }
}

node {
  env.PATH = "${tool 'ant'}\\bin;${env.PATH}"
  withEnv(["JAVA_HOME=C:\\Program Files\\Java\\${jdk}"]) {
    int testCount = 0
    int failureCount = 0
    int skippedCount = 0
    boolean compileSuccess = true
    boolean deploySuccess = true
    boolean startupSuccess = true

    setBuildStatus("Build #${env.BUILD_NUMBER} in progress", 'PENDING')

    stage ('Checkout') {
      checkout scm
    }
    stage ('Build') {
      try {
        bat 'ant clean-compile'
      } catch (Exception e) {
        currentBuild.result = 'ERROR'
        compileSuccess = false
      }
    }
    if (compileSuccess) {
      stage ('Build and Test') {
        try {
          bat 'ant clean-jar'
        } catch (Exception e) {
          currentBuild.result = 'ERROR'
        } 
        step([$class: 'JUnitResultArchiver', testResults: 'buildtest/results/*.xml', allowEmptyResults: true])
        def xmlFiles = findFiles(glob: 'buildtest/results/*.xml')
        for (int i = 0; i < xmlFiles.length; i++) {
          def file = xmlFiles[i]
          def contents = readFile file.getPath()
          
          testCount += matchInt('tests')
          failureCount += matchInt('failures') 
          failureCount += matchInt('errors') // errors are treated as failures
          skippedCount += matchInt('skipped')
        }
      }
      if (failureCount == 0) {
        stage ('Deploy') {
          try {
            bat 'ant deploy'
          } catch (Exception e) {
            currentBuild.result = 'ERROR'
            deploySuccess = false
          }
        }
        if (deploySuccess) {
          stage ('Startup') {
            try {
              bat 'ant compile-listener'

              echo '--------------------------\nStarting practice robot\n--------------------------'
              bat 'deployPropertiesFiles_Practice.bat'
              timeout (time: 30, unit: 'SECONDS') {
                bat 'java -jar buildlistener\\listener.jar'
              }
              echo 'Practice robot started up successfully!\n'

              echo '--------------------------\nStarting competition robot\n--------------------------'
              bat 'deployPropertiesFiles_Competition.bat'
              timeout (time: 30, unit: 'SECONDS') {
                bat 'java -jar buildlistener\\listener.jar'
              }
              echo 'Competition robot started up successfully!\n'
            } catch (Exception e) {
              currentBuild.result = 'ERROR'
              startupSuccess = false
            }
          }
        }
      }
    }
    stage ('Update GitHub Status & Notify') {
      boolean overallSuccess = (compileSuccess && failureCount == 0 && deploySuccess && startupSuccess)
      
      def githubStatusMessage = "Compile ${compileSuccess ? 'succeeded' : 'failed'}"
      if (compileSuccess) {
        githubStatusMessage += ", ${testCount - failureCount}/${testCount} tests passed"
        if (failureCount == 0) {
          githubStatusMessage += ", deploy ${deploySuccess ? 'succeeded' : 'failed'}"
          if (deploySuccess) {
            githubStatusMessage += ", startup ${startupSuccess ? 'succeeded' : 'failed'}"
          }
        }
      }
      githubStatusMessage += '.'
      
      setBuildStatus(githubStatusMessage, overallSuccess ? 'SUCCESS' : 'FAILURE')
      
      if (env.BRANCH_NAME == 'master') {
        def slackMessage = "Build #${env.BUILD_NUMBER} ${overallSuccess ? 'Success' : 'Failure'}"
        slackMessage += "\nCompile Result:\n    ${compileSuccess ? 'Success' : 'Failure'}"

        if (compileSuccess) {
          slackMessage += "\nTest Status:\n    Passed: ${testCount - failureCount}, Failed: ${failureCount}, Skipped: ${skippedCount}"
          if (failureCount == 0) {
            slackMessage += "\nDeploy Result:\n    ${deploySuccess ? 'Success' : 'Failure'}"
            if (deploySuccess) {
              slackMessage += "\nStartup Result:\n    ${startupSuccess ? 'Success' : 'Failure'}"
            }
          }
        }
        
        slackSend channel: slackChannel, color: (overallSuccess ? 'good' : 'danger'), message: slackMessage
      }
    }
  }
}
