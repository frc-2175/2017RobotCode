void setBuildStatus(String message, String state) {
  step([
      $class: "GitHubCommitStatusSetter",
      reposSource: [$class: "ManuallyEnteredRepositorySource", url: "https://github.com/frc-2175/2017RobotCode"],
      errorHandlers: [[$class: "ChangingBuildStatusErrorHandler", result: "UNSTABLE"]],
      statusResultSource: [ $class: "ConditionalStatusResultSource", results: [[$class: "AnyBuildResult", message: message, state: state]] ]
  ]);
}

node {
  env.PATH = "${tool 'ant'}\\bin;${env.PATH}"
  withEnv(['JAVA_HOME=C:\\Program Files\\Java\\jdk1.8.0_111']) {
    int testCount = 0
    int failureCount = 0
    setBuildStatus("Build #${env.BUILD_NUMBER} in progress", 'PENDING')

    stage ('Checkout') {
      checkout scm
    }
    stage ('Build and Test') {
      try {
        bat 'ant clean-jar'
      } catch (Exception e) {} 
      step([$class: 'JUnitResultArchiver', testResults: 'buildtest/results/*.xml'])
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
      }
    }
    stage ('Deploy') {
      try {
        bat 'ant deploy'
      } catch (Exception e) {}
    }
    stage ('Update GitHub Status') {
      if (failureCount > 0) {
        setBuildStatus("Build #${env.BUILD_NUMBER} failed. ${testCount - failureCount}/${testCount} tests passed.", "FAILURE")
      } else {
        setBuildStatus("Build #${env.BUILD_NUMBER} succeeded. ${testCount - failureCount}/${testCount} tests passed.", "SUCCESS")
      }
    }
  }
}

